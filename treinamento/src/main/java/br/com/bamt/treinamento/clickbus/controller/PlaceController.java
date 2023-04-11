package br.com.bamt.treinamento.clickbus.controller;


import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bamt.treinamento.clickbus.model.Place;
import br.com.bamt.treinamento.clickbus.model.repository.PlaceRepository;
import java.util.Optional;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/place")
public class PlaceController {

    @Autowired
    private PlaceRepository repository;

    @PostMapping
    @Transactional
    public String create(@RequestBody @Valid Place place){
        repository.save(place);
        return place.toString();
    }

    @GetMapping("{id}")
    public Place getEspecificPlace(@PathVariable Long id){
        Optional<Place> place = repository.findById(id);
        return place.get();
    }

    @GetMapping
    public List<Place> getAllPlace(){
        return repository.findAll();
    }

    @GetMapping("/name/{name}")
    public Place getAllPlaceByName(@PathVariable String name){
        return repository.findByName(name);
    }

    @PutMapping("{id}")
    public Place edit(@PathVariable Long id, @RequestBody Place newPlace){
        Place oldPlace = repository.findById(id).get();
        oldPlace.setName(newPlace.getName());
        oldPlace.setCity(newPlace.getCity());
        oldPlace.setState(newPlace.getState());
        oldPlace.setUpdateAt(LocalDateTime.now());
        repository.save(oldPlace);
        return oldPlace;
    }  
}
