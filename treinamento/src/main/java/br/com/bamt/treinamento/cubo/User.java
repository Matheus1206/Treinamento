package br.com.bamt.treinamento.cubo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    @NotNull
    @Min(1)
    private Integer participation;


    public User(@NotBlank String name, @NotBlank String lastName, @NotNull @Min(1) Integer participation) {
        this.name = name;
        this.lastName = lastName;
        this.participation = participation;
    }

}
