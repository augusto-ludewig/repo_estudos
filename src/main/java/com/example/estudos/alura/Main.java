package com.example.estudos.alura;

import java.util.Scanner;

import com.example.estudos.alura.domain.Cep;
import com.example.estudos.alura.service.CepService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o CEP: ");
        String cep = scanner.nextLine();

        CepService cepService = new CepService();
        String cepLimpo = cepService.validarCep(cep);
        Cep endereco = cepService.buscarCep(cepLimpo);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(endereco);
        System.out.println(json);
    }
}