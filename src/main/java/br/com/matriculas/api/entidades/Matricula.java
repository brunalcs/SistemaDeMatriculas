package br.com.matriculas.api.entidades;

import java.util.ArrayList;
import java.util.List;


public class Matricula {
	private Aluno aluno;
    private Turma turma;
    private StatusMatricula status;
    private Integer posicao;  // posição na fila

    public Matricula() {}

    public Matricula(Aluno aluno, Turma turma, StatusMatricula status, Integer posicao) {
        this.aluno = aluno;
        this.turma = turma;
        this.status = status;
        this.posicao = posicao;
    }


    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
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