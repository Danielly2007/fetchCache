package info.book.cache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.book.cache.model.LivroModel;
import info.book.cache.repositories.LivroRepository;

@Service
public class LivroService {
	
    @Autowired
    private LivroRepository livroRepository;
 
    private LivroModel[] cache = new LivroModel[100];
 
    public LivroModel getLivroInfo(Long id) {
        for (LivroModel livro : cache) {
            if (livro != null && livro.getId().equals(id)) {
                System.out.println("Livro encontrado no cache.");
                return livro;
            }
        }
 
        System.out.println("Livro não está no cache. Buscando no banco...");
        LivroModel livro = livroRepository.findById(id).orElse(null);
 
        if (livro != null) {
            for (int i = 0; i < cache.length; i++) {
                if (cache[i] == null) {
                    cache[i] = livro;
                    break;
                }
            }
        }
 
        return livro;
    }
 
    public LivroModel updateLivroInfo(LivroModel livro) {
        System.out.println("Atualizando banco...");
LivroModel atualizado = livroRepository.save(livro);
 
        for (int i = 0; i < cache.length; i++) {
            if (cache[i] != null && cache[i].getId().equals(livro.getId())) {
                cache[i] = atualizado;
                return atualizado;
            }
        }
 
        for (int i = 0; i < cache.length; i++) {
            if (cache[i] == null) {
                cache[i] = atualizado;
                break;
            }
        }
 
        return atualizado;
    }
}

