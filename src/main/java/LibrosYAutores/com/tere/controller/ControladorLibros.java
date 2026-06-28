package LibrosYAutores.com.tere.controller;

import java.util.HashMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ControladorLibros {
  private static HashMap<String, String> listaLibros = new HashMap<String, String>();

  public ControladorLibros() {
    listaLibros.put("Odisea", "Homero");
    listaLibros.put("Don Quijote de la Mancha", "Miguel de Cervantes");
    listaLibros.put("El Código Da Vinci", "Dan Brown");
    listaLibros.put("Alicia en el país de las maravillas", "Lewis Carroll");
    listaLibros.put("El Hobbit", "J.R.R. Tolkien");
    listaLibros.put("El alquimista", "Paulo Coelho");
  }

  @GetMapping("/libros")
  public String obtenerTodosLosLibros(Model model) {
    model.addAttribute("listaLibros", listaLibros);
    return "libros.jsp";
  }

  // obtenerInformacionDeLibro(): Método que responde a la ruta /libros/{nombre} y
  // retorna la información de un libro en específico, devuelve el nombre del
  // libro y su autor
  // al JSP llamado detalleLibro.jsp..
  // En caso de que el libro no exista en la lista
  // devolver un mensaje como el siguiente: «El libro no se encuentra en nuestra
  // lista.»

  @GetMapping("/libros/{nombre}")
  public String obtenerInformacionDeLibro(@PathVariable String nombre, Model model) {
    if (listaLibros.containsKey(nombre)) {
      model.addAttribute("nombreLibro", nombre);
      model.addAttribute("autores", listaLibros.get(nombre));
    } else {
      model.addAttribute("mensaje", "«El libro no se encuentra en nuestra lista.»");
    }
    return "detalleLibro.jsp";
  }
}
