package com.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QuadroTest {
	private Quadro q1;
	/**
	 * Instancia um objeto da classe <b>Quadro</b> toda vez que um teste é iniciado.
	 */
	@BeforeEach
	public void iniciar() throws Exception{
		q1 = new Quadro();
		
	}
	/**
	 * Teste unitário do método de adição de tarefas do qudro.<br>
	 * 
	 */
	@Test
	void testAdicionaTarefa() {
		Tarefa t1 = new Tarefa("Tarefa1","Descricao Tarefa", LocalDate.of(2000, Month.APRIL, 15));
		Tarefa t2 = new Tarefa("Tarefa2","Descricao Tarefa 2", LocalDate.of(2000, Month.JUNE, 23));
		
		q1.addTarefa("Tarefa1","Descricao Tarefa",LocalDate.of(2000, Month.APRIL, 15));
		q1.addTarefa("Tarefa2","Descricao Tarefa 2",LocalDate.of(2000, Month.JUNE, 21));
		assertEquals(2,q1.pegarTarefas().size());
	}
	/**
	 * Teste unitário do método responsável por pegar todas as tarefas do quadro.<br>
	 * 
	 */
	@Test
	void testPegarTarefas() {
		q1.addTarefa("Tarefa1","Descricao Tarefa",LocalDate.of(2000, Month.APRIL, 15));
		q1.addTarefa("Tarefa2","Descricao Tarefa 2",LocalDate.of(2000, Month.JUNE, 21));
		
		ArrayList<Tarefa> tarefas = q1.pegarTarefas();
		assertEquals(2,tarefas.size());
	}
	/**
	 * Teste unitário do método de edição do nome da tarefa.
	 */
	@Test
	void testEditarNomeTarefa() {
		q1.addTarefa("Tarefa1","Descricao Tarefa",LocalDate.of(2000, Month.APRIL, 15));
		q1.addTarefa("Tarefa2","Descricao Tarefa 2",LocalDate.of(2000, Month.JUNE, 21));
		
		q1.editarNomeTarefa("Tarefa1","novo nome");
		assertNotNull(q1.pegarTarefa("novo nome"));
	}
	/**
	 * Teste unitário do método de edição da descrição da tarefa.
	 */
	@Test
	void testEditarDescricaoTarefa() {
		q1.addTarefa("Tarefa1","Descricao Tarefa",LocalDate.of(2000, Month.APRIL, 15));
		q1.addTarefa("Tarefa2","Descricao Tarefa 2",LocalDate.of(2000, Month.JUNE, 21));
		
		q1.editarDescricaoTarefa("Tarefa1", "Minha nova descricao");
		assertEquals("Minha nova descricao", q1.pegarTarefa("Tarefa1").getDescricao());
		
		q1.editarDescricaoTarefa("Tarefa2", "Minha segunda descricao");
		assertEquals("Minha segunda descricao", q1.pegarTarefa("Tarefa2").getDescricao());
	}
	/**
	 * Teste unitário do método de edição da data de conclusão da tarefa.
	 */
	@Test
	void testEditarDataConclusao() {
		q1.addTarefa("Tarefa1","Descricao Tarefa",LocalDate.of(2000, Month.APRIL, 15));
		q1.addTarefa("Tarefa2","Descricao Tarefa 2",LocalDate.of(2000, Month.JUNE, 21));
		
		q1.editarDataConclusaoTarefa("Tarefa1",LocalDate.of(2002, Month.DECEMBER, 15));
		assertTrue(q1.pegarTarefa("Tarefa1").getDataConclusao().equals(LocalDate.of(2002, Month.DECEMBER, 15)));
		
		q1.editarDataConclusaoTarefa("Tarefa2",LocalDate.of(2004, Month.DECEMBER, 26));
		assertTrue(q1.pegarTarefa("Tarefa2").getDataConclusao().equals(LocalDate.of(2004, Month.DECEMBER, 26)));
	}
	/**
	 * Teste unitário do método de remoção de tarefas do quadro.
	 */
	@Test
	void testRemoverTarefa() {
		q1.addTarefa("Tarefa1","Descricao Tarefa",LocalDate.of(2000, Month.APRIL, 15));
		q1.addTarefa("Tarefa2","Descricao Tarefa 2",LocalDate.of(2000, Month.JUNE, 21));
		q1.removerTarefa("Tarefa1");
		assertNull(q1.pegarTarefa("Tarefa1"));
		assertEquals(1,q1.pegarTarefas().size());	
	}
	
	@Test
	void testPegarTarefasPorData() {
		
		LocalDate data = LocalDate.of(2005, Month.JUNE, 15);
		LocalDate data2 = LocalDate.of(2010, Month.AUGUST, 3);
		q1.addTarefa("Tarefa1","Descricao Tarefa",LocalDate.of(2000, Month.MARCH, 15));
		q1.addTarefa("Tarefa2","Descricao Tarefa 2",LocalDate.of(2005, Month.JUNE, 15));
		q1.addTarefa("Tarefa3","Descricao Tarefa 3",LocalDate.of(2000, Month.APRIL, 25));
		q1.addTarefa("Tarefa4","Descricao Tarefa 4",LocalDate.of(2005, Month.JUNE, 15));
		
		Iterator<Tarefa> iterator = q1.pegarTarefasPorData(data);
		assertTrue(iterator.hasNext());
		assertEquals(data, iterator.next().getDataConclusao());
		assertEquals(data, iterator.next().getDataConclusao());
		assertFalse(iterator.hasNext());
		
		iterator = q1.pegarTarefasPorData(data2);
		assertFalse(iterator.hasNext());
		
	}
}
