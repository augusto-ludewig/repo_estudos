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
        while (Boolean.FALSE.equals(cepService.validarCep(cep))){
            System.out.println("CEP inválido.");
            System.out.print("Digite o CEP novamente: ");
            cep = scanner.nextLine();
        }

        Cep endereco = cepService.buscarCep(cep);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(endereco);
        System.out.println(json);
    }
}