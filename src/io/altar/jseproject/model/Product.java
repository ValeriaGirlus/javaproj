package io.altar.jseproject.model;

public class Product extends Entity {
	private Integer id;
	private float discount;
	private float tax;
	private float saleprice;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
		this.id = id;
		this.discount = discount;
		this.tax = tax;
		this.saleprice = saleprice;
		
	}
	
	/*como o construtor diz que esta undefined, na net diz para fazer um construtor default, sem parametros
	public Product(){
	}
	*/
	
	@Override
	public String toString(){
		return "Id: "+ id + ", Discount: " + discount + ", IVA: " + tax  + ", PVP: " + saleprice;
	}
}