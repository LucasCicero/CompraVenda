package com.CompraVenda.cv.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
/*
import java.util.List;
import org.springframework.data.jpa.repository.Query;
*/
import org.springframework.data.repository.CrudRepository;

import com.CompraVenda.cv.model.Categorias;
import com.CompraVenda.cv.model.Produtos;
import com.CompraVenda.cv.model.Vendas;

public interface ProdutosRepository extends CrudRepository<Produtos, Long>{
	
	Produtos findById(int id);
	List<Produtos> findByCategorias(Categorias categorias);
	
	@Query(value = "SELECT u FROM Produtos u WHERE u.quantidade_disponivel > 0")
	List<Produtos> findAllByQuantidade();
	/*
	List<Produtos> findByNomeProduto(String nomeProduto);
	List<Produtos> findByPrecoCompra(double precoCompra);
	List<Produtos> findByPrecoVenda(double precoVenda);
	List<Produtos> findByQuantidadeDisponivel(int quantidadeDisponivel);
	List<Produtos> findByLiberadoVenda(String liberadoVenda);
	
	//Query para buscar por nome do produto
	@Query(value = "SELECT u FROM Produtos u WHERE u.nome_produto LIKE %?1%")
	List<Produtos> findByProdutoNome(String produtoNome);
	
	//Query para buscar preço de compra
	@Query(value = "SELECT u FROM Produtos u WHERE u.preco_compra LIKE %?1%")
	List<Produtos> findByCompraPreco(double compraPreco);
		
	//Query para buscar por preço de venda
	@Query(value = "SELECT u FROM Produtos u WHERE u.preco_venda LIKE %?1%")
	List<Produtos> findByVendaPreco(double vendaPreco);
		
	//Query para buscar por quantidade disponivel
	@Query(value = "SELECT u FROM Produtos u WHERE u.quantidade_disponivel LIKE %?1%")
	List<Produtos> findByQuantidadeEstoque(int quantidadeEstoque);
		
	//Query para buscar por liberação de venda
	@Query(value = "SELECT u FROM Produtos u WHERE u.liberado_venda LIKE %?1%")
	List<Produtos> findByLiberado(String liberado);
	*/
}
