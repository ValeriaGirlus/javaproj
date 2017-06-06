package io.altar.jseproject.textinterface;



import java.util.Scanner;

import io.altar.jseproject.Repository.ProductRepository;
import io.altar.jseproject.Repository.EntityRepository;
import io.altar.jseproject.model.Entity;
import io.altar.jseproject.model.Product;


public class TextInterface {
	
	public static ProductRepository ProductList = ProductRepository.getInstance();
	
	//as opcoes que aparecem a utilizador no primeiro ecra
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
	
	//o utilizador ao clicar 1 no menu principal aparece um segundo ecra com o menu para os produtos
	public static void menu_product() {
		// aparecer a lista dos produtos que ha, antes de aparecerem as opcoes
		System.out.println("Lista de produtos:");
		String string = "";
		
		if(ProductList.isEmpty()){
			System.out.println("A lista esta vazia");
			
			for(Integer id : ProductList.keySet()){
				System.out.println(ProductList.get(id));
			}
			//nao me aparece a lista de produtos quando insiro mais produtos!!!!!
		}				
		
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

	
	//o utilizador ao clicar 2 no menu principal aparece um segundo ecra com o menu para as prateleiras
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
	
	//MENU PRINCIPAL - o utilizador tem que inserir uma opcao das 3 disponiveis 
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
	
	//CRIAR PRODUTO
	public static void createProduct(){
		Scanner s = new Scanner(System.in);
		// o utilizador tem que escrever os 4 campos e qdo fizer enter isso adiciona os campos ao produto
		System.out.println("Inserir Id do produto:");
		Integer id = ProductRepository.getNextId();
		System.out.println("Inserir valor de desconto do produto:");
		Float discount = validatefloat(s,false);
		System.out.println("Inserir IVA do produto:");
		Float tax = validatefloat(s, false);
		System.out.println("Inserir PVP do produto:");
		Float saleprice = validatefloat(s, false);
		// os campos que foram preenchidos vao ser inseridos nos parametros do produto
		System.out.println("Product: " + " ID:" + id + " Discount:" + discount + " IVA:" + tax + " PVP:" + saleprice);	
		
		new Product(id,discount,tax,saleprice);
						
		// depois de mostrar os produtos com os parametros voltar para o menu principal
		menu_principal();
		
	}
	
	// criar produto - id do produto - o utilizador pode inserir string, numero ou nada para validar   
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
	
	//criar produto - desconto, tax, saleprice do produto como sao float - validar o que o utilizador escreve
	//nao tem em conta se o utilizador escrever numero negativo
	//encontrar uma maneira mais facil de fazer isto !!!!!
	public static float validatefloat(Scanner s, boolean emptyAllowed){
		String string ="";
		Integer value = null;
		while(true){
			string = s.nextLine();
			if(string.isEmpty()){
				if(emptyAllowed){
					return (Float) null;
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
	
	 
	//EDITAR PRODUTO - o primeiro passo e o utilizador inserir o id o produto 
		
	public static void editProduct(){
		Scanner s = new Scanner(System.in);
		System.out.println("Para o Id do produto que quer editar:");
		Integer id = validateInt(s,false);
		
		//a seguir mostrar os restantes campos associados a esse produto com esse id 
		System.out.println("O produto com o Id especificado apresenta os seguintes valores: " + 
							ProductRepository.getInstance().showProduct(id));
		
		//a seguir dizer ao utilizador para inserir nestes 3 campos os valores que quer alterar
		//se nao inserir nada assumir o valor anteriores
	 
		
		System.out.println("Insira o novo valor de desconto: ");
		 
		System.out.println("Insira o novo valor de IVA: ");
	
		System.out.println("Insira o novo valor de PVP: ");

               
				
		menu_principal();		
	}
	
		// o utilizador primeiro introduz o id do produto que quer consultar e depois aparecem os campos associados a esse produto
	public static void consultProduct(){
		Scanner s = new Scanner(System.in);
		System.out.println("Inserir Id do produto que quer consultar:");
		Integer id = validateInt(s,false);
		//falta completar
		menu_principal();	
	}
	
	// o utilizador primeiro introduz o id do produto que quer remover 
	public static void removeProduct(){
		Scanner s = new Scanner(System.in);
		System.out.println("Inserir Id do produto que quer eliminar:");
		Integer id = validateInt(s,false);
		//falta completar
		menu_principal();	
	}
	
	
	
	
	
	
	
	
	
	
	//--------------------------------------------------------------------------------------------------------------------
	// prateleiras falta fazer
	public static void createShelf(){
		
	}
	
	public static void editShelf(){
		
	}
	
	public static void consultShelf(){
		
	}
	
	public static void removeShelf(){
		
	}
	
}
			
		//https://stackoverflow.com/questions/14243923/deleting-a-selected-item-using-linked-hash-map		
