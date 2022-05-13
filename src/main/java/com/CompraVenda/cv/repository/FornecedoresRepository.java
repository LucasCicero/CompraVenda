package com.CompraVenda.cv.repository;
import org.springframework.data.repository.CrudRepository;
import com.CompraVenda.cv.model.Fornecedores;

public interface FornecedoresRepository extends CrudRepository<Fornecedores, Long>{
	Fornecedores findById(int id);
}
