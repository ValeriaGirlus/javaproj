package io.altar.jseproject.textinterface;

import java.util.Arrays;
import java.util.Scanner;

import io.altar.jseproject.model.Product;

public class TextInterface {

	public static void menu_principal() {
		System.out.println("Por favor seleccione uma das seguintes op�oes:");
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
	
	public static Integer validateInt(Scanner s, boolean emptyAllowed){
		String string ="";
		Integer value = null;
		while(true){
			string = s.nextLine();
			if(string.isEmpty()){
				if(emptyAllowed){
					return null;
				}
				else{
					System.out.println("Tente outra vez");
				}				
			}
			else{
				try{
					value = Integer.parseInt(string);
					return value;
				}
				catch(Exception e){
					System.out.println("Tente outra vez");
				}
			}
		}
	}
	
	public static Float validatefloat(Scanner s, boolean emptyAllowed){
		
	}
	
	public static void createProduct(){
		Scanner s = new Scanner(System.in);
		// o utilizador tem que escrever os 4 campos e qdo fizer enter isso adiciona os campos ao produto
		System.out.println("Inserir Id do produto:");
		Integer myID = validateInt(s,false);
		System.out.println("Inserir valor de desconto do produto:");
		Float myDiscount
		System.out.println("Inserir IVA do produto:");
		
		System.out.println("Inserir PVP do produto:");
	
		
				
		Product P = new Product(myID,discount,IVA,PVP);
		Array_products = new Array [];
		
		System.out.println("Product");
	}
	
	public static void editProduct(){
		// o utilizador primeiro introduz o id do produto e depois aparecem os campos associados a esse produto
	}
	
	public static void consultProduct(){
		
	}
	
	public static void removeProduct(){
		
	}
	
	public static void createShelf(){
		
	}
	
	public static void editShelf(){
		
	}
	
	public static void consultShelf(){
		
	}
	
	public static void removeShelf(){
		
	}
	
}
			
				
