package br.com.bamt.treinamento.amaro;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PopulaBanco implements CommandLineRunner {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public void run(String... args) throws Exception {
		for(int x = 0; x <= 100; x++) {
			produtoRepository.save(new Produto("Teste " + x, Arrays.asList("blusa", String.valueOf(x))));
		}
		
	}
	
	

}
