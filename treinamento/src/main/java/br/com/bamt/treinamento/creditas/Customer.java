package br.com.bamt.treinamento.creditas;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = CustomerDesiralize.class)
public class Customer {
    
    private String name;
  
    public Customer(){}

    public Customer(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name:" + this.name;
        
    }
}
