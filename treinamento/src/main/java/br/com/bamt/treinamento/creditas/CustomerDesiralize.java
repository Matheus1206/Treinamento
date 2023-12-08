package br.com.bamt.treinamento.creditas;

import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class CustomerDesiralize extends StdDeserializer<Customer> {

    public CustomerDesiralize() {
        this(null);
    }

    protected CustomerDesiralize(Class<?> vc) {
        super(vc);
    }

    @Override
    public Customer deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        JsonNode node = p.getCodec().readTree(p);

        String name = node.get("customer").get("name").asText();
        String cpf = node.get("customer").get("cpf").asText();
        Integer age = node.get("customer").get("age").asInt();
        String location = node.get("customer").get("location").asText();
        Integer income = node.get("customer").get("income").asInt();
        Customer customer = new Customer(name,cpf,age,location,income);

        return customer;
    }
    
}
