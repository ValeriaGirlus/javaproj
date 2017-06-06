package io.altar.jseproject.Repository;

import java.util.LinkedHashMap;
import java.util.Set;

import io.altar.jseproject.model.Entity;


public abstract class EntityRepository<E extends Entity>{

	// ArrayList<Product> Products = new ArrayList<Product>();
	
	private static LinkedHashMap<Integer, Entity> entityList = new LinkedHashMap<>();
		private static Integer id = 0;
		public static Integer getNextId(){
			return ++id;
		}
		
	//adicionar a lista de produtos os ids dos produtos, ou remover um produto
		public void addToList(Entity e){
			entityList.put(e.getId(),e);	
		}
		
		public void removeItem(Entity e){
			entityList.remove(e.getId(),e);
		}
		
		//se a lista,quer dos products ou shelves, estiver vazia, retorna vazio
		public boolean isEmpty(){
			return entityList.isEmpty();
		}

		//
		public Set<Integer> keySet(){
			return entityList.keySet();
		}
		
		public Entity get(Integer id){
			return entityList.get(id);
		}
		
		
}



