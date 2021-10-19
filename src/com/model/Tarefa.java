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
	
	
	/***
	 * Verifica se a data fornecida e valida
	 * @param date a ser verificada
	 * @return true caso a data seja valida e false caso contrario
	 */
	private boolean dateIsValid(LocalDate date) {
		return date.compareTo(date)>=0?true:false;
	}
	

	/***
	 * Retorna o nome da tarefa
	 * @return nome da tarefa
	 */
	public String getNome() {
		return nome;
	}


	/***
	 * Define um nome para a tarefa
	 * @param nome a ser definido
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}


	/***
	 * Retorna a descricao da tarefa
	 * @return descricao da tefa
	 */
	public String getDescricao() {
		return descricao;
	}


	/***
	 * Define uma descricao para a tarefa
	 * @param descricao a ser definida
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	/**
	 * Retorna a data de conclusao da tefa
	 * @return data de conclusao da tarefa
	 */
	public LocalDate getDataConclusao() {
		return dataConclusao;
	}


	/**
	 * Define uma data de conlcusao para a tarefa
	 * @param dataConclusao a ser definida
	 */
	public void setDataConclusao(LocalDate dataConclusao) {
		this.dataConclusao = dataConclusao;
	}


	/**
	 * Devolve o status de atrasado da tarefa
	 * @return true caso a tarefa estreja atrasada e false
	 * caso contrario
	 */
	public boolean getAtrasado() {
		return atrasado;
	}


	/***
	 * Define a tarefa como atrasada
	 */
	public void setAtrasado() {
		this.atrasado = true;
	}


	/**
	 * Retorna o status da tarefa
	 * @return status da tarefa
	 */
	public int getStatus() {
		return status;
	}


	/**
	 * Define um status para a tarefa
	 * @param status a ser definido
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	
	/**
	 * Verifica se duas tarefas são iguais, com base em
	 * seus atributos.
	 * @param obj tarefa a ser comparada
	 * @return true caso as tarefas possuam todos os atributos com
	 * os mesmos valores e false caso contrario
	 */
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
