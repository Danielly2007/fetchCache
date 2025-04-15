package info.book.cache.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import info.book.cache.model.LivroModel;

@Repository
public interface LivroRepository extends JpaRepository<LivroModel, Long> {

}
