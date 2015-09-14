/**
 * 
 */
package aerospike.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aerospike.springboot.domain.Product;
import aerospike.springboot.repositories.ProductRepository;

/**
 *
 *
 * @author Peter Milne
 * @author Jean Mercier
 *
 */
@Service
public class ProductServiceImpl implements ProductService {
	
	   private ProductRepository productRepository;

	    @Autowired
	    public void setProductRepository(ProductRepository productRepository) {
	        this.productRepository = productRepository;
	    }


	/* (non-Javadoc)
	 * @see aerospike.springboot.services.ProductService#listAllProducts()
	 */
	@Override
	public Iterable<Product> listAllProducts() {
		return productRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see aerospike.springboot.services.ProductService#getProductById(java.lang.Integer)
	 */
	@Override
	public Product getProductById(Integer id) {
		 return productRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see aerospike.springboot.services.ProductService#saveProduct(aerospike.springboot.domain.Product)
	 */
	@Override
	public Product saveProduct(Product product) {
		  return productRepository.save(product);
	}

	/* (non-Javadoc)
	 * @see aerospike.springboot.services.ProductService#deleteProduct(java.lang.Integer)
	 */
	@Override
	public void deleteProduct(Integer id) {
		   productRepository.delete(id);

	}

}
