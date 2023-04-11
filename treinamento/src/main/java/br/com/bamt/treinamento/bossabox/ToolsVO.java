package br.com.bamt.treinamento.bossabox;

import java.util.List;

public record ToolsVO (String title, String link, String description, List<String> tags){

    public Tools toModel() {
        return new Tools(title, link, description, tags);
    }

   

}
