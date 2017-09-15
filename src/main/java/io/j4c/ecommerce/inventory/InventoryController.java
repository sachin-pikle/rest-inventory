package io.j4c.ecommerce.inventory;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class InventoryController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private InventoryRepository inventoryRepository;

	@RequestMapping(value = "/inventory", method = RequestMethod.GET)
	@ResponseBody
	public String products() {
		String result = null;

		List<ProductDO> products = (List<ProductDO>) inventoryRepository.findAll();

		ObjectMapper mapper = new ObjectMapper();
		try {
			result = mapper.writeValueAsString(products);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping(value = "/inventory/{productId}", method = RequestMethod.GET)
	@ResponseBody
	public ProductDO product(@PathVariable(value = "productId") Integer id) {
		return inventoryRepository.findOne(id);
	}
}
