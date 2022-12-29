package br.com.bamt.treinamento.ame;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long>{

	Optional<Planet> findByName(String name);

}
