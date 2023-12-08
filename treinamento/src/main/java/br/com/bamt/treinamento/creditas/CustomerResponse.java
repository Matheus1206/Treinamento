package br.com.bamt.treinamento.creditas;

import java.util.ArrayList;
import java.util.List;

public class CustomerResponse {

    private String customer;
    private List<Loan> loans;

    public CustomerResponse(String customer, List<Loan> loans){
        this.customer = customer;
        this.loans = loans;
    }

    public String getCustomer() {
        return customer;
    }

    public List<Loan> getLoans() {
        return loans;
    }
    
}
