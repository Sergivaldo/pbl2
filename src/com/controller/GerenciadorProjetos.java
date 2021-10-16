package com.controller;
import com.model.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;


public class GerenciadorProjetos {
    
    private LocalDate dataAtual;
    private ArrayList<Projeto> projetos;

    public GerenciadorProjetos() {
        this.dataAtual = LocalDate.now();
        this.projetos = new ArrayList<Projeto>();
    }

    /***
     * Devolve a lista de projetos do gerenciador
     * @return lista de prjoetos
     */
    public ArrayList<Projeto> getProjetos() {
        return projetos;
    }

    /***
     * Retorna um projeto da lista correspondente
     * ao nome fornecido
     * @param nome do projeto
     * @return projeto
     */
    public Projeto pegarProjeto(String nomeProjeto) {
        Iterator<Projeto> it = getProjetos().iterator();
		while(it.hasNext()) {
			Projeto p = it.next();
			if(p.getNome().equals(nomeProjeto))
				return p;
		}
        return null;
    }

    /***
     * Remove um projeto de acordo com o nome fornecido
     * @param nome do projeto
     */
    public void removerProjeto(String nomeProjeto) {
        Projeto p = pegarProjeto(nomeProjeto);
        if(p != null)
            getProjetos().remove(p);
    }


    /***
     * Adiciona o projeto fornecido a lista de projetos
     * @param projeto a ser adicionado
     */
    public void adicionaProjeto(Projeto projeto) {
        getProjetos().add(projeto);
    }

    /***
     * Altera o nome de um projeto
     * @param antigo nome do projeto
     * @param novo nome do projeto
     */
    public void editarNomeProjeto(String antigoNome, String novoNome) {
        Projeto p = pegarProjeto(antigoNome);
        if(p != null)
            p.setNome(novoNome);
    }


    /***
     * Verifica se as tarefas de um determinado projeto e quadro estao atrasadas, caso
     * sim, muda o status da tarefa para atrasada.
     * @param nome do projeto
     * @param indice do quadro de tarefas
     */
    private void marcarTarefasAtrasadas(String nomeProjeto, int indiceQuadro) {
        Iterator<Tarefa> it = pegarProjeto(nomeProjeto).pegarQuadro(indiceQuadro).pegarTarefas().iterator();
        while(it.hasNext()) {
            Tarefa tarefa = it.next();
            if(tarefa.getDataConclusao().compareTo(this.dataAtual) < 0)
                tarefa.setAtrasado();
        }
    }


    /***
     * Verifica se todas as tarefas do sistema estao atrasadas,
     * caso sim, marca o status delas como atrasada
     */
    public void atrasarTarefas() {
        Iterator<Projeto> it = getProjetos().iterator();
        while(it.hasNext()) {
            Projeto p = it.next();
            marcarTarefasAtrasadas(p.getNome(), Status.PENDENTE);
            marcarTarefasAtrasadas(p.getNome(), Status.EM_EXECUCAO);
        }
    }
    
}
