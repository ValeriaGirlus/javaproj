package io.altar.jseproject.model;

public class Shelf {
	private int shelfId;
	private int code;
	private int capacity;
	private float price;
	
	public int getShelfId() {
		return shelfId;
	}
	public void setShelfId(int shelfId) {
		this.shelfId = shelfId;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
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
	public void setPrice(int price) {
		this.price = price;
	}
	
	public Shelf(int shelfId, int code, int capacity, int price) {
		super();
		this.shelfId = shelfId;
		this.code = code;
		this.capacity = capacity;
		this.price = price;
	}
}
