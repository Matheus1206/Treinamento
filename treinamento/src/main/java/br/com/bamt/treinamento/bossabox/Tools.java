package br.com.bamt.treinamento.bossabox;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tools")
public class Tools {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String link;
    private String description;
    @ElementCollection
    private List<String> tags;

    public Tools(String title, String link, String description, List<String> tags){
        this.title = title;
        this.link = link;
        this.description = description;
        this.tags = tags;
    }

    public Tools(){

    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLink() {
        return link;
    }

    public List<String> getTags() {
        return tags;
    }

}
