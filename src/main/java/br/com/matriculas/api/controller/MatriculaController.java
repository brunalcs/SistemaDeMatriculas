package br.com.matriculas.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.matriculas.api.model.MatriculaModel;
import br.com.matriculas.api.repository.MatriculaRepository;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    private final MatriculaRepository repository;

    public MatriculaController(MatriculaRepository repository) {
        this.repository = repository;
    }

   @GetMapping
    public List<MatriculaModel> listarMatriculas() {
        return repository.buscarTodas();
    }

    @PostMapping
    public MatriculaModel criarMatricula(@RequestBody MatriculaModel matricula) {
        return repository.salvar(matricula);
    }
}