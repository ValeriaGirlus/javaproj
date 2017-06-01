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
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public float getIVA() {
		return IVA;
	}
	public void setIVA(int IVA) {
		this.IVA = IVA;
	}
	public float getPVP() {
		return PVP;
	}
	public void setPVP(int PVP) {
		this.PVP = PVP;
	}

	public Product(int id, int discount, int IVA, int PVP) {
		this.id = id;
		this.discount = discount;
		this.IVA = IVA;
		this.PVP = PVP;
	}
	
	@Override
	public String toString(){
		return "Id"+ id + "Discount" + discount + "IVA" + IVA  + "PVP" + PVP;
		
	//	System.out.println("P");
	
	}
	
}