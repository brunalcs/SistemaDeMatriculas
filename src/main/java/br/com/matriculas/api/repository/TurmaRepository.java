package br.com.matriculas.api.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.com.matriculas.api.entidades.Turma;

@Repository
public class TurmaRepository {

    private static Map<String, Turma> bancoDeTurmas = new HashMap<>();

    public Turma salvar(Turma turma) {
        bancoDeTurmas.put(turma.getCodigo(), turma);
        return turma;
    }

    public List<Turma> buscarTodas() {
        return new ArrayList<>(bancoDeTurmas.values());
    }

    public Turma buscarPorCodigo(String codigo) {
        return bancoDeTurmas.get(codigo);
    }
}