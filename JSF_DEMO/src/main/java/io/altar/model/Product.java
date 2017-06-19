package io.altar.model;

import io.altar.repository.ProductRepository;
import io.altar.model.Entity;
	
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

	
		public Product(Integer id, float discount, float tax, float saleprice) {
			//this.id = id;
			this.discount = discount;
			this.tax = tax;
			this.saleprice = saleprice;
			ProductRepository.getInstance().addToList(this);
		}
		
	
		@Override
		public String toString(){
			return "Id: "+ getId() + ", Discount: " + discount + ", IVA: " + tax  + ", PVP: " + saleprice + "\n";
		}
	}

