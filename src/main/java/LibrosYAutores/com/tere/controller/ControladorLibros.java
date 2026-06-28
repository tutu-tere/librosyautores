package LibrosYAutores.com.tere.controller;

import java.util.HashMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
  // formularioLibro(): Método que responde a la ruta /libros/formulario
  // y retorna un JSP llamado formularioLibros.jsp
  // para cargar un formulario para poder dar de alta un nuevo libro
  // y su respectivo autor.

  @GetMapping("/libros/formulario")
  public String formularioLibro() {
    return "formularioLibros.jsp";
  }

  @PostMapping("/libros/procesar/libro")
  public String procesaLibro(@RequestParam(value = "nuevoLibro") String nuevoLibro,
      @RequestParam(value = "autorNuevo") String autorNuevo) {
    listaLibros.put(nuevoLibro, autorNuevo);
    return "redirect:/libros";
  }
}
