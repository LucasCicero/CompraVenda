package com.CompraVenda.cv.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.CompraVenda.cv.model.Categorias;
import com.CompraVenda.cv.model.Produtos;


public interface ProdutosRepository extends CrudRepository<Produtos, Long>{
	
	Produtos findById(int id);
        
        @Query(value = "SELECT u FROM Produtos u WHERE u.nome_produto LIKE %?1%")
        Produtos findByNomeProduto(String nomeProduto);
        
	List<Produtos> findByCategorias(Categorias categorias);
	
	@Query(value = "SELECT u FROM Produtos u WHERE u.quantidade_disponivel > 0")
	List<Produtos> findAllByQuantidade();

}
