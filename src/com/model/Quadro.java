package com.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Quadro {
	private ArrayList<Tarefa> tarefas;
	
	public Quadro() {
		tarefas = new ArrayList<Tarefa>();
	}
	public Tarefa pegarTarefa(String nomeTarefa) {
		Iterator<Tarefa> iterator = tarefas.iterator();
		while(iterator.hasNext()) {
			Tarefa tarefa = iterator.next();
			if(tarefa.getNome().equals(nomeTarefa))
				return tarefa;
		}
		
		return null;
	}
	
	public void editarNomeTarefa(String nomeTarefa, String novoNome) {
		Iterator<Tarefa> iterator = tarefas.iterator();
		while(iterator.hasNext()) {
			Tarefa tarefa = iterator.next();
			if(tarefa.getNome().equals(nomeTarefa))
				tarefa.setNome(novoNome);
		}
	}
	
	public Tarefa removerTarefa(String nomeTarefa) {
		Tarefa tarefaRemovida = null;
		Iterator<Tarefa> iterator = tarefas.iterator();
		
		while(iterator.hasNext()) {
			Tarefa tarefa = iterator.next();
			if(tarefa.getNome().equals(nomeTarefa))
				tarefaRemovida = tarefa;
				tarefas.remove(tarefa);
		}
		
		return tarefaRemovida;
	}
	
	public ArrayList<Tarefa> pegarTarefas(){
		return tarefas;
	}
	
	public void addTarefa(String nome, String descricao, LocalDate dataConclusao) {
		Tarefa novaTarefa = new Tarefa(nome,descricao,dataConclusao);
		tarefas.add(novaTarefa);
	}
	
	public void editarDescricaoTarefa(String nomeTarefa, String novaDescricao) {
		Iterator<Tarefa> iterator = tarefas.iterator();
		while(iterator.hasNext()) {
			Tarefa tarefa = iterator.next();
			if(tarefa.getNome().equals(nomeTarefa))
				tarefa.setDescricao(novaDescricao);
		}
	}
	
	public void editarDataConclusaoTarefa(String nomeTarefa, LocalDate novaData) {
		Iterator<Tarefa> iterator = tarefas.iterator();
		while(iterator.hasNext()) {
			Tarefa tarefa = iterator.next();
			if(tarefa.getNome().equals(nomeTarefa))
				tarefa.setDataConclusao(novaData);
		}
	}
	
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
