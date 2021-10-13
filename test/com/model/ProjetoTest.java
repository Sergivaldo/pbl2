package com.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import com.main.Projeto;
import com.main.Tarefa;
import com.main.Quadro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.junit.Assert.*;

/**
 * @author Carlos Valadao
 * Teste de unidade para a classe {@link Projeto}
 */
public class ProjetoTest {
	
	private Quadro q1;
	private Quadro q2;
	private Quadro q3;
	private Quadro tempQuadro;
	
	private Tarefa t1;
	private Tarefa t2;
	private Tarefa t3;
	private Tarefa t4;
	private Tarefa t5;
	private Tarefa t6;
	
	private Projeto p1;
	
	
    /**
     * Este método é executado antes de cada teste unitario, 
     * e serve para inicializar objetos que são utilizados nos testes.
     */
	@BeforeEach
	public void setUp() {
		q1 = new Quadro();
		t1 = new Tarefa("Tarefa1", "Minha Tarefa", LocalDate.of(19, Month.OCTOBER, 2021));
		t2 = new Tarefa("Tarefa2","Descricao Tarefa 2", LocalDate.of(2000, Month.JUNE, 23));
		q1.addTarefa(t1);
		q1.addTarefa(t2);
		
		q2 = new Quadro();
		t3 = new Tarefa("Tarefa3", "Minha Tarefa", LocalDate.of(18, Month.OCTOBER, 2021));
		t4 = new Tarefa("Tarefa4","Descricao Tarefa 2", LocalDate.of(2000, Month.JUNE, 22));
		q2.addTarefa(t3);
		q2.addTarefa(t4);
		
		q3 = new Quadro();
		t5 = new Tarefa("Tarefa5", "Minha Tarefa", LocalDate.of(17, Month.OCTOBER, 2021));
		t6 = new Tarefa("Tarefa6","Descricao Tarefa 5", LocalDate.of(2000, Month.JUNE, 21));
		q3.addTarefa(t5);
		q3.addTarefa(t6);
		
		p1 = new Projeto("Projeto1", q1, q2, q3);
		
	}
	
	
	/**
	 * Teste de unidade que verifica se os 
	 * atributos sao retornados e definidos corretamente
	 */
	@Test
	public void testBasic() {
		assertEquals("Tarefa1", t1.getNome());
		t1.setNome("ProjetoNovoNome1");
		assertEquals("ProjetoNovoNome1", t1.getNome());
	}
	
	
	/**
	 * Verifica se as tarefas estao sendo movidas
	 * da forma esperada
	 */
	@Test
	public void testMoverTarefa() {
		p1.moverTarefa("Tarefa1", 0);
		assertSame(t1, p1.getQuadro(1).getTarefa("Tarefa1"));
		assertNull(p1.getQuadro(0).getTarefa("Tarefa1"));
		
		p1.moverTarefa("Tarefa4", 1);
		assertSame(t1, p1.getQuadro(2).getTarefa("Tarefa4"));
		assertNull(p1.getQuadro(1).getTarefa("Tarefa4"));

	}
	
	
	/**
	 * Verifica se o quadro retornado corresponde ao indice
	 * forencido
	 */
	@Test
	public void testPegarQuadro() {
		tempQuadro = p1.pegarQuadro(0);
		assertSame(tempQuadro, q1);
		
		tempQuadro = p1.pegarQuadro(1);
		assertSame(tempQuadro, q2);
		
		tempQuadro = p1.pegarQuadro(2);
		assertSame(tempQuadro, q3);
	}
	
}
