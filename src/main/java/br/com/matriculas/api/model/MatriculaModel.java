package br.com.matriculas.api.model;

import java.util.ArrayList;
import java.util.List;


public class MatriculaModel {
	private AlunoModel aluno;
    private TurmaModel turma;
    private StatusMatricula status;
    private Integer posicao;  // posição na fila

    public MatriculaModel() {}

    public MatriculaModel(AlunoModel aluno, TurmaModel turma, StatusMatricula status, Integer posicao) {
        this.aluno = aluno;
        this.turma = turma;
        this.status = status;
        this.posicao = posicao;
    }


    public AlunoModel getAluno() {
        return aluno;
    }

    public void setAluno(AlunoModel aluno) {
        this.aluno = aluno;
    }

    public TurmaModel getTurma() {
        return turma;
    }

    public void setTurma(TurmaModel turma) {
        this.turma = turma;
    }

    public StatusMatricula getStatus() {
        return status;
    }

    public void setStatus(StatusMatricula status) {
        this.status = status;
    }

    public Integer getPosicao() {
        return posicao;
    }

    public void setPosicao(Integer posicao) {
        this.posicao = posicao;
    }
}