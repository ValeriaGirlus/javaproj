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
	public static ShelfRepository ShelfList = ShelfRepository.getInstance();
	
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
			System.out.println("Insira o Id do produto que quer editar:");
			Integer id = Utils.validateInt(s,false);
			//verificar se o id existe na lista dos produtos
			if (ProductList.containsKey(id)){
				System.out.println("O produto contém a seguinte informacao:" + ProductList.get(id));
				System.out.println("Tem a certeza que pretende editar este produto? Se sim pressione s, se nao pressione n");
				while(true){
					String letter = s.nextLine();
					if (letter.equals("s")){
						System.out.println("Para mudar o valor do desconto insire um novo valor: ");
						Float newDiscount = Utils.validatefloat(s, false);
						System.out.println("Para mudar o valor do IVA insire um novo valor: ");
						Float newTax = Utils.validatefloat(s, false);
						System.out.println("Para mudar o valor do PVP insire um novo valor: ");
						Float newSalePrice = Utils.validatefloat(s, false);
						System.out.println("O produto modificado apresenta os seguintes valores: " + " ID:" + id + " Discount:" + newDiscount + " IVA:" + newTax + " PVP:" + newSalePrice);
						System.out.println("Para voltar ao menu principal pressione ");
						String  = s.nextLine();
							while(true){
							if (letter.equals("s")){
							menu_product();
							}
							}
					}else if(letter.equals("n")){
						TextInterface.menu_product();
				
			}else{
				System.out.println("Este Id nao existe na lista de produtos");
					}
				}
			}
		}
			//ProductRepository.editItem(id,newDiscount,newTax,newSalePrice);
			
		//dizer que o produto está na prateleira x
		//System.out.println("O produto com o Id" + ProductRepository.getInstance().get(id) + "está guardado na prateleira" +  )
		
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
			System.out.println("Tem a certeza que pretende eliminar este produto? Se sim pressione s, se nao pressione n");
			while(true){
				String letter = s.nextLine();
				if (letter.equals("s")){
					ProductList.removeItem(id);
					menu_product();	
				}else if(letter.equals("n")){
					TextInterface.menu_product();
				}else
					System.out.println("Este Id nao existe na lista de produtos");
				}
			}	
		menu_principal();	
	}
	
	//------------------------------------------------menu prateleiras--------------------------------------------------------------
	
	public static void createShelf(){
		Scanner s = new Scanner(System.in);
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
		if(ShelfList.isEmpty()){
			System.out.println("Nao existe nenhuma prateleira disponível para editar");
		}else{
			Scanner s = new Scanner(System.in);
			System.out.println("Insira o Id da prateleira que quer editar:");
			Integer id = Utils.validateInt(s,false);
			//verificar se o id existe na lista dos produtos
			if (ShelfList.containsKey(id)){
				System.out.println("A prateleira contém a seguinte informacao:" + ShelfList.get(id));
				System.out.println("Para mudar o valor da localizacao insire um novo valor: ");
				Float newLocation = Utils.validatefloat(s, false);
				System.out.println("Para mudar o valor da capacidade insire um novo valor: ");
				Float newCapacity = Utils.validatefloat(s, false);
				System.out.println("Para mudar o valor do preco insire um novo valor: ");
				Float newPrice = Utils.validatefloat(s, false);
				System.out.println("O produto modificado apresenta os seguintes valores: " + " ID:" + id + " Location: " + newLocation + " Capacity: " + newCapacity + "Price: " + newPrice);
			}else{
				System.out.println("Este Id nao existe na lista de prateleiras");
		}
		
			//ShelfRepository.editItem(id,newLocation,newCapacity,newPrice);
								
		menu_principal();		
		}
	}
	
	public static void consultShelf(){
		Scanner s = new Scanner(System.in);
		if(ShelfList.isEmpty()){
			System.out.println("Nao existe nenhuma prateleira");		
		}else{
		System.out.println("Inserir Id da prateleira que quer consultar:");
		Integer id = Utils.validateInt(s,false);
		
		//falta ir buscar os produtos contidos nessa prateleira
		System.out.println("A prateleira com o Id especificado apresenta os seguintes valores: " + ShelfList.get(id) + "e contem os seguintes produtos:");
		menu_principal();	
		}
	}
	
	public static void removeShelf(){
		if(ShelfList.isEmpty()){
			System.out.println("Nao existe nenhuma prateleira disponível para eliminar");
		}else{
			Scanner s = new Scanner(System.in);
			System.out.println("Inserir Id da prateleira que quer eliminar:");
			Integer id = Utils.validateInt(s,false);
			System.out.println("Tem a certeza que pretende eliminar esta prateleira? Se sim pressione s, se nao pressione n");
			while(true){
				String letter = s.nextLine();
				if (letter.equals("s")){
					ShelfList.removeItem(id);
					menu_product();;	
				}else if(letter.equals("n")){
					menu_product();
				}else
					System.out.println("Este Id nao existe na lista de prateleiras");
				}
			}	
		menu_principal();	
	}
}

			
				
