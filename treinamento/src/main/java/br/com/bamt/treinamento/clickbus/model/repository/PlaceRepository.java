package br.com.bamt.treinamento.clickbus.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bamt.treinamento.clickbus.model.Place;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    Place findByName(String name);
    
}
