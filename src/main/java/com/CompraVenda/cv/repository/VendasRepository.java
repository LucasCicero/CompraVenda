package com.CompraVenda.cv.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.CompraVenda.cv.model.Produtos;
import com.CompraVenda.cv.model.Vendas;

public interface VendasRepository extends CrudRepository<Vendas, Long>{
	Vendas findById(int id);
	List<Vendas> findByProdutos(Produtos produtos);
	
	@Query(value = "SELECT COUNT(u) FROM Vendas u WHERE u.data_venda LIKE %?1%")
	Long findByDataVendido(String dataVendido);
	
	@Query(value = "SELECT u FROM Vendas u WHERE u.funcionarios.id =:id")
	List<Vendas> findByVendedorId(Integer id);
}
