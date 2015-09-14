/**
 * 
 */
package aerospike.springboot.repositories;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import aerospike.springboot.configuration.RepositoryConfiguration;
import aerospike.springboot.domain.Product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 *
 *
 * @author Peter Milne
 * @author Jean Mercier
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class ProductRepositoryTest {
	
	private ProductRepository productRepository;
	
	@Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
	
	@Test
	public void testSaveProduct(){
		Product product = new Product();
        product.setDescription("Spring Data Aerospike Shirt");
        product.setPrice(18.95);
        product.setProductId("1234");
        product.setId(100);

        //save product, verify has ID value after save
        //assertNull(product.getId()); //null before save
        productRepository.save(product);
        assertNotNull(product.getId()); //not null after save
        
      //fetch from DB
        Product fetchedProduct = productRepository.findOne(product.getId());

        //should not be null
        assertNotNull(fetchedProduct);
        
        //should equal
        assertEquals(product.getId(), fetchedProduct.getId());
        assertEquals(product.getDescription(), fetchedProduct.getDescription());

        //update description and save
        fetchedProduct.setDescription("New Description");
        productRepository.save(fetchedProduct);

        //get from DB, should be updated
        Product fetchedUpdatedProduct = productRepository.findOne(fetchedProduct.getId());
        assertEquals(fetchedProduct.getDescription(), fetchedUpdatedProduct.getDescription());

        //verify count of products in DB
        long productCount = productRepository.count();
        assertEquals(productCount, 1);

        //get all products, list should only have one
        Iterable<Product> products = productRepository.findAll();

        int count = 0;

        for(Product p : products){
            count++;
        }

        assertEquals(count, 1);

	}

}