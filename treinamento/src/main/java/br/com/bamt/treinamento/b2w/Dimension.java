package br.com.bamt.treinamento.b2w;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dimension {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;
    private Double weight;
    private Double height;
    private Double width;
    private Double length;

    public Dimension(Double weight2, Double height2, Double width2, Double length2) {
        this.weight = weight2;
        this.height = height2;
        this.width = width2;
        this.length = length2;
    }

    public Dimension(){
        
    }

    public Double getWeight() {
        return weight;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    public Double getLength() {
        return length;
    }

}
