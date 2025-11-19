package br.com.matriculas.api.entidades;

import java.util.ArrayList;
import java.util.List;

public class Turma {
	private String nomeDisciplina;
    private String professor;
    private String horario;
    private Integer vagasTotais;
    
    // Lista de matrículas desta turma
    private List<Matricula> matriculas = new ArrayList<>();

    public Turma() {}

    public Turma(String nomeDisciplina, String professor, String horario, Integer vagasTotais) {
        this.nomeDisciplina = nomeDisciplina;
        this.professor = professor;
        this.horario = horario;
        this.vagasTotais = vagasTotais;
    }

    
    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Integer getVagasTotais() {
        return vagasTotais;
    }

    public void setVagasTotais(Integer vagasTotais) {
        this.vagasTotais = vagasTotais;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
}
