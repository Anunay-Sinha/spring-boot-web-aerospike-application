/**
 * 
 */
package aerospike.springboot.services;

import aerospike.springboot.domain.Product;

/**
 *
 *
 * @author Peter Milne
 * @author Jean Mercier
 *
 */
public interface ProductService {
    Iterable<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);
}
