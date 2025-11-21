package br.com.matriculas.api.repository;

import org.springframework.stereotype.Repository;
import br.com.matriculas.api.entidades.Aluno;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AlunoRepository {
    
    private static Map<String, Aluno> bancoDeDados = new HashMap<>();

    public Aluno salvar(Aluno aluno) {
        bancoDeDados.put(aluno.getMatricula(), aluno);
        return aluno;
    }

    public List<Aluno> buscarTodos() {
        return new ArrayList<>(bancoDeDados.values());
    }
}