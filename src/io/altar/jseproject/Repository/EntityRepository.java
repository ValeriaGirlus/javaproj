package io.altar.jseproject.Repository;

import java.util.LinkedHashMap;

import io.altar.jseproject.model.Entity;
import io.altar.jseproject.model.Product;

public abstract class EntityRepository<E extends Entity>{

	//ArrayList<Product> Products = new ArrayList<Product>();
	
	private static LinkedHashMap<Integer, Product> productList = new LinkedHashMap<Integer, Product>();
		
	
	//adicionar a lista de produtos os ids dos produtos, editar os parametros dos produtos dentro da lista, remover um produto
		public void addToList(Product p){
			productList.put(p.getId(),p);
		}
		
		public void editItem(Integer id, float discount, float IVA, float PVP){
			productList.get(id).setDiscount(discount);
			productList.get(discount).setDiscount(discount);
			productList.get(IVA).setIVA(IVA);
			productList.get(PVP).setPVP(PVP);
		}
		
		public void removeItem(Product p){
			productList.remove(p.getId(),p);
		}
	
	/*
	private Map<Integer, E> entities = new HashMap<>();
		
		private Integer index = 0;
		protected Integer getNextId(){
			return ++index;
	*/
}



