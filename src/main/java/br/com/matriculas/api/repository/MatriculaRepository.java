package br.com.matriculas.api.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.matriculas.api.model.MatriculaModel;

@Repository
public class MatriculaRepository {

    private static List<MatriculaModel> bancoDeMatriculas = new ArrayList<>();

    public MatriculaModel salvar(MatriculaModel matricula) {
        bancoDeMatriculas.add(matricula);
        return matricula;
    }

    // Listar todas as matrículas
    public List<MatriculaModel> buscarTodas() {
        return bancoDeMatriculas;
    }
    
    public List<MatriculaModel> buscarPorTurma(String codigoTurma) {
        return bancoDeMatriculas.stream()
                .filter(m -> m.getTurma().getCodigo().equals(codigoTurma))
                .collect(Collectors.toList());
    }
}