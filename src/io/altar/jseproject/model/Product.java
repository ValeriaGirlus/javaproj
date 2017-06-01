package io.altar.jseproject.model;

public class Product {
	private int id;
	private float discount;
	private float IVA;
	private float PVP;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public float getIVA() {
		return IVA;
	}
	public void setIVA(float IVA) {
		this.IVA = IVA;
	}
	public float getPVP() {
		return PVP;
	}
	public void setPVP(float PVP) {
		this.PVP = PVP;
	}

	//o construtor 
	public Product(int id, float discount, float IVA, float PVP) {
		this.id = id;
		this.discount = discount;
		this.IVA = IVA;
		this.PVP = PVP;
	}
	
	//como o construtor diz que esta undefined, na net diz para fazer um construtor default, sem parametros
	public Product(){
		
	}
	
	@Override
	public String toString(){
		return "Id"+ id + "Discount" + discount + "IVA" + IVA  + "PVP" + PVP;
		
		System.out.println("Product");
	
	}
	
}