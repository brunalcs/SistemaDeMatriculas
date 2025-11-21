package br.com.matriculas.api.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.com.matriculas.api.model.TurmaModel;

@Repository
public class TurmaRepository {

    private static Map<String, TurmaModel> bancoDeTurmas = new HashMap<>();

    public TurmaModel salvar(TurmaModel turma) {
        bancoDeTurmas.put(turma.getCodigo(), turma);
        return turma;
    }

    public List<TurmaModel> buscarTodas() {
        return new ArrayList<>(bancoDeTurmas.values());
    }

    public TurmaModel buscarPorCodigo(String codigo) {
        return bancoDeTurmas.get(codigo);
    }
}