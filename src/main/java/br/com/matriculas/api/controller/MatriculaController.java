package br.com.matriculas.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.matriculas.api.model.MatriculaModel;
import br.com.matriculas.api.repository.MatriculaRepository;
import br.com.matriculas.api.service.MatriculaService;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    private final MatriculaRepository repository;
    private final MatriculaService service;

    public MatriculaController(MatriculaService service, MatriculaRepository repository) {
        this.repository = repository;
        this.service = service;
    }

   @GetMapping
    public List<MatriculaModel> listarMatriculas() {
        return repository.buscarTodas();
    }

    @PostMapping
    public MatriculaModel criarMatricula(@RequestBody MatriculaModel matricula) {
        return service.realizarMatricula(matricula);
    }
}