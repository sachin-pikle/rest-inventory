
package io.j4c.ecommerce.inventory;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "inventory", path = "inventory2")
public interface InventoryRepository extends MongoRepository<ProductDO, Integer> {

	List<ProductDO> findById(@Param("id") Integer id);

}
