package br.com.bamt.treinamento.creditas;

public class Loan {

    private String type;
    private Integer taxes;

    public Loan(String type, Integer taxes){
        this.type = type;
        this.taxes = taxes;
    }

    public Integer getTaxes() {
        return taxes;
    }

    public String getType() {
        return type;
    }
}
