package com.CompraVenda.cv.repository;
/*
import java.util.List;
import java.util.Date;
import org.springframework.data.jpa.repository.Query;
*/
import org.springframework.data.repository.CrudRepository;
import com.CompraVenda.cv.model.Vendas;

public interface VendasRepository extends CrudRepository<Vendas, Long>{
	Vendas findById(int id);
	/*
	List<Vendas> findByQuantidadeVenda(int quantidadeVenda);
	List<Vendas> findByDataVenda(Date dataVenda);
	List<Vendas> findByValorVenda(double valorVenda);
	List<Vendas> findByIdProduto(int idProduto);
	
	//Query para buscar por quantidade de venda
	@Query(value = "SELECT u FROM Vendas u WHERE u.quantidade_venda LIKE %?1%")
	List<Vendas> findByQuantidadeVendido(int quantidadeVendido);
	
	//Query para buscar por data da venda
	@Query(value = "SELECT u FROM Vendas u WHERE u.data_venda LIKE %?1%")
	List<Vendas> findByDataVendido(int dataVendido);
	
	//Query para buscar por valor da venda
	@Query(value = "SELECT u FROM Vendas u WHERE u.valor_venda LIKE %?1%")
	List<Vendas> findByVendaValor(double vendaValor);
	
	//Query para buscar id do produto
	@Query(value = "SELECT u FROM Vendas u WHERE u.id_produto LIKE %?1%")
	List<Vendas> findByProdutoId(int produtoId);
	*/
}
