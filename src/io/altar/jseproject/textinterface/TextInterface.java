package io.altar.jseproject.textinterface;

import java.util.Scanner;

import io.altar.jseproject.Repository.ProductRepository;
import io.altar.jseproject.Repository.ShelfRepository;
import io.altar.jseproject.Repository.EntityRepository;
import io.altar.jseproject.model.Entity;
import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.util.Utils;;


public class TextInterface {
	
	public static ProductRepository ProductList = ProductRepository.getInstance();
	public static ProductRepository ShelfList = ShelfRepository.getInstance();
	
	//---------------------------------------menu principal--------------------------------------------------
	//as op��es que aparecem ao utilizador no primeiro ecr� que � o menu principal i.e o primeiro que aparece
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
	
	//-------------------------------------menu produtos----------------------------------------------------
	//o utilizador ao clicar 1 no menu principal aparece um segundo ecr� com o menu para os produtos
	public static void menu_product() {
		// aparecer a lista dos produtos que h�, antes de aparecerem as op��es
		System.out.println("Lista de produtos:");
		if(ProductList.isEmpty()){
			System.out.println("A lista est� vazia");
			
		}
		else{
			for(Integer id : ProductList.keySet()){
					System.out.println(ProductList.get(id));
				}
		}
		//o id aparece null na lista de produtos!!!!!!
		
		System.out.println("Por favor seleccione uma das seguintes op��es:");
		System.out.println("1)Criar novo produto");
		System.out.println("2)Editar um produto existente");
		System.out.println("3)Consultar o detalhe do produto");
		System.out.println("4)Remover um produto");
		System.out.println("5)Voltar ao ecr� anterior");
		
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
	//o utilizador ao clicar 2 no menu principal aparece um segundo ecr� com o menu para as prateleiras
	public static void menu_shelf() {
		System.out.println("Por favor seleccione uma das seguintes op��es:");
		System.out.println("1)Criar nova prateleira");
		System.out.println("2)Editar uma prateleira existente");
		System.out.println("3)Consultar o detalhe da prateleira");
		System.out.println("4)Remover uma prateleira");
		System.out.println("5)Voltar ao ecr� anterior");
		
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
	//no menu_principal o utilizador tem que inserir uma op��o das 3 dispon�veis (m�nimo o valor 1 e m�ximo o valor 3) 
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
		//o utilizador n�o precisa de escrever o id porque � gerado automaticamente
		//o utilizador preenche os outros campos, sendo que � preciso validar o que escreve
		System.out.println("Inserir Id do produto:");
		//ver isto melhor!
		Integer id = ProductRepository.getNextId();
		System.out.println("Inserir valor de desconto do produto:");
		Float discount = Utils.validatefloat(s,false);
		System.out.println("Inserir IVA do produto:");
		Float tax = Utils.validatefloat(s, false);
		System.out.println("Inserir PVP do produto:");
		Float saleprice = Utils.validatefloat(s, false);
		//os campos que foram preenchidos v�o ser inseridos no produto e vai aparecer neste formato cada produto 
		System.out.println("Product: " + " ID:" + id + " Discount:" + discount + " IVA:" + tax + " PVP:" + saleprice);	
		
		//perceber isto melhor!
		new Product(id,discount,tax,saleprice);
						
		//voltar para o menu principal
		menu_principal();
		
		//falta inserir o produto numa prateleira - pode estar en 0 ou n prateleiras
		
	}
	
	//EDITAR PRODUTO - o primeiro passo e o utilizador escolher o id do produto que quer modificar
	public static void editProduct(){
		if(ProductList.isEmpty()){
			System.out.println("Nao existe nenhum produto disponível para editar");
		}else{
			Scanner s = new Scanner(System.in);
			System.out.println("Para o Id do produto que quer editar:");
			Integer id = Utils.validateInt(s,false);
			//verificar se o id existe na lista dos produtos
			int key = s.nextInt();
			if (ProductList.containsKey(key)){
				System.out.println("Key:" + key);
			}else{
				System.out.println("Este Id nao existe na lista de produtos");
		}
			
		//dizer que o produto está na prateleira x
		//System.out.println("O produto com o Id" + ProductRepository.getInstance().get(id) + "está guardado na prateleira" +  );
		
		//a seguir mostrar os restantes campos associados a esse produto com esse id 
		System.out.println("O produto com o Id especificado apresenta os seguintes valores: " + 
				ProductList.get(id));
		
		//a seguir dizer o utilizador altera os 3 campos, se nao inserir nada assumir o valor anteriores
		//depois de o utilizador inserir os novos dados validar e guardar o produto na lista
		System.out.println("Insira o novo valor de desconto: ");
		//Float newDiscount = Utils.validatefloat(s,false);
		while(true){
		Scanner sc = new Scanner(System.in);
		float newDiscount = sc.nextFloat();
		if(newDiscount =   ){
			
			}
		}
		System.out.println("Insira o novo valor de IVA: ");
		Float newTax = Utils.validatefloat(s,false);
		System.out.println("Insira o novo valor de PVP: ");
		Float newSalePrice = Utils.validatefloat(s,false);
		System.out.println("Product: " + " ID:" + id + " Discount:" + newDiscount + " IVA:" + newTax + " PVP:" + newSalePrice);
		
		ProductRepository.editItem(id,newDiscount,newTax,newSalePrice);
					
		menu_principal();		
		}
	}
	//CONSULTAR PRODUTO - o utilizador primeiro introduz o id do produto que quer consultar e depois aparecem os campos associados a esse produto
	public static void consultProduct(){
		Scanner s = new Scanner(System.in);
		if(ProductList.isEmpty()){
			System.out.println("Nao existe nenhum produto");		
		}else{
		System.out.println("Inserir Id do produto que quer consultar:");
		Integer id = Utils.validateInt(s,false);

		System.out.println("O produto com o Id especificado apresenta os seguintes valores: " + ProductList.get(id) + "e enconta-se na parteleira");
		menu_principal();	
		}
	}
	//REMOVER PRODUTO - o utilizador primeiro introduz o id do produto que quer remover 
	public static void removeProduct(){
		if(ProductList.isEmpty()){
			System.out.println("Nao existe nenhum produto disponível para eliminar");
		}else{
			Scanner s = new Scanner(System.in);
			System.out.println("Inserir Id do produto que quer eliminar:");
			Integer id = Utils.validateInt(s,false);
			System.out.println("Tem a certeza que pretende eliminar este produto? Se sim pressione S, se nao pressione N");
			while(true){
				String letter = s.nextLine();
				if (letter.equals("S")){
					ProductList.removeItem(id);
					TextInterface.menu_product();;	
				}else if(letter.equals("N")){
					TextInterface.menu_product();
				}else
					System.out.println("Este Id nao existe na lista de produtos");
				}
			}	
		TextInterface.menu_principal();	
	}
	
	//------------------------------------------------menu prateleiras--------------------------------------------------------------
	
	public static void createShelf(){
		Scanner s = new Scanner(System.in);
		//o utilizador n�o precisa de escrever o id porque � gerado automaticamente
		//o utilizador preenche os outros campos, sendo que � preciso validar o que escreve
		System.out.println("Inserir Id do produto:");		
		Integer id = ShelfRepository.getNextId();
		System.out.println("Inserir a localizacao da prateleira:");
		int location = Utils.validateInt(s,false);
		System.out.println("Inserir IVA do produto:");
		int capacity = Utils.validateInt(s,false);
		System.out.println("Inserir PVP do produto:");
		Float price = Utils.validatefloat(s,false);
		System.out.println("Product: " + " ID:" + id + " Location:" + location + "Capacity :" + capacity + " Price:" + price);	
		
		new Shelf(id,location,capacity,price);
						
		menu_principal();
		
		//falta dizer que a prateleira tem x produtos
		
	}
	public static void editShelf(){
		
	}
	
	public static void consultShelf(){
		
	}
	
	public static void removeShelf(){
		
	}
	
}
			
				
