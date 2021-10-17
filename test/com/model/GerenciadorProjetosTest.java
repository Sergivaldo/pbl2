package com.model;
import com.model.GerenciadorProjetos;
import com.model.Projeto;
import com.model.Status;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


/**
 * @author Carlos Valadao
 * Teste de unidade para a classe {@link GerenciadorProjetos}
 */
public class GerenciadorProjetosTest {
	
	private GerenciadorProjetos gProjetos;
	private Projeto p1;
	private Projeto p2;
	private Projeto p3;


    /**
     * Este método é executado antes de cada teste unitario, 
     * e serve para inicializar objetos que são utilizados nos testes.
     */
	@BeforeEach
	public void setUp() {
		gProjetos = new GerenciadorProjetos();

		p1 = new Projeto("projeto1");
		p1.pegarQuadro(Status.PENDENTE).addTarefa("Tarefa1", "Minha Tarefa", LocalDate.of(2021, Month.OCTOBER, 19));

		p2 = new Projeto("projeto2");
		p2.pegarQuadro(Status.EM_EXECUCAO).addTarefa("Tarefa2","Descricao Tarefa 2", LocalDate.of(2000, Month.JUNE, 23));

		p3 = new Projeto("projeto3");
		p3.pegarQuadro(Status.CONCLUIDA).addTarefa("Tarefa3", "Minha Tarefa", LocalDate.of(2021, Month.OCTOBER, 18));
	}
	
	
	/**
	 * Testa se esta adicionando um projeto, sem erro
	 */
	@Test
	public void testAdicionarProjeto() {
		gProjetos.adicionaProjeto(p1);
		gProjetos.adicionaProjeto(p2);
		gProjetos.adicionaProjeto(p3);
		assertEquals(3, gProjetos.getProjetos().size());
	}
	

	/**
	 * Verifica se os projetos sao removidos corretamente
	 */
	@Test
	public void testRemoverProjeto() {
		gProjetos.adicionaProjeto(p1);
		gProjetos.adicionaProjeto(p2);
		gProjetos.adicionaProjeto(p3);
		gProjetos.removerProjeto(p1.getNome());
		assertEquals(2, gProjetos.getProjetos().size());
		gProjetos.removerProjeto(p2.getNome());
		assertEquals(1, gProjetos.getProjetos().size());
		gProjetos.removerProjeto(p3.getNome());
		assertEquals(0, gProjetos.getProjetos().size());
	}


	/**
	 * Confere se o projeto correspondente ao 
	 * nome esta sendo devolvido
	 */
	@Test
	public void testPegarProjeto() {
		gProjetos.adicionaProjeto(p1);
		gProjetos.adicionaProjeto(p2);
		gProjetos.adicionaProjeto(p3);
		assertSame(p1, gProjetos.pegarProjeto("projeto1"));
		assertSame(p2, gProjetos.pegarProjeto("projeto2"));
		assertSame(p3, gProjetos.pegarProjeto("projeto3"));
	}
	
	
	
	/**
	 * Testa a edicao do nome de um projeto
	*/
	@Test
	public void testEditarNomeProjeto() {
		gProjetos.adicionaProjeto(p1);
		gProjetos.adicionaProjeto(p2);
		gProjetos.adicionaProjeto(p3);
		gProjetos.editarNomeProjeto("projeto1", "newprojeto1");
		assertEquals("newprojeto1", gProjetos.pegarProjeto("newprojeto1").getNome());
	}
	

	/**
	 * Testa se a data do sistema esta sendo verificada
	 * de forma correta
	 */
	/**
	 * Testa se a data do sistema esta sendo verificada
	 * de forma correta
	 */
	@Test
	public void AtrasarTarefas() {
		gProjetos.adicionaProjeto(p1);
		gProjetos.adicionaProjeto(p2);
		gProjetos.adicionaProjeto(p3);
		assertTrue(gProjetos.atrasarTarefas());
	}
}