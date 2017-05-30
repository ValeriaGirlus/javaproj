package io.altar.jseproject.model;

public class Product {
	private int productid;
	private float value;
	private float IVA;
	private float PVP;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int id) {
		this.productId = productId;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getIVA() {
		return IVA;
	}
	public void setIVA(int iVA) {
		IVA = iVA;
	}
	public int getPVP() {
		return PVP;
	}
	public void setPVP(int pVP) {
		PVP = pVP;
	}
	
}
