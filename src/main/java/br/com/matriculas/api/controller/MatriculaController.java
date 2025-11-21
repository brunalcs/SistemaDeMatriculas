package br.com.matriculas.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.matriculas.api.entidades.Matricula;
import br.com.matriculas.api.repository.MatriculaRepository;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    private final MatriculaRepository repository;

    public MatriculaController(MatriculaRepository repository) {
        this.repository = repository;
    }

   @GetMapping
    public List<Matricula> listarMatriculas() {
        return repository.buscarTodas();
    }

    @PostMapping
    public Matricula criarMatricula(@RequestBody Matricula matricula) {
        return repository.salvar(matricula);
    }
}