package io.altar.repository;

import java.util.LinkedHashMap;
import java.util.Set;

import io.altar.model.Entity;


public abstract class EntityRepository<E extends Entity>{

	
	
	private LinkedHashMap<Integer, Entity> entityList = new LinkedHashMap<>();
		private static Integer id = 0;
		public static Integer getNextId(){
			return ++id;
		}
		
		public void addToList(Entity e){
			e.setId(id);
			entityList.put(e.getId(),e);
		}
		
		public void removeItem(Integer id){
			entityList.remove(id);
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
			
		public boolean containsKey(int key){
			return entityList.containsKey(key);
		}
		
}

