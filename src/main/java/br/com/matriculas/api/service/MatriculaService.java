package br.com.matriculas.api.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

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
        
        int vagasTotais = turmaEncontrada.getVagasTotais();
        
        int numeroDeAlunosMatriculados = turmaEncontrada.getMatriculas().size();

        if (numeroDeAlunosMatriculados < vagasTotais) {
            // TEM VAGA
            novaMatricula.setStatus(StatusMatricula.CONFIRMADO);
            novaMatricula.setPosicao(null);                        // IMPORTANTE: Adicionamos a matrícula na lista da Turma para atualizar a contagem na próxima vez
            turmaEncontrada.getMatriculas().add(novaMatricula);
            
        } else {
            // Não tem vagas na turma, vai pra lista de espera
        	
            novaMatricula.setStatus(StatusMatricula.ESPERA);
            novaMatricula.setPosicao(999);
            
            turmaEncontrada.getMatriculas().add(novaMatricula);
        }

        return matriculaRepository.salvar(novaMatricula);
    }
}