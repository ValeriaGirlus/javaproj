package io.altar.jseproject.Repository;

import io.altar.jseproject.model.Product;



public class ProductRepository extends EntityRepository<Product>{
	
	private static final ProductRepository INSTANCE = new ProductRepository();
	
	private ProductRepository(){}
	
	public static ProductRepository getInstance(){
		return INSTANCE;
	}
	
	//editar os parametros dum produto para o id especificado
	//o que está mal?
	public void editItem(Integer id, float discount, float tax, float saleprice){
		entityList.get(id).setId(id);
		entityList.get(id).setDiscount(discount);
		entityList.get(id).setTax(tax);
		entityList.get(id).setSalePrice(saleprice);
	}
	
	//criar o metodo showProduct() para mostrar os campos do produto quando se introduz o id 
	//o que está mal?
	public static void showProduct(){
		return entityList.getId(id);
		return entityList.get(id).get(discount);
		return entityList.get(id).get(tax);
		return entityList.get(id).get(saleprice);
	}
	
}
