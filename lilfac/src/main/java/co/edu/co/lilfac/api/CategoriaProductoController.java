package co.edu.co.lilfac.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.co.lilfac.businesslogic.facade.CategoriaProductoFacade;
import co.edu.co.lilfac.businesslogic.facade.impl.CategoriaProductoFacadeImpl;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.dto.CategoriaProductoDTO;
import co.edu.co.lilfac.init.LilfacApplication;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/categoriasProductos")
public class CategoriaProductoController {

    private final LilfacApplication lilfacApplication;
	
	private CategoriaProductoFacade categoriaProductoFachada;
	
	public CategoriaProductoController(LilfacApplication lilfacApplication) throws LilfacException {
		categoriaProductoFachada = new CategoriaProductoFacadeImpl();
		this.lilfacApplication = lilfacApplication;
	}
	
	
	@GetMapping("/dummy")
	public CategoriaProductoDTO getDummy() {
		return new CategoriaProductoDTO();	
	}
	
	@GetMapping
	public ResponseEntity<List<CategoriaProductoDTO> >Consultar() throws LilfacException {
		var lista = categoriaProductoFachada.consultarCategoriasProducto(getDummy());	
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaProductoDTO> Consultar(@PathVariable("id") UUID id) throws LilfacException {
		var categoriaProducto =  categoriaProductoFachada.consultarCategoriaProductoPorId(id);
		return new ResponseEntity<>(categoriaProducto, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> crear(@RequestBody CategoriaProductoDTO categoriaProducto) throws LilfacException {
		categoriaProductoFachada.registrarNuevaCategoriaProducto(categoriaProducto);
		var mensajeExito = "La categoria de producto se ha registrado correctamente";
		return new ResponseEntity<>(mensajeExito, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> modificar(@PathVariable("id") UUID id, @RequestBody CategoriaProductoDTO categoriaProducto) throws LilfacException {
		categoriaProducto.setId(id);
		categoriaProductoFachada.modificarCategoriaProductoExistente(id, categoriaProducto);
		var mensajeExito = "La categoria de producto se ha modificado correctamente";
		return new ResponseEntity<>(mensajeExito, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminar(@PathVariable("id") UUID id) throws LilfacException {
		categoriaProductoFachada.darBajaDefinitivamenteCategoriaProductoExistente(id);
		var mensajeExito = "La categoria de producto se ha eliminado correctamente";
		return new ResponseEntity<>(mensajeExito, HttpStatus.OK);
	}

}
