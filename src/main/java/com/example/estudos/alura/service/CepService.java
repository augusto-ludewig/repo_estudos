package com.example.estudos.alura.service;

import org.springframework.web.client.RestTemplate;

import com.example.estudos.alura.domain.Cep;

public class CepService {

    private final RestTemplate restTemplate = new RestTemplate();

    public String validarCep(String cep) {
        cep = cep.replaceAll("\\D", "");

        if (cep.length() != 8) {
            throw new IllegalArgumentException("CEP deve conter 8 dígitos.");
        }
        return cep;
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