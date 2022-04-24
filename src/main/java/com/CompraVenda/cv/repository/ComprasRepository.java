package com.CompraVenda.cv.repository;
/*
import java.util.List;
import java.util.Date;
import org.springframework.data.jpa.repository.Query;
*/
import org.springframework.data.repository.CrudRepository;
import com.CompraVenda.cv.model.Compras;

public interface ComprasRepository extends CrudRepository<Compras, Long>{
	
	Compras findById(int id);
	/*
	List<Compras> findByQuantidadeCompra(int quantidadeCompra);
	List<Compras> findByDataCompra (Date dataCompra);
	
	//Query para buscar por quantidade comprada
	@Query(value = "SELECT u FROM Compras u WHERE u.quantidade_compra LIKE %?1%")
	List<Compras> findByCompraQuantidade(int compraQuantidade);
	
	//Query para buscar pela data da compra
	@Query(value = "SELECT u FROM Compras u WHERE u.data_compra LIKE %?1%")
	List<Compras> findByCompraData(Date dataCompra);
	*/
}
