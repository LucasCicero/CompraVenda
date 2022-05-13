package com.CompraVenda.cv.repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.CompraVenda.cv.model.Categorias;
import com.CompraVenda.cv.model.Produtos;

public interface CategoriasRepository extends CrudRepository<Categorias, Long>{
	Categorias findById(int id);
	List<Produtos> findByProdutos(Produtos produtos);
}

