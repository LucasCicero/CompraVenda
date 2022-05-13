package com.CompraVenda.cv.repository;
import org.springframework.data.repository.CrudRepository;
import com.CompraVenda.cv.model.Clientes;

public interface ClientesRepository extends CrudRepository<Clientes, Long>{
	Clientes findById(int id);

}
