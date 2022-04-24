package com.CompraVenda.cv.repository;
/*
import java.util.List;
import org.springframework.data.jpa.repository.Query;
*/
import org.springframework.data.repository.CrudRepository;
import com.CompraVenda.cv.model.Categorias;

public interface CategoriasRepository extends CrudRepository<Categorias, Long>{
	Categorias findById(int id);

	/*
	List<Categorias> findByNomeCategoria(String nomeCategoria);
	
	//@Query de busca de categorias
	@Query(value = "SELECT u FROM Categorias u WHERE u.nome_categoria LIKE %?1%")
	List<Categorias> findByNomesCategorias(String nomeCategoria);
*/
}

