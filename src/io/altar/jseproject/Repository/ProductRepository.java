package io.altar.jseproject.Repository;

import io.altar.jseproject.model.Product;




public class ProductRepository extends EntityRepository<Product>{
	
	private static final ProductRepository INSTANCE = new ProductRepository();
	
	private ProductRepository(){}
	
	public static ProductRepository getInstance(){
		return INSTANCE;
	}
	
	//editar os campos dum produto para o id especificado
	public static void editItem(Integer id, float discount, float tax, float saleprice){
		//(casting) vai buscar o id ao EntityRepository 
		//pq está lá este método mas o set está na class Produto 
		((Product)ProductRepository.getInstance().get(id)).setId(id);
		((Product)ProductRepository.getInstance().get(id)).setDiscount(discount);
		((Product)ProductRepository.getInstance().get(id)).setTax(tax);
		((Product)ProductRepository.getInstance().get(id)).setSalePrice(saleprice);
	}
	
	//criar o metodo showProduct() para mostrar os campos do produto quando se introduz o id 
	//isto est� bem???????????
	public String showProduct(Integer id){	
		Float discount = ((Product)ProductRepository.getInstance().get(id)).getDiscount();
		Float tax =((Product)ProductRepository.getInstance().get(id)).getTax();
		Float saleprice = ((Product)ProductRepository.getInstance().get(id)).getSalePrice();
		return "Product ID:" + id + " Discount:" + discount + " IVA:" + tax + " PVP:" + saleprice ;
	}
	
}
