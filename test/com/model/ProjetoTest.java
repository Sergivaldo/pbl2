package com.model;

import java.time.LocalDate;
import java.time.Month;
import com.model.Projeto;
import com.model.Tarefa;
import com.model.Quadro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.junit.Assert.*;

/**
 * @author Carlos Valadao
 * Teste de unidade para a classe {@link Projeto}
 */
public class ProjetoTest {

	private Tarefa t1;
	private Projeto p1;
	
	
    /**
     * Este método é executado antes de cada teste unitario, 
     * e serve para inicializar objetos que são utilizados nos testes.
     */
	@BeforeEach
	public void setUp() {
		t1 = new Tarefa("Tarefa1", "Minha Tarefa", LocalDate.of(19, Month.OCTOBER, 2021));
		p1 = new Projeto("Projeto1");
		p1.pegarQuadro(Status.PENDENTE).addTarefa("Tarefa1", "Minha Tarefa", LocalDate.of(19, Month.OCTOBER, 2021));
		p1.pegarQuadro(Status.EM_EXECUCAO).addTarefa("Tarefa2","Descricao Tarefa 2", LocalDate.of(2000, Month.JUNE, 23));
		p1.pegarQuadro(Status.CONCLUIDA).addTarefa("Tarefa3", "Minha Tarefa", LocalDate.of(18, Month.OCTOBER, 2021));
		
	}
	
	
	/**
	 * Teste de unidade que verifica se os  atributos 
	 * sao retornados e definidos corretamente
	 */
	@Test
	public void testBasic() {
		assertEquals("Projeto1", p1.getNome());
		p1.setNome("ProjetoNovoNome1");
		assertEquals("ProjetoNovoNome1", p1.getNome());
	}
	
	
	/**
	 * Verifica se as tarefas estao sendo movidas
	 * da forma esperada
	 */
	@Test
	public void testMoverTarefa() {
		p1.moverTarefa("Tarefa1", Status.PENDENTE);
		assertNotNull(t1, p1.pegarQuadro(Status.EM_EXECUCAO).pegarTarefa("Tarefa1"));
		assertNull(p1.pegarQuadro(Status.PENDENTE).pegarTarefa("Tarefa1"));
		
		p1.moverTarefa("Tarefa4", Status.EM_EXECUCAO);
		assertNotNull(t1, p1.pegarQuadro(Status.CONCLUIDA).pegarTarefa("Tarefa4"));
		assertNull(p1.pegarQuadro(Status.EM_EXECUCAO).pegarTarefa("Tarefa4"));

	}
	
	
	/**
	 * Verifica se o quadro retornado nao e nulo
	 */
	@Test
	public void testPegarQuadro() {
		assertNotNull(p1.pegarQuadro(Status.PENDENTE));
		assertNotNull(p1.pegarQuadro(Status.EM_EXECUCAO));
		assertNotNull(p1.pegarQuadro(Status.CONCLUIDA));
	}
	
}