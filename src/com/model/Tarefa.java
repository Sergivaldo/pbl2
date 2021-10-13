package com.model;

import java.time.LocalDate;

public class Tarefa {
	private String nome;
	private String descricao;
	private LocalDate dataConclusao;
	private boolean atrasado;
	private int status;
	
	public Tarefa(String nome, String descricao, LocalDate dataConclusao) {
		this.nome = nome;
		this.descricao = descricao;
		this.atrasado = false;
		this.status = Status.PENDENTE;
		if(dateIsValid(dataConclusao)) {
			this.dataConclusao = dataConclusao;
		}else {
			this.dataConclusao = LocalDate.now();
		}
	}
	
	private boolean dateIsValid(LocalDate date) {
		return date.compareTo(date)>=0?true:false;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDate getDataConclusao() {
		return dataConclusao;
	}
	public void setDataConclusao(LocalDate dataConclusao) {
		this.dataConclusao = dataConclusao;
	}
	public boolean getAtrasado() {
		return atrasado;
	}
	public void setAtrasado() {
		this.atrasado = true;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public boolean equals(Object obj) {
		Tarefa outraTarefa = (Tarefa) obj;
		if(this.getNome().equals(outraTarefa.getNome())
				&& this.getDescricao().equals(outraTarefa.getDescricao())
				&& this.getDataConclusao().equals(outraTarefa.getDataConclusao()))
			return true;
		
		return false;
		
	}
}
