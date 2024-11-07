package com.example;

import com.google.gson.Gson; // classe utilizada para converter json em java object e vice-versa
import com.google.gson.reflect.TypeToken; // biblioteca que ajuda o gson a entender o tipo da específico
import java.io.FileReader; //
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        double maiorValor = Double.MIN_VALUE;
        double menorValor = Double.MAX_VALUE;
        int countDays = 0;
        int registroMaiorQueMedia = 0;
        int menorDia = 30;
        int maiorDia = 1;
        double soma = 0;
        double media = 0;
        Gson gson = new Gson(); // instanciando a biblioteca para conseguir acessar os metodos para converter json em objeto e vice-versa
        
       try (FileReader reader = new FileReader("Ex3\\demo\\src\\main\\resources\\dados.json")) { // utilizando filereader para ler o arquivo json dentro do projeto
       
        Type listType = new TypeToken<List<Registro>>() {}.getType(); // define o tipo de dados que estamos esperando do json nesse caso tipo registro

        List<Registro>  registros = gson.fromJson(reader, listType); // em seguida, converte o conteudo do json lido pelo filereader em uma lista de objetos do tipo Registro
        // o metodo fromJson = lê o arquivo do reade e com a ajuda do listType sabe que deve converter em uma lista do tipo Registo
        
        // registros.forEach(registro ->{ // em segida imprimimos na tela cada registro da lista
        //     System.out.println("Dia: " + registro.getDia() + "\nValor: " + registro.getValor() + "\n");

        // });



        for(Registro registro : registros ){
            if(registro.getValor() > maiorValor){ // se o registro for maior que o maiorValor a gente atribui esse valor para o maior valor
                maiorValor = registro.getValor();
                maiorDia = registro.getDia();
            }
            else if(registro.getValor() != 0 && registro.getValor() < menorValor ){ //se o valor do registro for diferente de 0 e menor que o menorValor a gente atribui a variavel menorValor o valor do registro encontrado
                menorValor = registro.getValor();
                menorDia = registro.getDia();
            }
            else if(registro.getValor() != 0){ // para os registros que possuem valor diferente de 0, vamos contar quantos eles são e em seguida somá-los
                countDays++;
                soma += registro.getValor();
            }

        }
        media = soma/countDays; // media do faturamento mensal, ignorando os dias sem faturamento

        for(Registro registro: registros){
            if(registro.getValor() > media){ // se o valor for maior que a media a gente itera o contador de registros
                registroMaiorQueMedia++;
            }
        }
        System.out.println("\nMaior valor: " + maiorValor + "\n Dia: " + maiorDia);
        System.out.println("\nMenor valor: " + menorValor + "\n Dia: " + menorDia);
        System.out.println("\nTotal de dias em que o faturamento foi maior que 0: " + countDays);
        System.out.println("\nMedia do faturamento mensal: " + media);
        System.out.println("\nQuantidade de dias em que o faturamento foi maior que a media mensal: " + registroMaiorQueMedia + "\n");

       
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}