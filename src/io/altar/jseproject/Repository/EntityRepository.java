package io.altar.jseproject.Repository;

import java.util.LinkedHashMap;
import java.util.Set;

import io.altar.jseproject.model.Entity;


public abstract class EntityRepository<E extends Entity>{

	// ArrayList<Product> Products = new ArrayList<Product>();
	
	private static LinkedHashMap<Integer, Entity> entityList = new LinkedHashMap<>();
	//o linkhashmap mantém a ordem de inserção dos elementos na lista de produtos ou prateleira
	//por cada produto ou prateleira criada, o id é incrementado por 1 em relação ao 0
		private static Integer id = 0;
		public static Integer getNextId(){
			return ++id;
		}
		
	//neste caso, adicionar o id à lista entityList ou remover, refere-se tanto aos produtos como às prateleiras 
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

		//nao percebo muito bem isto
		public Set<Integer> keySet(){
			return entityList.keySet();
		}
		
		//nao percebo muito bem isto
		public Entity get(Integer id){
			return entityList.get(id);
		}
		
		
}



