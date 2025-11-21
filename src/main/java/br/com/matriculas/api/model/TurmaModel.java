package br.com.matriculas.api.model;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class TurmaModel {
	private String nomeDisciplina;
    private String professor;
    private String horario;
    private Integer vagasTotais;
    private String codigo;
    

	// Lista de matrículas desta turma
    @JsonIgnore
    private List<MatriculaModel> matriculas = new ArrayList<>();

    public TurmaModel() {}

    public TurmaModel(String nomeDisciplina, String professor, String horario, Integer vagasTotais, String codigo) {
        this.nomeDisciplina = nomeDisciplina;
        this.professor = professor;
        this.horario = horario;
        this.vagasTotais = vagasTotais;
        this.codigo = codigo;
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

    public List<MatriculaModel> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<MatriculaModel> matriculas) {
        this.matriculas = matriculas;
    }
    
    public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
