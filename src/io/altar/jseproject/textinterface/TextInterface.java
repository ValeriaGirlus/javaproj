package io.altar.jseproject.textinterface;

import java.util.ArrayList;
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
	//as opções que aparecem ao utilizador no primeiro ecrã que é o menu principal 
	public static void menu_principal() {
		System.out.println("Por favor seleccione uma das seguintes opções: ");
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
		if(ProductList.isEmpty()){
			System.out.println("A lista está vazia\n");	
		}
		else{
			for(Integer id : ProductList.keySet()){
					System.out.println(ProductList.get(id));
			}
		}
		System.out.println("Por favor seleccione uma das seguintes opções: ");
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
		
		System.out.println("Lista de prateleiras:");
		if(ShelfList.isEmpty()){
			System.out.println("A lista está vazia\n");	
		}
		else{
			for(Integer id : ShelfList.keySet()){
					System.out.println(ShelfList.get(id));
			}
		}
		System.out.println("Por favor seleccione uma das seguintes opções: ");
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
					System.out.println("Por favor introduza um número entre " + min + " e " + max);
				}
			} else {
				System.out.println("Por favor introduza um número");
				s.next();
				s.close();
			}
		}
	}
	
	//------------------------------------------------menu produtos-----------------------------------------------------------
	//CRIAR PRODUTO
	public static void createProduct(){
		//criar um array da shelf para guardar os ids dos produtos criados
		ArrayList <Integer> shelfIdList = new ArrayList();
		
		Scanner s = new Scanner(System.in);
		//o utilizador nao precisa de escrever o id porque é gerado automaticamente
		//o utilizador preenche os outros campos, sendo que é preciso validar o que escreve
		Integer id = ProductRepository.getNextId();
		System.out.println("Inserir valor de desconto do produto:");
		Float discount = Utils.validatefloat(s,false);
		System.out.println("Inserir IVA do produto:");
		Float tax = Utils.validatefloat(s, false);
		System.out.println("Inserir PVP do produto:");
		Float saleprice = Utils.validatefloat(s, false);
		//os campos que foram preenchidos vão ser inseridos no produto e vai aparecer neste formato cada produto 
		System.out.println("Product: " + " ID: " + id + " Discount: " + discount + " IVA: " + tax + " PVP: " + saleprice + "\n");	
		
		new Product(id,discount,tax,saleprice);
		
		//inserir o produto numa prateleira - pode estar em 0 ou n prateleiras
		if(ShelfList.keySet().isEmpty()){
			System.out.println("Não existem prateleiras disponíveis para guardar o produto\n");
		}else{
			System.out.println("Em que prateleira pretende guardar o produto criado?\n");
			Scanner sc = new Scanner(System.in);
//			Integer shelfId =

//			shelfIdList.add(id);
			sc.close();
		}
		TextInterface.menu_principal();
	}
	
	
	//EDITAR PRODUTO - o primeiro passo e o utilizador escolher o id do produto que quer modificar
	public static void editProduct(){
		if(ProductList.isEmpty()){
			System.out.println("Não existe nenhum produto disponível para editar");
		}else{
			Scanner s = new Scanner(System.in);
			System.out.println("Insira o Id do produto que quer editar:\n");
			Integer id = Utils.validateInt(s,false);
			//verificar se o id existe na lista dos produtos
			if (ProductList.containsKey(id)){
				System.out.println("O produto contém a seguinte informação:" + ProductList.get(id) + "e encontra-se na prateleira" + ShelfList.get(id));

				System.out.println("Tem a certeza que pretende editar este produto? Se sim pressione s, se não pressione n \n");
				while(true){
					Scanner sc = new Scanner(System.in);
					String letter = sc.nextLine();
					if (letter.equals("s")){
						while(true){
							System.out.println("Para editar este produto:");
							System.out.println("1)Alterar o valor do desconto: ");
							System.out.println("2)Alterar o valor do IVA: ");
							System.out.println("3)Alterar o valor do PVP: ");
							
							int input = getInput(1,3);
							switch(input){
							case 1:
								System.out.println("Insira o novo valor do desconto");
								Float newDiscount = Utils.validatefloat(s, false);
								ProductRepository.editdiscount(id,newDiscount);
								System.out.println(ProductList.get(id));
								break;
							case 2:	
								System.out.println("Insira o novo valor do IVA");
								Float newTax = Utils.validatefloat(s, false);
								ProductRepository.edittax(id,newTax);
								System.out.println(ProductList.get(id));
								break;
							case 3:		
								System.out.println("Insira o novo valor do PVP");
								Float newSalePrice = Utils.validatefloat(s, false);
								ProductRepository.editsaleprice(id,newSalePrice);
								System.out.println(ProductList.get(id));
								break;
								
							}
						TextInterface.menu_product();	
						}
					//System.out.println("O produto modificado apresenta os seguintes valores: " + " ID:" + id + " Discount:" + newDiscount + " IVA:" + newTax + " PVP:" + newSalePrice + "\n");
						
					}else if(letter.equals("n")){
						TextInterface.menu_product();
						sc.close();
		}else{
			System.out.println("Este Id nao existe na lista de produtos");
				}
			}
		}
	}			
}	
	
	//CONSULTAR PRODUTO - o utilizador primeiro introduz o id do produto que quer consultar e depois aparecem os campos associados a esse produto
	public static void consultProduct(){
		Scanner s = new Scanner(System.in);
		if(ProductList.isEmpty()){
			System.out.println("Não existe nenhum produto");		
		}else{
			System.out.println("Inserir Id do produto que quer consultar:");
			Integer id = Utils.validateInt(s,false);

		System.out.println("O produto com o Id especificado apresenta os seguintes valores: " + ProductList.get(id) + "e enconta-se na prateleira" + ShelfList.get(id));
		
		TextInterface.menu_principal();	
		}
	}
	
	//REMOVER PRODUTO - o utilizador só introduz o id do produto que quer remover 
	public static void removeProduct(){
		if(ProductList.isEmpty()){
			System.out.println("Não existe nenhum produto disponível para eliminar");
		}else{
			Scanner s = new Scanner(System.in);
			System.out.println("Inserir Id do produto que quer eliminar:");
			Integer id = Utils.validateInt(s,false);
			System.out.println("Tem a certeza que pretende eliminar este produto? Se sim pressione s, se não pressione n");
			while(true){
				String letter = s.nextLine();
				if (letter.equals("s")){
					ProductList.removeItem(id);
					TextInterface.menu_product();	
				}else if(letter.equals("n")){
					TextInterface.menu_product();
					s.close();
				}else
					System.out.println("Este Id não existe na lista de produtos");
				}
			}	
		TextInterface.menu_principal();	
	}
	
	//------------------------------------------------menu prateleiras--------------------------------------------------------------
	
	public static void createShelf(){
		Scanner s = new Scanner(System.in);		
		//adiciona-me a prateleira lista dos produtos!!!!!!!
		Integer id = ShelfRepository.getNextId();
		System.out.println("Inserir a localizacao da prateleira:");
		int location = Utils.validateInt(s,false);
		System.out.println("Inserir a capacidade da prateleira:");
		int capacity = Utils.validateInt(s,false);
		System.out.println("Inserir o preço da prateleira:");
		Float price = Utils.validatefloat(s,false);
		System.out.println("Shelf: " + " ID: " + id + " Location: " + location + "Capacity: " + capacity + " Price: " + price);	
		
		new Shelf(id,location,capacity,price);
						
		TextInterface.menu_principal();
		
		//falta dizer que a prateleira pode conter 0 ou 1 x produto....
		}
	
	
	public static void editShelf(){
		if(ShelfList.isEmpty()){
			System.out.println("Nao existe nenhuma prateleira disponível para editar");
		}else{
			Scanner s = new Scanner(System.in);
			System.out.println("Insira o Id da prateleira que quer editar:");
			Integer id = Utils.validateInt(s,false);
		
			if (ShelfList.containsKey(id)){

				System.out.println("A prateleira contém a seguinte informação:" + ShelfList.get(id) + "e contém os seguintes produtos" + ProductList.get(id));

				System.out.println("Tem a certeza que pretende editar esta prateleira? Se sim pressione s, se não pressione n \n");
				while(true){
					Scanner sc = new Scanner(System.in);
					String letter = sc.nextLine();
					if (letter.equals("s")){
						while(true){
							System.out.println("Para editar esta prateleira:");
							System.out.println("1)Alterar o valor da localização: ");
							System.out.println("2)Alterar o valor da capacidade: ");
							System.out.println("3)Alterar o valor do preço: ");
							
							int input = getInput(1,3);
							switch(input){
							case 1:
								System.out.println("Insira o novo valor da localização");
								int newLocation = Utils.validateInt(s, false);
								ShelfRepository.editlocation(id,newLocation);
								System.out.println(ShelfList.get(id));
								break;
							case 2:	
								System.out.println("Insira o novo valor da capacidade");
								int newCapacity = Utils.validateInt(s, false);
								ShelfRepository.editcapacity(id,newCapacity);
								System.out.println(ShelfList.get(id));
								break;
							case 3:		
								System.out.println("Insira o novo valor do preço");
								Float newPrice = Utils.validatefloat(s, false);
								ShelfRepository.editprice(id,newPrice);
								System.out.println(ShelfList.get(id));
								break;
								
							}
						TextInterface.menu_product();	
						}
					//System.out.println("A prateleira modificada apresenta os seguintes valores: " + " ID: " + id + " Location: " + newLocation + " Capacity: " + newCapacity + " Price: " + newPrice + "\n");
						
					}else if(letter.equals("n")){
						TextInterface.menu_product();
						sc.close();
		}else{
			System.out.println("Este Id nao existe na lista de prateleiras");
				}
			}
		}
	}			
}	
	
	public static void consultShelf(){
		Scanner s = new Scanner(System.in);
		if(ShelfList.isEmpty()){
			System.out.println("Nao existe nenhuma prateleira");		
		}else{
		System.out.println("Inserir Id da prateleira que quer consultar:");
		Integer id = Utils.validateInt(s,false);
		
		System.out.println("A prateleira com o Id especificado apresenta os seguintes valores: " + ShelfList.get(id) + "e contém os seguintes produtos: " + ProductList.get(id));
		TextInterface.menu_principal();	
		}
	}
	
	public static void removeShelf(){
		if(ShelfList.isEmpty()){
			System.out.println("Nao existe nenhuma prateleira disponível para eliminar");
		}else{
			Scanner s = new Scanner(System.in);
			System.out.println("Inserir Id da prateleira que quer eliminar:");
			Integer id = Utils.validateInt(s,false);
			System.out.println("Tem a certeza que pretende eliminar esta prateleira? Se sim pressione s, se não pressione n");
			while(true){
				String letter = s.nextLine();
				if (letter.equals("s")){
					ShelfList.removeItem(id);
					TextInterface.menu_product();;	
				}else if(letter.equals("n")){
					TextInterface.menu_product();
				}else
					System.out.println("Este Id não existe na lista de prateleiras");
				}
			}	
		TextInterface.menu_principal();	
	}
}

			
				
