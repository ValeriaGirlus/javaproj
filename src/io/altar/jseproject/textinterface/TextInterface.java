package io.altar.jseproject.textinterface;

import java.util.Scanner;

import io.altar.jseproject.Repository.ProductRepository;
import io.altar.jseproject.Repository.EntityRepository;
import io.altar.jseproject.model.Entity;
import io.altar.jseproject.model.Product;


public class TextInterface {
	
	public static ProductRepository ProductList = ProductRepository.getInstance();
	
	//---------------------------------------menu principal--------------------------------------------------
	//as opções que aparecem ao utilizador no primeiro ecrã que é o menu principal i.e o primeiro que aparece
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
			TextInterface.menu_shelf();
			break;
		}
	}
	
	//-------------------------------------menu produtos----------------------------------------------------
	//o utilizador ao clicar 1 no menu principal aparece um segundo ecrã com o menu para os produtos
	public static void menu_product() {
		// aparecer a lista dos produtos que há, antes de aparecerem as opções
		System.out.println("Lista de produtos:");
		String string = "";
		
		if(ProductList.isEmpty()){
			System.out.println("A lista está vazia");
			
			//nao percebo muito bem isto
			for(Integer id : ProductList.keySet()){
				System.out.println(ProductList.get(id));
			}
			//nao me aparece a lista de produtos quando insiro mais produtos!!!!!
		}				
		
		System.out.println("Por favor seleccione uma das seguintes opções:");
		System.out.println("1)Criar novo produto");
		System.out.println("2)Editar um produto existente");
		System.out.println("3)Consultar o detalhe do produto");
		System.out.println("4)Remover um produto");
		System.out.println("5)Voltar ao ecrã anterior");
		
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

	//-----------------------------------menu prateleiras--------------------------------------------------
	//o utilizador ao clicar 2 no menu principal aparece um segundo ecrã com o menu para as prateleiras
	public static void menu_shelf() {
		System.out.println("Por favor seleccione uma das seguintes opções:");
		System.out.println("1)Criar nova prateleira");
		System.out.println("2)Editar uma prateleira existente");
		System.out.println("3)Consultar o detalhe da prateleira");
		System.out.println("4)Remover uma prateleira");
		System.out.println("5)Voltar ao ecrã anterior");
		
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
	
	//-----------------------------------------------menu principal-----------------------------------------------------------
	//no menu_principal o utilizador tem que inserir uma opção das 3 disponíveis (mínimo o valor 1 e máximo o valor 3) 
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
	
	//------------------------------------------------menu produtos-----------------------------------------------------------
	//CRIAR PRODUTO
	public static void createProduct(){
		Scanner s = new Scanner(System.in);
			//o utilizador não precisa de escrever o id porque é gerado automaticamente
		//o utilizador preenche os outros campos, sendo que é preciso validar o que escreve
		System.out.println("Inserir Id do produto:");
		//ver isto melhor!
		Integer id = ProductRepository.getNextId();
		System.out.println("Inserir valor de desconto do produto:");
		Float discount = validatefloat(s,false);
		System.out.println("Inserir IVA do produto:");
		Float tax = validatefloat(s, false);
		System.out.println("Inserir PVP do produto:");
		Float saleprice = validatefloat(s, false);
		//os campos que foram preenchidos vão ser inseridos no produto e vai aparecer neste formato cada produto 
		System.out.println("Product: " + " ID:" + id + " Discount:" + discount + " IVA:" + tax + " PVP:" + saleprice);	
		
		//perceber isto melhor!
		new Product(id,discount,tax,saleprice);
						
		//voltar para o menu principal
		menu_principal();
		
	}
	
	//validar o que o utilizador insere nos campos para CRIAR PRODUTO - id do produto (pode inserir string, numero ou nada)
	//encontrar uma maneira mais simples!
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
	
	/* uma outra maneira de fazer mas ver se funciona!!
	public static int validateInt(scanner){
		Scanner scanner = new Scanner(System.in);
		int input;
		
		do{
			System.out.println("Por favor insira um número");
			while(!scanner.hasNextInt(){
				String input = scanner.next();
				System.out.println("Tente de novo");
			}
			input = scanner.nextInt();
		}
		while (scanner>=0){
		System.out.println("" + input);
	}
	*/
	
	//encontrar uma maneira mais simples!
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
	
	 
	//EDITAR PRODUTO - o primeiro passo e o utilizador escolher o id do produto que quer modificar
	public static void editProduct(){
		Scanner s = new Scanner(System.in);
		System.out.println("Indique o Id do produto que quer editar:");
		Integer id = validateInt(s,false);
		
		//a seguir mostrar os restantes campos associados a esse produto com esse id através do método showProduct()
		System.out.println("O produto com o Id especificado apresenta os seguintes valores: " + 
							ProductRepository.getInstance().showProduct(id));
		
		/*
			a seguir dizer ao utilizador para inserir nestes 3 campos os valores que quer alterar
			se nao inserir nada assumir o valor anteriores
		*/
		
	 
		//depois de o utilizador inserir os novos dados validar e guardar o produto na lista???
		System.out.println("Insira o novo valor de desconto: ");
		Float newDiscount = validatefloat(s,false); 
		System.out.println("Insira o novo valor de IVA: ");
		Float newTax = validatefloat(s,false);
		System.out.println("Insira o novo valor de PVP: ");
		Float newSalePrice = validatefloat(s,false);
		ProductRepository.getInstance().editItem(id,newDiscount,newTax,newSalePrice);      
			
		menu_principal();		
	}
	
	//CONSULTAR PRODUTO - o utilizador primeiro introduz o id do produto que quer consultar e depois aparecem os campos associados a esse produto
	//o que falta?
	public static void consultProduct(){
		Scanner s = new Scanner(System.in);
		
		System.out.println("Inserir Id do produto que quer consultar:");
		Integer id = validateInt(s,false);
		System.out.println("O produto com o Id especificado apresenta os seguintes valores: " + 
				ProductRepository.getInstance().showProduct(id));
		menu_principal();	
	}
	
	//REMOVER PRODUTO - o utilizador primeiro introduz o id do produto que quer remover 
	//o que falta?
	public static void removeProduct(){
		Scanner s = new Scanner(System.in);
		
		System.out.println("Inserir Id do produto que quer eliminar:");
		Integer id = validateInt(s,false);
		
		menu_principal();	
	}
	
	
	
	
	
	
	
	
	
	
	//------------------------------------------------menu prateleiras--------------------------------------------------------------
	//  falta fazer
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
