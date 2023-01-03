package br.com.bamt.treinamento.b2w;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    private LocalDateTime date;
    @OneToOne(cascade = CascadeType.ALL)
    private Dimension dimension;

    public Product(String name2, String code2, LocalDateTime date2, Dimension dimension2) {
        this.name = name2;
        this.code = code2;
        this.date = date2;
        this.dimension = dimension2;
    }

    public Product(){

    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Dimension getDimension() {
        return dimension;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "Code: " + this.code + "Date: " + this.date
        + "Dimensions: " + this.dimension.getHeight();
        
    }
}
