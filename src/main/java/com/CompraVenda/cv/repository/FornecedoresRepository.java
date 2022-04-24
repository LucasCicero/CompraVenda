package com.CompraVenda.cv.repository;
/*
import java.util.List;
import org.springframework.data.jpa.repository.Query;
*/
import org.springframework.data.repository.CrudRepository;
import com.CompraVenda.cv.model.Fornecedores;

public interface FornecedoresRepository extends CrudRepository<Fornecedores, Long>{
	Fornecedores findById(int id);
	/*
	List<Fornecedores> findByCnpj(String cnpj);
	List<Fornecedores> findByEndereco(String endereco);
	List<Fornecedores> findByTelefone(String telefone);
	List<Fornecedores> findByEmail(String email);
	
	//Query para buscar por cnpj
	@Query(value = "SELECT u FROM Fornecedores u WHERE u.cnpj LIKE %?1%")
	List<Fornecedores> findByCnpjFornecedor(String cnpjFornecedor);
	
	//Query para buscar por endereço
	@Query(value = "SELECT u FROM Fornecedores u WHERE u.endereco LIKE %?1%")
	List<Fornecedores> findByEnderecoFornecedor(String enderecoFornecedor);
		
	//Query para buscar por telefone
	@Query(value = "SELECT u FROM Fornecedores u WHERE u.telefone LIKE %?1%")
	List<Fornecedores> findByTelefoneFornecedor(String TelefoneFornecedor);
		
	//Query para buscar por email
	@Query(value = "SELECT u FROM Fornecedores u WHERE u.email LIKE %?1%")
	List<Fornecedores> findByEmailFornecedor(String EmailFornecedor);
	*/
}
