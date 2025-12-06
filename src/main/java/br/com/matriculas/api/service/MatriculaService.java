package br.com.matriculas.api.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


import br.com.matriculas.api.model.AlunoModel;
import br.com.matriculas.api.model.MatriculaModel;
import br.com.matriculas.api.model.StatusMatricula;
import br.com.matriculas.api.model.TurmaModel;
import br.com.matriculas.api.repository.AlunoRepository;
import br.com.matriculas.api.repository.MatriculaRepository;
import br.com.matriculas.api.repository.TurmaRepository;

@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final TurmaRepository turmaRepository;
    private final AlunoRepository alunoRepository;

    public MatriculaService(MatriculaRepository matriculaRepo, TurmaRepository turmaRepo, AlunoRepository alunoRepo) {
        this.matriculaRepository = matriculaRepo;
        this.turmaRepository = turmaRepo;
        this.alunoRepository = alunoRepo;
    }

    public MatriculaModel realizarMatricula(MatriculaModel novaMatricula) {

        // Buscar aluno e turma
        String matriculaAluno = novaMatricula.getAluno().getMatricula();
        String codigoTurma = novaMatricula.getTurma().getCodigo();

        AlunoModel alunoEncontrado = alunoRepository.buscarPorMatricula(matriculaAluno);
        TurmaModel turmaEncontrada = turmaRepository.buscarPorCodigo(codigoTurma);

        if (alunoEncontrado == null) {
            throw new RuntimeException("Aluno não encontrado: " + matriculaAluno);
        }
        if (turmaEncontrada == null) {
            throw new RuntimeException("Turma não encontrada: " + codigoTurma);
        }

        novaMatricula.setAluno(alunoEncontrado);
        novaMatricula.setTurma(turmaEncontrada);

        // Verificar vagas
        List<MatriculaModel> todos = new ArrayList<>();
        todos.addAll(turmaEncontrada.getMatriculasConfirmadas());
        todos.addAll(turmaEncontrada.getFilaDeEspera());
        todos.add(novaMatricula);


       
       //ORDENAR POR IRA (descendente – maior primeiro)
  
        todos.sort((m1, m2) ->
                Double.compare(m2.getAluno().getIra(), m1.getAluno().getIra())
        );


       
        //LIMPAR LISTAS ANTIGAS
        turmaEncontrada.getMatriculasConfirmadas().clear();
        turmaEncontrada.getFilaDeEspera().clear();
        
        //DISTRIBUIR ENTRE CONFIRMADOS E FILA
        int vagas = turmaEncontrada.getVagasTotais();

        for (int i = 0; i < todos.size(); i++) {

            MatriculaModel m = todos.get(i);
            
            m.setPosicao(i+1);
            
            if (i < vagas) {
                // CONFIRMADO
                m.setStatus(StatusMatricula.CONFIRMADO);
                turmaEncontrada.getMatriculasConfirmadas().add(m);

            } else {
                // ESPERA
                m.setStatus(StatusMatricula.ESPERA);
                turmaEncontrada.getFilaDeEspera().add(m);
            }
        }

        
        //SALVAR MATRÍCULA DA VEZ
        return matriculaRepository.salvar(novaMatricula);
    }

}
