package io.altar.jseproject.textinterface;

import java.util.Scanner;

public class TextInterface {

	public static void menu_principal() {
		System.out.println("Por favor seleccione uma das seguintes opções:");
		System.out.println("1)Listar produtos");
		System.out.println("2)Listar prateleiras");
		System.out.println("3)Sair");
		
		int input = getInput(1,3);
		switch(input){
		case 1:
			TextInterface.menu_product();
			break;
		case 2:
			TextInterface.menu_prateleira();
			break;
			
		}
		
	}

	public static void menu_product() {
		System.out.println("Por favor seleccione uma das seguintes opções:");
		System.out.println("1)Criar novo produto");
		System.out.println("2)Editar um produto existente");
		System.out.println("3)Consultar o detalhe do produto");
		System.out.println("4)Remover um produto");
		System.out.println("5)Voltar ao ecrã anterior");
		
		int input = getInput(1,5);
		switch(input){
		case 1:
			
			break;
		case 2: 
			break;
		case 3:
			break;
		}
		
	}

	public static void menu_prateleira() {
		System.out.println("Por favor seleccione uma das seguintes opcoes:");
		System.out.println("1)Criar nova prateleira");
		System.out.println("2)Editar uma prateleira existente");
		System.out.println("3)Consultar o detalhe da prateleira");
		System.out.println("4)Remover uma prateleira");
		System.out.println("5)Voltar ao ecrã anterior");
	}
	
	public static int getInput(int min, int max) {
		Scanner s = new Scanner(System.in);
		int input = 0;

		while (true) {
			if (s.hasNextInt()) {
				input = s.nextInt();
				if (input >= min && input <= max) {
					return input;
				} else {
					System.out.println("Por favor introduza um número entre " + min + " e " + max);
				}
			} else {
				System.out.println("Por favor introduza um número");
				s.next();
			}
		}
	}

}
			
				
