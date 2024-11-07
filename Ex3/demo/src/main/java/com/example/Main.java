package com.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        Gson gson = new Gson();
        
       try (FileReader reader = new FileReader("Ex3\\demo\\src\\main\\resources\\dados.json")) {
       
        Type listType = new TypeToken<List<Registro>>() {}.getType();

        List<Registro>  registros = gson.fromJson(reader, listType);
        
        registros.forEach(registro ->{
            System.out.println("Dia: " + registro.getDia() + "\nValor: " + registro.getValor() + "\n");
        });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}