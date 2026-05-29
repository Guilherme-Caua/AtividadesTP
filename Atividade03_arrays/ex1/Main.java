//1. Elabore um programa que preencha um array de 10 posições digitados pelo usuário(valores inteiros), ao final o programa deve subtrair 1 dos números impares e adicionar 1 aos números pares. Exibir em tela os novos valores do array.

import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		int numeros[] = new int[10], impares=0, pares=0;
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i < 10; i++){
		    numeros[i] = scan.nextInt();
		    
		    if(numeros[i] % 2 == 0){
		        numeros[i] += 1;
		    } else{
		        numeros[i] -=1;
		    }
		}
		
		for(int i = 0; i < 10; i++){
		    System.out.print(numeros[i] + " ");
		}
	}
}
