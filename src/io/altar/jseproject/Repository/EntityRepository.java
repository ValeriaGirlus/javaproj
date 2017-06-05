package io.altar.jseproject.Repository;

import java.util.LinkedHashMap;

import io.altar.jseproject.model.Entity;
import io.altar.jseproject.model.Product;

public abstract class EntityRepository<E extends Entity>{

	// ArrayList<Product> Products = new ArrayList<Product>();
	
	private static LinkedHashMap<Integer, Product> productList = new LinkedHashMap<Integer, Product>();
		private Integer index = 0;
		protected Integer getNextId(){
			return ++index;
		}
	
	//adicionar a lista de produtos os ids dos produtos, editar os parametros dos produtos dentro da lista, remover um produto
		public void addToList(Product p){
			productList.put(p.getId(),p);
			System.out.println(productList);
		}
		
		public void editItem(Integer id, float discount, float tax, float saleprice){
			productList.get(id).setId(id);
			productList.get(discount).setDiscount(discount);
			productList.get(tax).setTax(tax);
			productList.get(saleprice).setSalePrice(saleprice);
		}
		
		public void removeItem(Product p){
			productList.remove(p.getId(),p);
		}

}

//https://stackoverflow.com/questions/14243923/deleting-a-selected-item-using-linked-hash-map

