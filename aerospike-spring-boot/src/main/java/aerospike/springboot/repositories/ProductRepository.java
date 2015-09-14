/**
 * 
 */
package aerospike.springboot.repositories;

import org.springframework.data.aerospike.core.AerospikeOperations;
import org.springframework.data.aerospike.repository.AerospikeRepository;

import aerospike.springboot.domain.Product;

/**
 *
 *
 * @author Peter Milne
 * @author Jean Mercier
 *
 */
public interface ProductRepository extends AerospikeRepository<Product, Integer> {
	

}
