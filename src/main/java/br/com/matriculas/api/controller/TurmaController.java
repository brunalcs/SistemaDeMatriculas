package br.com.matriculas.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.matriculas.api.entidades.Turma;
import br.com.matriculas.api.repository.TurmaRepository;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

   private final TurmaRepository repository;

    public TurmaController(TurmaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Turma criarTurma(@RequestBody Turma turma) {
        return repository.salvar(turma);
    }

    @GetMapping
    public List<Turma> listarTurmas() {
        return repository.buscarTodas();
    }
}