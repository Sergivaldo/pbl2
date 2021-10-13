package com.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StatusTest{

	@Test
	void testBasic() {
		assertEquals(0,Status.PENDENTE);
		assertEquals(1,Status.EM_EXECUCAO);
		assertEquals(2,Status.CONCLUIDA);
	}

}
