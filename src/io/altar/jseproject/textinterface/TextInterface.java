package io.altar.jseproject.textinterface;

import java.util.Scanner;

public class TextInterface {

	public static void menu_principal() {
		System.out.println("Por favor seleccione uma das seguintes op��es:");
		System.out.println("1)Listar produtos");
		System.out.println("2)Listar prateleiras");
		System.out.println("3)Sair");
		
		int input = getInput(1,3);
		switch(input){
		case 1:
			TextInterface.menu_product();
			break;
		case 2:
			TextInterface.menu_shelf();
			break;
			
			
		}
		
	}

	public static void menu_product() {
		System.out.println("Por favor seleccione uma das seguintes opcoes:");
		System.out.println("1)Criar novo produto");
		System.out.println("2)Editar um produto existente");
		System.out.println("3)Consultar o detalhe do produto");
		System.out.println("4)Remover um produto");
		System.out.println("5)Voltar ao ecra anterior");
		
		int input = getInput(1,5);
		switch(input){
		case 1:
			createProduct();
			break;
		case 2: 
			editProduct();
			break;
		case 3:
			consultProduct();
			break;
		case 4:
			removeProduct();
			break;
		case 5:
			TextInterface.menu_principal();
			break;

		}
		
	}

	public static void menu_shelf() {
		System.out.println("Por favor seleccione uma das seguintes opcoes:");
		System.out.println("1)Criar nova prateleira");
		System.out.println("2)Editar uma prateleira existente");
		System.out.println("3)Consultar o detalhe da prateleira");
		System.out.println("4)Remover uma prateleira");
		System.out.println("5)Voltar ao ecra anterior");
		
		int input = getInput(1,5);
		switch(input){
		case 1:
			createShelf();
			break;
		case 2: 
			editShelf();
			break;
		case 3:
			consultShelf();
			break;
		case 4:
			removeShelf();
			break;
		case 5:
			TextInterface.menu_principal();
			break;
		}
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
					System.out.println("Por favor introduza um numero entre " + min + " e " + max);
				}
			} else {
				System.out.println("Por favor introduza um numero");
				s.next();
				s.close();

			}
	
		}
		
	}
	
	public static void createProduct(){
		Product 
		System.out.println("");
		
	}
	
	public static void editProduct(){
		System.out.println("2)Editar um produto existente");
	}
	
	public static void consultProduct(){
		System.out.println("3)Consultar o detalhe do produto");
	}
	
	public static void removeProduct(){
		System.out.println("4)Remover um produto");
	}
	
	public static void createShelf(){
		System.out.println("1)Criar nova prateleira");
	}
	
	public static void editShelf(){
		System.out.println("2)Editar uma prateleira existente");
	}
	
	public static void consultShelf(){
		System.out.println("3)Consultar o detalhe da prateleira");
	}
	
	public static void removeShelf(){
		System.out.println("4)Remover uma prateleira");
	}
	
}
			
				
