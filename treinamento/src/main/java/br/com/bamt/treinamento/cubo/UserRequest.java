package br.com.bamt.treinamento.cubo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    @NotNull
    @Min(1)
    private Integer participation;

    public UserRequest(@NotBlank String name, @NotBlank String lastName, @NotNull @Min(1) Integer participation){
        this.name = name;
        this.lastName = lastName;
        this.participation = participation;
    }

    @Override
    public String toString() {
        return this.name + this.lastName + this.participation;
    }

    public User toModel() {
        return new User(this.name, this.lastName, this.participation);
    }

}
