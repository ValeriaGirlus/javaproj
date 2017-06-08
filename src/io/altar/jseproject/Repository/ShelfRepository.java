package io.altar.jseproject.Repository;

import io.altar.jseproject.model.Shelf;

public class ShelfRepository extends EntityRepository<Shelf>{
	
	private static final ShelfRepository INSTANCE = new ShelfRepository();
	
	private ShelfRepository(){}
	
	public static ShelfRepository getInstance(){
		return INSTANCE;
	}
	
	//editar os campos duma prateleira para o id especificado
	public static void editItem(Integer id, int location, int capacity, float price){
		//(casting) vai buscar o id ao EntityRepository 
		((Shelf)ShelfRepository.getInstance().get(id)).setId(id);
		((Shelf)ShelfRepository.getInstance().get(id)).setLocation(location);
		((Shelf)ShelfRepository.getInstance().get(id)).setCapacity(capacity);
		((Shelf)ShelfRepository.getInstance().get(id)).setPrice(price);
	}
}
