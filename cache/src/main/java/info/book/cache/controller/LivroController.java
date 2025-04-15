package info.book.cache.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.book.cache.model.LivroModel;
import info.book.cache.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {
 
    @Autowired
    private LivroService service;
 
    @GetMapping("/{id}")
    public LivroModel buscarLivro(@PathVariable Long id) {
        return service.getLivroInfo(id);
    }
 
    @PutMapping
    public LivroModel atualizarLivro(@RequestBody LivroModel livro) {
        return service.updateLivroInfo(livro);
    }
}
