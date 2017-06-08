package io.altar.jseproject.util;

import java.util.Scanner;


public class Utils {
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
			System.out.println(input);
		}
		*/