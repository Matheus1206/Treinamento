package br.com.bamt.treinamento.amaro;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "element")
public class ProdutoDto {
	
	@XmlElement(name = "name")
	@NotBlank(message = "Campo name é obrigatório")
	private String name;
	
	@XmlElementWrapper(name = "tags", required = false)
	private List<String> names = new ArrayList<>();
	
	public String getName() {
		return name;
	}
	
	public List<String> getTags() {
		return names;
	}

	public Produto toProduto() {
		Produto produto = new Produto();
		produto.setName(this.name);
		produto.setTags(this.names);
		return produto;
	}

}
