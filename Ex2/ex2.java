import java.util.Scanner;
public class ex2 {
    public static void main(String[] args) {
        System.out.println("Informe um numero");
        Scanner leitor = new Scanner(System.in);
        int numero = leitor.nextInt();
        leitor.close();
        
        if(Efibonacci(numero)){
            System.out.println("O numero " + numero +  " pertence a sequencia fibonacci");
        }
        else{
            System.out.println("O numero " + numero +  " nao pertence a sequencia fibonacci");
        }
    }

    // verificando se n é um quadrado perfeito
    public static boolean quadradoPerfeito(int num){
        int raiz = (int) (Math.sqrt(num)); // primeiro vemos se a raiz desse numero é um inteiro
        return raiz * raiz == num; // se for, verificamos se a raiz*raiz é igual ao numero. Se sim, temos um quadrado perfeito
    }
    
    // usando a formula de binet, que diz que um numero é fibonacci se e apenas se uma das expressões 5*n² + 4 ou 5*n²- 4 retornarem um quadrado perfeito.
    public static boolean Efibonacci(int num){
        return quadradoPerfeito(5*num*num + 4) || quadradoPerfeito(5*num*num-4);
    }
}
