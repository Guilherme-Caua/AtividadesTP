/*2. Faça um programa que receba a idade de 10 pessoas e que calcule e mostre a
quantidade de pessoas com idade maior ou igual a 18 anos. Obrigatório o uso da
estrutura for.*/

import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		int n = 0, idades[] = new int[10];
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i < 10; i++){
		    idades[i] = scan.nextInt();
		    
		    if(idades[i] >= 18) n++;
		}
		
		System.out.println("\n" + n);
	}
}
