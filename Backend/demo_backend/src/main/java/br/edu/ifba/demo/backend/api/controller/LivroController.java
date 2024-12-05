package br.edu.ifba.demo.backend.api.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifba.demo.backend.api.repository.LivroRepository;
import br.edu.ifba.demo.backend.api.dto.LivroDTO;
import br.edu.ifba.demo.backend.api.model.LivroModel;


@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/livro")
public class LivroController {

    private LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository) {
		super();
		this.livroRepository = livroRepository;
	}

    @GetMapping
	public String teste() {
		return "Testando Rota Livro";
	}

    @GetMapping("/listall")
	public List<LivroModel> listall() {
		var livros = livroRepository.findAll();
		return livros;
	}
    // Método que retornar o titulo associado ao ID passado como parametro
	@GetMapping("/findById/{id}")
    public LivroModel findById(@PathVariable("id") Long id) {
		Optional<LivroModel> livro = livroRepository.findById(id);
		if ( livro.isPresent() )
			return livro.get();
        return null;
    }
     // Método que retornar o livro associado ao Titulo passado como parametro
    @GetMapping("/titulo/{titulo}")
     public ResponseEntity<List<LivroDTO>> buscarPorTitulo(@PathVariable String titulo) {
        var livros = livroRepository.findByTituloContainingIgnoreCase(titulo);
        if (livros.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(LivroDTO.converter(livros));
    }
	// Método que retornar o livro associado ao ISBN passado como parametro
    @GetMapping("/isbn/{isbn}")
     public ResponseEntity<LivroDTO> buscarPorIsbn(@PathVariable String isbn) {
        var livros = livroRepository.findByIsbn(isbn);
        if (livros==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(LivroDTO.converter(livros));
    }

	  // Método para adicionar um novo livro
	@PostMapping
	public ResponseEntity<LivroModel> addLivro(@RequestBody LivroModel livro) {
		System.out.println("addLivro: " + livro);
		LivroModel savedLivro = livroRepository.save(livro);
		return new ResponseEntity<>(savedLivro, HttpStatus.CREATED);
	}

	// Método para deletar livro
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteLivro(@PathVariable Long id) {
		if(!livroRepository.existsById(id)){
			return ResponseEntity.notFound().build();
		}
		livroRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
