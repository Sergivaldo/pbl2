package com.model;

/**
 * @author Carlos Valadao
 * Classe que representa um projeto do gerenciador de projetos
 */
public class Projeto {

	private String nome;
	private Quadro[] quadroTarefas;
	
	public Projeto(String nome) {
		this.nome = nome;
		quadroTarefas = new Quadro[3];
		quadroTarefas[0] = new Quadro();
		quadroTarefas[1] = new Quadro();
		quadroTarefas[2] = new Quadro();
	}
	
	
	/**
	 * @return o nome do projeto
	 */
	public String getNome() {
		return nome;
	}
	
	
	/**
	 * @param nome a ser definido
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	/**
	 * Devolve o quadro correspondente ao indice fornecido
	 * @param indice do quadro desejado
	 * @return quadro correspondente ao indice
	 * */
	public Quadro pegarQuadro(int indiceQuadro) {
		return quadroTarefas[indiceQuadro];
	}
	
	
	/**
	 * Move uma determinada tarefa para o quadro subsequente
	 * @param nome da tarefa a ser movida
	 * @param quadro de origem da tarefa a ser movida
	 */
	public void moverTarefa(String nomeTarefa, int indiceQuadroOrigem) {
		Tarefa tempT = quadroTarefas[indiceQuadroOrigem].removerTarefa(nomeTarefa);
		tempT.setStatus(indiceQuadroOrigem + 1);
		quadroTarefas[indiceQuadroOrigem + 1].addTarefa(tempT.getNome(), tempT.getDescricao(), tempT.getDataConclusao());
	}
}
