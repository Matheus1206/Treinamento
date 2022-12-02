package br.com.bamt.treinamento.amaro;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
	@ElementCollection
	private List<String> tags = new ArrayList<String>();
	
	
	public Produto() {
		
	}
	
	public Produto(String name, List<String> tags) {
		this.name = name;
		this.tags = tags;
	}

	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public List<String> getTags() {
		return tags;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
}
