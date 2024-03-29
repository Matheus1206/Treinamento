package br.com.bamt.treinamento.casadocodigo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorRequest {

    @NotBlank
    private String nome;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(max = 400)
    private String descricao;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        
        return this.nome + " " + this.email + " " + this.descricao;
    }

    public Autor toMoodel() {
        return new Autor(nome, email, descricao);
    }
    
}
