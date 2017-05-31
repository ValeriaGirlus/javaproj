package io.altar.jseproject.model;

public class Product {
	private int id;
	private int value;
	private int IVA;
	private int PVP;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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