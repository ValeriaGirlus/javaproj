package io.altar.repository;

import io.altar.repository.EntityRepository;
import io.altar.repository.ProductRepository;
import io.altar.model.Product;

public class ProductRepository extends EntityRepository<Product>{
	
	private static final ProductRepository INSTANCE = new ProductRepository();
	
	private ProductRepository(){}
	
	public static ProductRepository getInstance(){
		return INSTANCE;
	}
	
	public static void editdiscount(Integer id, float discount){
		((Product)ProductRepository.getInstance().get(id)).setDiscount(discount);
	}
	
	public static void edittax(Integer id, float tax){
		((Product)ProductRepository.getInstance().get(id)).setTax(tax);
	}
	
	public static void editsaleprice(Integer id, float saleprice){
		((Product)ProductRepository.getInstance().get(id)).setSalePrice(saleprice);
	}
}
