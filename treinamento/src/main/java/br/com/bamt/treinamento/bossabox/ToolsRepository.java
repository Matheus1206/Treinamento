package br.com.bamt.treinamento.bossabox;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ToolsRepository extends JpaRepository<Tools, Long>{
    @Query(value = "SELECT * FROM TOOLS_TAGS INNER JOIN TOOLS ON TOOLS_TAGS.TOOLS_ID=TOOLS.ID WHERE TAGS = ?1", nativeQuery = true)
    List<Tools> findByTags(String tags);

}
