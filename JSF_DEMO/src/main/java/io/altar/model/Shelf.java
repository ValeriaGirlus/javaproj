package io.altar.model;

import io.altar.repository.ShelfRepository;
import io.altar.model.Entity;

public class Shelf extends Entity{
	private int shelfId;
	private int location;
	private int capacity;
	private float price;
	
	public int getShelfId() {
		return shelfId;
	}
	public void setShelfId(int shelfId) {
		this.shelfId = shelfId;
	}
	
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public Shelf(int shelfId, int location, int capacity, float price) {
		this.shelfId = shelfId;
		this.location = location;
		this.capacity = capacity;
		this.price = price;
		ShelfRepository.getInstance().addToList(this);
	}
	
	@Override
	public String toString(){
		return "Id: "+ getId() + ", Location: " + location + ", Capacity: " + capacity  + ", Price: " + price;
	}
}
