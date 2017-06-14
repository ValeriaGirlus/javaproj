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
					catch(NumberFormatException e){
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
					catch(NumberFormatException e){
						System.out.println("Tente outra vez");
						
					}
				}
			}
		}	
}
