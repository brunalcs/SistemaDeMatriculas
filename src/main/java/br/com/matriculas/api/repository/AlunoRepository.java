package br.com.matriculas.api.repository;

import org.springframework.stereotype.Repository;

import br.com.matriculas.api.model.AlunoModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AlunoRepository {
    
    private static Map<String, AlunoModel> bancoDeDados = new HashMap<>();

    public AlunoModel salvar(AlunoModel aluno) {
        bancoDeDados.put(aluno.getMatricula(), aluno);
        return aluno;
    }

    public List<AlunoModel> buscarTodos() {
        return new ArrayList<>(bancoDeDados.values());
    }
}