/*1. Implemente um programa que recebe repetidamente um número de 1 a 12, enquanto
esse número for diferente de 0 (zero), e imprime o mês correspondente. Quando o
número estiver fora do intervalo permitido, a mensagem “mês inválido” deverá ser
exibida.*/

import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		int n=1;
		Scanner scan = new Scanner(System.in);
		
		while(n!=0) {
			n = scan.nextInt();
			
			switch(n) {
				case 1:
					System.out.println("janeiro\n");
					break;
				case 2:
					System.out.println("fevereiro\n");
					break;
				case 3:
					System.out.println("março\n");
					break;
				case 4:
					System.out.println("abril\n");
					break;
				case 5:
					System.out.println("maio\n");
					break;
				case 6:
					System.out.println("junho\n");
					break;
				case 7:
					System.out.println("julho\n");
					break;
				case 8:
					System.out.println("agosto\n");
					break;
				case 9:
					System.out.println("setembro\n");
					break;
				case 10:
					System.out.println("outubro\n");
					break;
				case 11:
					System.out.println("novembro\n");
					break;
				case 12:
					System.out.println("dezembro\n");
					break;
				default:
					System.out.println("mês inválido\n");
			}
		}
	}
}
