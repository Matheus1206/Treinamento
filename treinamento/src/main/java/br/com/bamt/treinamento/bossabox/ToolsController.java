package br.com.bamt.treinamento.bossabox;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bossabox")
public class ToolsController {

    @Autowired
    private ToolsRepository toolsRepository;

    @GetMapping
    @Transactional
    public List<Tools> getAllTools(){
        return toolsRepository.findAll();
    }

    @PostMapping("tools")
    public void saveTools(@RequestBody ToolsVO toolsVO){
        Tools tools = toolsVO.toModel();
        toolsRepository.save(tools);
    }

    @GetMapping("tools")
    public List<Tools> searchByNode(@RequestParam String tags){
        List<Tools> list = toolsRepository.findByTags(tags);
        return list;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteTool(@PathVariable Long id){
            toolsRepository.deleteById(id);
            return ResponseEntity.noContent().build();        
           
    }
    
}
