package br.com.bamt.treinamento.creditas;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = CustomerDesiralize.class)
public class Customer {
    
    private String name;
    private String cpf;
    private Integer age;
    private String location;
    private Integer income;
    private List<Loan> loans = new ArrayList<>();

    public Customer(){}

    public Customer(String name,String cpf, Integer age, String location, Integer income){
        this.name = name;
        this.cpf = cpf;
        this.age = age;
        this.income = income;
        this.location = location;
    }

    public Integer getAge() {
        return age;
    }

    public String getCpf() {
        return cpf;
    }

    public Integer getIncome() {
        return income;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void verifyCustomerLoan() {
        loans.add(new Loan("personal", 4));

        if(this.income <= 3000 && this.age < 30 && this.location.equals("SP")){
            loans.add(new Loan("garantia", 3));
        }

        if(this.income > 3000 && this.income < 5000 && this.location.equals("SP")){
            loans.add(new Loan("garantia", 3));
        }

        if(this.income >= 5000){
            loans.add(new Loan("consignado", 2));
        }

        if(this.income >= 5000 && this.age < 30){
            loans.add(new Loan("garantia", 3));
            loans.add(new Loan("consignado", 2));
            
        }



    }
}
