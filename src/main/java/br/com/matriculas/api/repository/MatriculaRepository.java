package br.com.matriculas.api.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.matriculas.api.entidades.Matricula;

@Repository
public class MatriculaRepository {

    private static List<Matricula> bancoDeMatriculas = new ArrayList<>();

    public Matricula salvar(Matricula matricula) {
        bancoDeMatriculas.add(matricula);
        return matricula;
    }

    // Listar todas as matrículas
    public List<Matricula> buscarTodas() {
        return bancoDeMatriculas;
    }
    
    public List<Matricula> buscarPorTurma(String codigoTurma) {
        return bancoDeMatriculas.stream()
                .filter(m -> m.getTurma().getCodigo().equals(codigoTurma))
                .collect(Collectors.toList());
    }
}