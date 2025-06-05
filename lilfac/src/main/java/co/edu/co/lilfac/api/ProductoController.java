package co.edu.co.lilfac.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.co.lilfac.businesslogic.facade.CategoriaFacade;
import co.edu.co.lilfac.businesslogic.facade.ProductoFacade;
import co.edu.co.lilfac.businesslogic.facade.impl.CategoriaFacadeImpl;
import co.edu.co.lilfac.businesslogic.facade.impl.ProductoFacadeImpl;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.dto.CategoriaDTO;
import co.edu.co.lilfac.dto.CategoriaProductoDTO;
import co.edu.co.lilfac.dto.ProductoDTO;
import co.edu.co.lilfac.init.LilfacApplication;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

    private final LilfacApplication lilfacApplication;
	
	private ProductoFacade productoFachada;
	
	public ProductoController(LilfacApplication lilfacApplication) throws LilfacException {
		productoFachada = new ProductoFacadeImpl();
		this.lilfacApplication = lilfacApplication;
	}
	
	
	@GetMapping("/dummy")
	public ProductoDTO getDummy() {
		return new ProductoDTO();	
	}
	
	@GetMapping("/productos")
	public ResponseEntity<List<ProductoDTO> >Consultar() throws LilfacException {
		var lista = productoFachada.consultarProductos();	
		return ResponseEntity.ok(lista);
	}
}
