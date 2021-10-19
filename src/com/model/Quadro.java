package com.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;


/***
 * Classe que representa o quadro de tarefas
 */
public class Quadro {
	private ArrayList<Tarefa> tarefas;
	
	public Quadro() {
		tarefas = new ArrayList<Tarefa>();
	}


	/**
	 * Devolve a tarefa com o nome indicado
	 * @param nomeTarefa a ser retornada
	 * @return tarefa, caso ela exista e null caso contrario
	 */
	public Tarefa pegarTarefa(String nomeTarefa) {
		Iterator<Tarefa> iterator = tarefas.iterator();
		while(iterator.hasNext()) {
			Tarefa tarefa = iterator.next();
			if(tarefa.getNome().equals(nomeTarefa))
				return tarefa;
		}
		
		return null;
	}
	

	/***
	 * Altera o nome de uma tarefa do quadro
	 * @param nomeTarefa a ser renomeada
	 * @param novoNome da tarefa
	 */
	public void editarNomeTarefa(String nomeTarefa, String novoNome) {
		Iterator<Tarefa> iterator = tarefas.iterator();
		while(iterator.hasNext()) {
			Tarefa tarefa = iterator.next();
			if(tarefa.getNome().equals(nomeTarefa))
				tarefa.setNome(novoNome);
		}
	}
	

	/***
	 * Exclui uma tarefa do quadro
	 * @param nomeTarefa
	 * @return
	 */
	public Tarefa removerTarefa(String nomeTarefa) {
		Tarefa tarefa = pegarTarefa(nomeTarefa);
		Tarefa tarefaRemovida = null;
		if(tarefa!=null)
			tarefaRemovida = tarefa;
			tarefas.remove(tarefa);
		return tarefaRemovida;
	}
	

	/***
	 * Retorna a lista de tarefas do quadro
	 * @return lista de tarefas
	 */
	public ArrayList<Tarefa> pegarTarefas(){
		return tarefas;
	}
	

	/**
	 * Inclui uma tarefa na lista de tarefas, com base
	 * nos atributos fornecidos
	 * @param nome da tarefa
	 * @param descricao	da tarefa
	 * @param dataConclusao da tarefa
	 */
	public void addTarefa(String nome, String descricao, LocalDate dataConclusao) {
		Tarefa novaTarefa = new Tarefa(nome,descricao,dataConclusao);
		tarefas.add(novaTarefa);
	}
	
	
	/***
	 * Adiciona uma tarefa na lista de tarefas do quadro
	 * @param tarefa a ser adicionada
	 */
	public void addTarefa(Tarefa tarefa) {
		tarefas.add(tarefa);
	}
	

	/**
	 * Altera a descricao de uma tarefa
	 * @param nomeTarefa a modificar a descricao
	 * @param novaDescricao da tarefa
	 */
	public void editarDescricaoTarefa(String nomeTarefa, String novaDescricao) {
		Iterator<Tarefa> iterator = tarefas.iterator();
		while(iterator.hasNext()) {
			Tarefa tarefa = iterator.next();
			if(tarefa.getNome().equals(nomeTarefa))
				tarefa.setDescricao(novaDescricao);
		}
	}
	

	/***
	 * Modifica a data de conclusao de uma tarefa
	 * @param nomeTarefa a modificar a data
	 * @param novaData de conclusao
	 */
	public void editarDataConclusaoTarefa(String nomeTarefa, LocalDate novaData) {
		Iterator<Tarefa> iterator = tarefas.iterator();
		while(iterator.hasNext()) {
			Tarefa tarefa = iterator.next();
			if(tarefa.getNome().equals(nomeTarefa))
				tarefa.setDataConclusao(novaData);
		}
	}
	

	/***
	 * Cria um arrayList com tarefas contendo
	 * datas iguais a fornecida
	 * @param data a ser comparada
	 * @return Iterator da lista contendo tarefas
	 * com data igual a fornecida
	 */
	public Iterator<Tarefa> pegarTarefasPorData(LocalDate data) {
		ArrayList<Tarefa> listaTarefas = new ArrayList<Tarefa>();
		Iterator<Tarefa> iterator = tarefas.iterator();
		while(iterator.hasNext()) {
			Tarefa tarefa = iterator.next();
			if(tarefa.getDataConclusao().equals(data))
				listaTarefas.add(tarefa);
		}
		
		return listaTarefas.iterator();
	}
}
