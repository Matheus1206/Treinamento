package br.com.bamt.treinamento;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


import br.com.bamt.treinamento.creditas.Customer;
import br.com.bamt.treinamento.creditas.CustomerController;
import br.com.bamt.treinamento.creditas.CustomerResponse;

class TreinamentoApplicationTests {
	

	@Test
	public void verificarSeSalarioMenorQue3000(){
		CustomerController customer = new CustomerController();
		CustomerResponse response = customer.verifyLoan(new Customer("Erikaya", "123.456.789-10", 29, "MG", 4000));
		assertEquals("personal", response.getLoans().get(0).getType());

	}

}
