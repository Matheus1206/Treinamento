package br.com.bamt.treinamento.cubo;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/cubo/user")
public class UserController{

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @Transactional
    public void save(@RequestBody @Valid UserRequest userRequest){
        User user = userRequest.toModel();
        userRepository.save(user);
        
    }



}