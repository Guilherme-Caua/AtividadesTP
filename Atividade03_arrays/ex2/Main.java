/*2. Elabore um programa que preencha um array de 10 posições digitado pelo usuário(valores inteiros), calcule e mostre:
a) A quantidade de números pares.
b) Quais os números pares.
c) A quantidade de números ímpares.
d) Quais os números ímpares*/

import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		int numeros[] = new int[10], impares=0, pares=0;
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i < 10; i++){
		    numeros[i] = scan.nextInt();
		    
		    if(numeros[i] % 2 == 0) pares++; else impares++;
		}
		
		System.out.println("\n" + pares + " pares: ");
		
		for(int i = 0; i < 10; i++){
		    if(numeros[i] % 2 == 0){
		        System.out.print(numeros[i] + " ");
		    }
		}
		
		System.out.println("\n\n" + impares + " impares: ");
		
		for(int i = 0; i < 10; i++){
		    if(numeros[i] % 2 == 1){
		        System.out.print(numeros[i] + " ");
		    }
		}
	}
}
