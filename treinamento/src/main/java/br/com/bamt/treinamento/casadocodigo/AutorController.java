package br.com.bamt.treinamento.casadocodigo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutorController{

    @PersistenceContext
    private EntityManager manager;

    @PostMapping("/autor")
    @Transactional
    public Autor cadastra(@RequestBody @Valid AutorRequest autorRequest){
        Autor autor = autorRequest.toMoodel();
        manager.persist(autor);
        return autor;
    }

}