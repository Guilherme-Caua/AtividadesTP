/*Faça um programa que mostre o menu de opções a seguir, receba a opção do
usuário e os dados necessários para executar cada operação. Obrigatório o uso
do switch/case.
Menu de opções:
1. Somar dois números.
2. Subtrair dois números
3. Multiplicar dois números
4. Dividir dois números
5. Raiz quadrada de um número
Digite a opção desejada.*/

import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		int op;
		double n1, n2;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("1. adição\n2. subtração\n3. multiplicação\n4. divisão\n5. radiciação\ndigite uma opção: ");
		op = scan.nextInt();
		
		switch(op){
		    case 1:
		        System.out.println("\nprimeira parcela: ");
		        n1 = scan.nextInt();
		        System.out.println("segunda parcela: ");
		        n2 = scan.nextInt();
		        
		        System.out.println("soma: " + (n1+n2));
		        break;
		        
		    case 2:
		        System.out.println("\nminuendo: ");
		        n1 = scan.nextInt();
		        System.out.println("subtraendo: ");
		        n2 = scan.nextInt();
		        
		        System.out.println("diferença: " + (n1-n2));
		        break;
		        
		    case 3:
		        System.out.println("\nprimeiro fator: ");
		        n1 = scan.nextInt();
		        System.out.println("segundo fator: ");
		        n2 = scan.nextInt();
		        
		        System.out.println("produto: " + (n1*n2));
		        break;
		        
		    case 4:
		        System.out.println("\ndividendo: ");
		        n1 = scan.nextInt();
		        System.out.println("divisor: ");
		        n2 = scan.nextInt();
		        
		        System.out.println("quociente: " + (n1/n2) + "\nresto: " + (n1%n2));
		        break;
		        
		    case 5:
		        System.out.println("\nradicando: ");
		        n1 = scan.nextInt();
		        
		        System.out.println("raíz: " + Math.sqrt(n1));
		        break;
		        
		    default:
		        System.out.println("\nopção inválida");
		}
	}
}