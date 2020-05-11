package com.azulitadev.springboot.backend.apicater.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.azulitadev.springboot.backend.apicater.models.entity.Products;
import com.azulitadev.springboot.backend.apicater.models.entity.ProductsDto;
import com.azulitadev.springboot.backend.apicater.models.service.IProductsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api/products")
@Api(value = "Article Resource")
public class ProductsRestController {
	
	@Autowired
	private IProductsService productsService;
	@ApiOperation(value = "Return essential items")
    @ApiResponses(value = { @ApiResponse(code =100, message="100 is the message"),  @ApiResponse(code = 200,message="Successful return essential items"),
    })
	@GetMapping
	public ResponseEntity<?> getAll() {
	List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	Map<String, Object> response = null;
	List<Products> products = productsService.findAll();
	
	for (int i=0; i<products.size(); i++) {
		response = new HashMap<String, Object>();
		response.put("category", products.get(i).getCategory());
		response.put("name", products.get(i).getName());
		response.put("price", products.get(i).getPrices().get(products.get(i).getPrices().size()-1).getPrice());
		response.put("quantity", products.get(i).getQuantity());
		response.put("image", products.get(i).getImage());
		response.put("id", products.get(i).getId());
		list.add(response);
	}
	int count = list.size();
	ProductsDto articuloDto = new ProductsDto(); 
	articuloDto.setCount(count);
	articuloDto.setProducts(list);
	return new ResponseEntity<ProductsDto>(articuloDto, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Return essential items")
    @ApiResponses(value = { @ApiResponse(code =100, message="100 is the message"),  @ApiResponse(code = 200,message="Successful return essential items"),
    })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces="application/json")
	@ResponseBody
	public ResponseEntity<?> show(@PathVariable String id) {

		Products producto = null;
		Map<String, Object> response = new HashMap<>();
        
		try {
			producto  = productsService.findById(id);//articuloService.findById(id);
			response.put("category", producto.getCategory());
			response.put("name", producto.getName().toString());
			response.put("price", producto.getPrices().get(producto.getPrices().size()-1).getPrice());
			response.put("quantity", producto.getQuantity());
			response.put("image", producto.getImage());
			response.put("id", producto.getId().toString());
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}
	
	
}
