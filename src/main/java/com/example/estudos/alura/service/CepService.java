package com.example.estudos.alura.service;

import org.springframework.web.client.RestTemplate;

import com.example.estudos.alura.domain.Cep;

public class CepService {

    private final RestTemplate restTemplate = new RestTemplate();

    public Boolean validarCep(String cep) {
        cep = cep.replaceAll("\\D", "");
        return cep.length() == 8;
    }

    public Cep buscarCep(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        try {
            return restTemplate.getForObject(url, Cep.class);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao consultar o CEP.", e);
        }
    }


}