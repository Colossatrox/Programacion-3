/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuralibros;

/**
 *
 * @author Bryan Orlando
 * Aguirre Sagastume 
 * 0901-17-646
 */
// se crea la clase libro
public class Libro {
	private String titulo;
	private String autor;
	private String isbn;
	public Libro(String titulo, String autor, String isbn) {
		this.titulo=titulo;
		this.autor=autor;
		this.isbn=isbn;
	}
        //metodo para obtener el titulo del libro
	public String getTitulo() {
		return titulo;
	}
	//metodo para obtener el autor
	public String getAutor() {
		return autor;	
	}
	//metodo para obtener el Isbn
	public String getIsbn() {
		return isbn;
	}
	
    }
