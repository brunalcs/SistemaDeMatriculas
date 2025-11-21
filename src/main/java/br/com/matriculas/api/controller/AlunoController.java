package br.com.matriculas.api.controller;

import org.springframework.web.bind.annotation.*;
import br.com.matriculas.api.entidades.Aluno;
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
    public Aluno criarAluno(@RequestBody Aluno aluno) {
        return repository.salvar(aluno);
    }

    @GetMapping
    public List<Aluno> listarAlunos() {
        return repository.buscarTodos();
    }
}