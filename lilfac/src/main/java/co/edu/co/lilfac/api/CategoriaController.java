package co.edu.co.lilfac.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.co.lilfac.businesslogic.facade.CategoriaFacade;
import co.edu.co.lilfac.businesslogic.facade.impl.CategoriaFacadeImpl;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.dto.CategoriaDTO;
import co.edu.co.lilfac.dto.CategoriaProductoDTO;
import co.edu.co.lilfac.init.LilfacApplication;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaController {

    private final LilfacApplication lilfacApplication;
	
	private CategoriaFacade categoriaFachada;
	
	public CategoriaController(LilfacApplication lilfacApplication) throws LilfacException {
		categoriaFachada = new CategoriaFacadeImpl();
		this.lilfacApplication = lilfacApplication;
	}
	
	
	@GetMapping("/dummy")
	public CategoriaDTO getDummy() {
		return new CategoriaDTO();	
	}
	
	@GetMapping("/categorias")
	public ResponseEntity<List<CategoriaDTO> >Consultar() throws LilfacException {
		var lista = categoriaFachada.consultarCategorias();	
		return ResponseEntity.ok(lista);
	}
}