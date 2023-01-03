package br.com.bamt.treinamento.b2w;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("b2w")
public class TesteController {

    @Autowired
    private ProductRepository productRepository;


    @GetMapping("item")
    @Transactional
    public List<Product> teste(@RequestParam Map<String,String> requestParams){
        RestTemplate rest = new RestTemplate();
        Product[] product = rest.getForObject("http://www.mocky.io/v2/5817803a1000007d01cc7fc9", Product[].class);
        List<Product> listProduct = new ArrayList<>();
        for(Product p : product){
            listProduct.add(p);
        }
        productRepository.saveAll(listProduct);
        String beginDate = requestParams.get("begindate");
        String finalDate = requestParams.get("finaldate");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println(LocalDate.parse(beginDate, formatter));
        List<Product> productFind = productRepository.findBetweenTwoDates(LocalDate.parse(beginDate, formatter), LocalDate.parse(finalDate, formatter));
        return productFind;
    }
    
}
