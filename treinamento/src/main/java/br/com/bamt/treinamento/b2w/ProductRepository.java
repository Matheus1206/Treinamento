package br.com.bamt.treinamento.b2w;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ProductRepository extends JpaRepository<Product, Long> {

    //Criar método de pesquisa por data
    @Query(value = "SELECT * FROM Product p WHERE p.date between ?1 and ?2",nativeQuery = true)
    List<Product> findBetweenTwoDates(LocalDate beginDate, LocalDate finalDate);

}
