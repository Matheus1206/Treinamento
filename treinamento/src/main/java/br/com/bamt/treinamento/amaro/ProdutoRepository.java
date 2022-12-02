package br.com.bamt.treinamento.amaro;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

	List<Produto> findByTags(String nomeTag);

	List<Produto> findByName(String name);
	

}
