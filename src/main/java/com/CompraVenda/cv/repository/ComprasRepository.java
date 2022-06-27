package com.CompraVenda.cv.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.CompraVenda.cv.model.Compras;
import com.CompraVenda.cv.model.Produtos;
import org.springframework.data.repository.query.Param;

public interface ComprasRepository extends CrudRepository<Compras, Long>{
	
   Compras findById(int id);
   List<Compras> findByProdutos(Produtos produtos);
	
   @Query(value = "SELECT u FROM Compras u WHERE u.funcionarios.id =:id")
   List<Compras> findByCompradorId(@Param("id") Integer id);

}
