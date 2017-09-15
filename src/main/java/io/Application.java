
package io;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.j4c.ecommerce.inventory.InventoryRepository;
import io.j4c.ecommerce.inventory.ProductDO;

@SpringBootApplication
public class Application {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	

    @Bean
    CommandLineRunner init(InventoryRepository inventoryRepository) {

        return args -> {

        	List<ProductDO> products = new ArrayList<ProductDO>();
            		
            products.add(new ProductDO(5,5));
            products.add(new ProductDO(10,4));
            products.add(new ProductDO(13,3));
            products.add(new ProductDO(11,8));
            products.add(new ProductDO(1,6));
            products.add(new ProductDO(8,5));
            products.add(new ProductDO(2,8));
            products.add(new ProductDO(4,7));
            products.add(new ProductDO(15,1));
            products.add(new ProductDO(7,10));
            products.add(new ProductDO(6,2));
            products.add(new ProductDO(9,5));
            products.add(new ProductDO(14,3));
            products.add(new ProductDO(12,1));
            products.add(new ProductDO(3,10));
            
            int count = inventoryRepository.findAll().size();
            if ( count == 0) {
            	logger.info("Insert " + products.size() + " sample inventory data.");
            	inventoryRepository.insert(products);
            } else {
            	logger.info(count + " inventory data already available.");
            }
        };

    }
}
