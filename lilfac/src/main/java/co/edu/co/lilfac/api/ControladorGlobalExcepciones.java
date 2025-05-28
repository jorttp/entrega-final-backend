package co.edu.co.lilfac.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;

@ControllerAdvice
public class ControladorGlobalExcepciones {
	
	
	@ExceptionHandler(LilfacException.class)
	public ResponseEntity<String> controlarLilfacException(LilfacException excepcion){
		excepcion.printStackTrace();
		return new ResponseEntity<>(excepcion.getMensajeUsuario(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> controlarException(Exception excepcion){
		excepcion.printStackTrace();
		return new ResponseEntity<>("Se ha presentado un problema INESPERADO tratando de llevar a cabo la operacion deseada", HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
