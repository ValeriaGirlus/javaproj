package io.altar.jseproject.model;

import io.altar.jseproject.Repository.ProductRepository;
 

public class Product extends Entity {
	//private Integer id;
	private float discount;
	private float tax;
	private float saleprice;
	/*
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	*/
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public float getTax() {
		return tax;
	}
	public void setTax(float tax) {
		this.tax = tax;
	}
	public float getSalePrice() {
		return saleprice;
	}
	public void setSalePrice(float saleprice) {
		this.saleprice = saleprice;
	}

	//o construtor 
	public Product(Integer id, float discount, float tax, float saleprice) {
		//this.id = id;
		this.discount = discount;
		this.tax = tax;
		this.saleprice = saleprice;
		ProductRepository.getInstance().addToList(this);
	}
	
	//o id nao vai ser inserido pelo utilizador mas vem do método da Superclass 
	@Override
	public String toString(){
		return "Id: "+ getId() + ", Discount: " + discount + ", IVA: " + tax  + ", PVP: " + saleprice;
	}
}