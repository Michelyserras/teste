package com.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        Gson gson = new Gson(); // instanciando a biblioteca para conseguir acessar os metodos
        
       try (FileReader reader = new FileReader("Ex3\\demo\\src\\main\\resources\\dados.json")) { // utilizando filereader para ler o arquivo json dentro do projeto
       
        Type listType = new TypeToken<List<Registro>>() {}.getType(); // transformando esse json em uma lista do tipo registro

        List<Registro>  registros = gson.fromJson(reader, listType); // em seguida cria-se uma lista do tipo registro para armazenar todos os dados da lista json
        
        registros.forEach(registro ->{ // em segida imprimimos na tela cada registro da lista
            System.out.println("Dia: " + registro.getDia() + "\nValor: " + registro.getValor() + "\n");
        });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}