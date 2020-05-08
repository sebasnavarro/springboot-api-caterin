package com.azulitadev.springboot.backend.apicater.controller;

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
import org.springframework.web.bind.annotation.RestController;
import com.azulitadev.springboot.backend.apicater.models.entity.Articulo;
import com.azulitadev.springboot.backend.apicater.models.service.IArticuloService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api/articles")
@Api(value = "Article Resource")
public class ArticuloRestController {
	
	@Autowired
	private IArticuloService articuloService;
	
	
	@ApiOperation(value = "Return essential items")
    @ApiResponses(value = { @ApiResponse(code =100, message="100 is the message"),  @ApiResponse(code = 200,message="Successful return essential items"),
    })
	@GetMapping
	public List<Articulo> index() {
		return articuloService.findAll();
	}
	
	
	@ApiOperation(value = "Return essential items")
    @ApiResponses(value = { @ApiResponse(code =100, message="100 is the message"),  @ApiResponse(code = 200,message="Successful return essential items"),
    })
	@GetMapping("/{id}")
	public ResponseEntity<?> show(@PathVariable String id) {
		Articulo articulo = null;
		Map<String, Object> response = new HashMap<>();

		try {
			articulo  = articuloService.fecthByIdWithPrice(id);//articuloService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (articulo == null) {
			response.put("mensaje", "El id del articulo: ".concat(id.concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Articulo>(articulo, HttpStatus.OK);
	}
	

}
