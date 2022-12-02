package br.com.bamt.treinamento.amaro;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = {"application/json", "application/xml" }, consumes = {"application/json", "application/xml"})
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@PostMapping()
	@Transactional
	public List<Produto> cadastrarProduto(@RequestBody @Valid ProdutoDto produtoDto) {
		Produto produto = produtoDto.toProduto();
		produtoRepository.save(produto);
		return produtoRepository.findAll();
	}
	
	@GetMapping("/tag/{nomeTag}")
	public List<Produto> listarPorTags(@PathVariable(value="nomeTag") String nomeTag){
		return produtoRepository.findByTags(nomeTag);
	}
	
	@GetMapping("/{id}")
	public Produto listarPorTagsId(@PathVariable(value="id") Integer id){
		Optional<Produto> produto = produtoRepository.findById(id);
		return produto.get();
	}
	
	@GetMapping("/name/{name}")
	public List<Produto> listarPorName(@PathVariable(value="name") String name){
		return produtoRepository.findByName(name);
	}
	
	
		
}
