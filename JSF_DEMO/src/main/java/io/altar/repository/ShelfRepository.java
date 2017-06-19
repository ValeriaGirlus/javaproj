package io.altar.repository;

import io.altar.repository.EntityRepository;
import io.altar.repository.ShelfRepository;
import io.altar.model.Shelf;

public class ShelfRepository extends EntityRepository<Shelf>{
	
	private static final ShelfRepository INSTANCE = new ShelfRepository();
	
	private ShelfRepository(){}
	
	public static ShelfRepository getInstance(){
		return INSTANCE;
	}
	
	public static void editlocation(Integer id, int location){
		((Shelf)ShelfRepository.getInstance().get(id)).setLocation(location);
	}
	
	public static void editcapacity(Integer id, int capacity){
		((Shelf)ShelfRepository.getInstance().get(id)).setCapacity(capacity);
	}
	
	public static void editprice(Integer id, float price){
		((Shelf)ShelfRepository.getInstance().get(id)).setPrice(price);
	}
}
