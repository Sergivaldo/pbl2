package com.model;

import java.time.LocalDate;
import java.time.LocalTime;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Assert.*;

/**
 * @author Carlos Valadao
 * Teste de unidade para a classe {@link GerenciadorProjetos}
 */
public class GerenciadorProjetosTest {
	
	private GerenciadorProjetos gProjetos;
	
	private Tarefa t1;
	private Tarefa t2;
	private Tarefa t3;
	private Tarefa t4;
	private Tarefa t5;
	private Tarefa t6;
	
	private Quadro q1;
	private Quadro q2;
	private Quadro q3;
	private Quadro q4;
	private Quadro q5;
	private Quadro q6;
	private Quadro q7;
	private Quadro q8;
	private Quadro q9;
	
	private Projeto p1;
	private Projeto p2;
	private Projeto p3;
	private Projeto tempP;
	

	
    /**
     * Este método é executado antes de cada teste unitario, 
     * e serve para inicializar objetos que são utilizados nos testes.
     */
	@BeforeEach
	public void setUp() {
		q1 = new Quadro();
		q2 = new Quadro();
		q3 = new Quadro();
		t1 = new Tarefa("Tarefa1", "Minha Tarefa", LocalDate.of(19, Month.OCTOBER, 2021));
		t2 = new Tarefa("Tarefa2","Descricao Tarefa 2", LocalDate.of(2000, Month.JUNE, 23));
		q1.addTarefa(t1);
		q1.addTarefa(t2);
		p1 = new Projeto("Projeto1", q1, q2, q3);
		
		q4 = new Quadro();
		q5 = new Quadro();
		q6 = new Quadro();
		t3 = new Tarefa("Tarefa3", "Minha Tarefa", LocalDate.of(18, Month.OCTOBER, 2021));
		t4 = new Tarefa("Tarefa4","Descricao Tarefa 2", LocalDate.of(2000, Month.JUNE, 22));
		q5.addTarefa(t3);
		q5.addTarefa(t4);
		p2 = new Projeto("Projeto2", q4, q5, q6);
		
		q7 = new Quadro();
		q8 = new Quadro();
		q9 = new Quadro();
		t5 = new Tarefa("Tarefa5", "Minha Tarefa", LocalDate.of(17, Month.OCTOBER, 2021));
		t6 = new Tarefa("Tarefa6","Descricao Tarefa 5", LocalDate.of(2000, Month.JUNE, 21));
		q9.addTarefa(t5);
		q9.addTarefa(t6);
		p3 = new Projeto("Projeto3", q7, q8, q9);
		
		LocalDate ndt = LocalDate.now();
		gProjetos = new GerenciadorProjetos(ndt);
	}
		
	/**
	 * Testa se esta adicionando um projeto, sem erro
	 */
	@Test
	public void testAdicionarProjeto() {
		gProjetos.adicionaProjeto(p1);
		gProjetos.adicionaProjeto(p2);
		gProjetos.adicionaProjeto(p3);
		assertEquals(3, gProjetos.getProjetos.size());
	}
	
	/**
	 * Verifica se os projetos sao removidos corretamente
	 */
	@Test
	public void testRemoverProjeto() {
		tempP = p1;
		assertSame(tempP, gProjetos.removerProjeto("Projeto1"));
		
		tempP = p2;
		assertSame(tempP, gProjetos.removerProjeto("Projeto2"));
		
		tempP = p3;
		assertSame(tempP, gProjetos.removerProjeto("Projeto3"));
	}

	/**
	 * Confere se o projeto correspondente ao 
	 * nome esta sendo devolvido
	 */
	@Test
	public void testPegarProjeto() {
		tempP = p1;
		assertSame(p1, gProjetos.pegarProjeto("projeto1"));
		
		tempP = p2;
		assertSame(p2, gProjetos.pegarProjeto("projeto2"));
		
		tempP = p3;
		assertSame(p3, gProjetos.pegarProjeto("projeto3"));
	}
	
	
	/**
	 * Testa a edicao do nome de um projeto
	*/
	@Test
	public void testEditarNomeProjeto() {
		gProjetos.editarNomeProjeto("projeto1", "newprojeto1");
		assertEquals("newprojeto1", gProjetos.getProjeto("newprojeto1"));
	}
	
	/**
	 * Testa se a data do sistema esta sendo verificada
	 * de forma correta
	 */
	@Test
	public void testVerificarData() {
		
	}
}
