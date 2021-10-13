package com.model;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;


public class TarefaTest {
	
	/**
	 * Método que instancia um objeto da classe <b>Tarefa</b> antes de executar cada um dos métodos de teste.
	 */
	

    /**
     * Teste de unidade para verificar se todos os atributos da <b>Tarefa</b> podem ser acessados e
     * modificados através de seus respectivos métodos.
     */
    @Test
    public void testBasic() {
    	Tarefa t1 = new Tarefa("Tarefa1", "Minha Tarefa",LocalDate.of(2021, Month.OCTOBER, 19));
    	
    	LocalDate data = LocalDate.of(2021, Month.OCTOBER, 15);
    	
    	// Verificação dos métodos acessores.
    	assertEquals("Tarefa1",t1.getNome());
    	assertEquals("Minha Tarefa",t1.getDescricao());
    	assertEquals(Status.PENDENTE, t1.getStatus());
    	assertFalse(t1.getDataConclusao().equals(data));
    	assertFalse(t1.getAtrasado());
    	assertNotNull(t1.getDataConclusao());
    	
    	// Verificação dos métodos modificadores.
    	t1.setNome("Tarefa2");
    	t1.setDescricao("Outra descricao");
    	t1.setDataConclusao(data);
    	t1.setAtrasado();
    	t1.setStatus(Status.EM_EXECUCAO);
    	
    	assertEquals("Tarefa2",t1.getNome());
    	assertEquals("Outra descricao",t1.getDescricao());
    	assertEquals(Status.EM_EXECUCAO,t1.getStatus());
    	assertTrue(t1.getDataConclusao().equals(data));
    	assertTrue(t1.getAtrasado());
    	
    	
    	
    }
    /**
     * Teste unitário que verifica se o método equals da classe <b>Tarefa</b> foi sobrescito
     * e implementado da forma correta. 
     */
    @Test
    public void testEquals() {
    	Tarefa t1 = new Tarefa("Tarefa1", "Minha Tarefa",LocalDate.of(2021, Month.OCTOBER, 19));
    	Tarefa t2 = new Tarefa("Tarefa4", "Minha Tarefa 4",LocalDate.of(2021, Month.OCTOBER, 19));
    	assertFalse(t1.equals(t2));
    	
    	t2 = new Tarefa("Tarefa1", "Minha Tarefa",LocalDate.of(2021, Month.OCTOBER, 19));
    	assertTrue(t1.equals(t2));
    	
    	t2 = new Tarefa("Tarefa2", "Minha Tarefa 2",LocalDate.of(2021, Month.OCTOBER, 13));
    	assertFalse(t1.equals(t2));
    	
    }
	
}
