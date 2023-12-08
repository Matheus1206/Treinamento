package br.com.bamt.treinamento.creditas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/creditas")
public class CustomerController{

    @GetMapping("/loan")
    public CustomerResponse verifyLoan(@RequestBody Customer customer){
        customer.verifyCustomerLoan();
        return new CustomerResponse(customer.getName(), customer.getLoans());
    }
    
}