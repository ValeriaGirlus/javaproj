package io.altar.jseproject.Repository;

import java.util.LinkedHashMap;
import java.util.Set;

import io.altar.jseproject.model.Entity;


public abstract class EntityRepository<E extends Entity>{

	// ArrayList<Product> Products = new ArrayList<Product>();
	
	private static LinkedHashMap<Integer, Entity> entityList = new LinkedHashMap<>();
	//o linkhashmap mant�m a ordem de inser��o dos elementos na lista de produtos ou prateleira
	//por cada produto ou prateleira criada, o id � incrementado por 1 em rela��o ao 0
		private static Integer id = 0;
		public static Integer getNextId(){
			return ++id;
		}
		
	//neste caso, adicionar o id � lista entityList ou remover, refere-se tanto aos produtos como �s prateleiras 
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



