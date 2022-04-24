package com.CompraVenda.cv.repository;
/*
import java.util.List;
import org.springframework.data.jpa.repository.Query;
*/
import org.springframework.data.repository.CrudRepository;
import com.CompraVenda.cv.model.Clientes;

public interface ClientesRepository extends CrudRepository<Clientes, Long>{
	Clientes findById(int id);
	/*
	List<Clientes> findByNomeCliente(String nomeCliente);
	List<Clientes> findByCpfCliente(String nomeCpfCliente);
	List<Clientes> findByEnderecoCliente(String enderecoCliente);
	List<Clientes> findByEmailCliente(String emailCliente);
	
	//Query de busca nome do cliente
	@Query(value = "SELECT u FROM Clientes u WHERE u.nome LIKE %?1%")
	List<Clientes> findByNomesClientes(String nomesClientes);
	
	//Query de busca cpf do cliente
	@Query(value = "SELECT u FROM Clientes u WHERE u.cpf LIKE %?1%")
	List<Clientes> findByCpfClientes(String cpfClientes);
	
	//Query de busca endereço do cliente
	@Query(value = "SELECT u FROM Clientes u WHERE u.endereco LIKE %?1%")
	List<Clientes> findByEnderecoClientes(String enderecoClientes);
	
	//Query de busca email do cliente
	@Query(value = "SELECT u FROM Clientes u WHERE u.email LIKE %?1%")
	List<Clientes> findByEmailClientes(String emailClientes);
	*/
}
