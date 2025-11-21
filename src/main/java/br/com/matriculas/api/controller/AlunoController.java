package br.com.matriculas.api.controller;

import org.springframework.web.bind.annotation.*;

import br.com.matriculas.api.model.AlunoModel;
import br.com.matriculas.api.repository.AlunoRepository; // Use o Service idealmente, mas para teste rápido pode ser direto
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoRepository repository;

    public AlunoController(AlunoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public AlunoModel criarAluno(@RequestBody AlunoModel aluno) {
        return repository.salvar(aluno);
    }

    @GetMapping
    public List<AlunoModel> listarAlunos() {
        return repository.buscarTodos();
    }
}