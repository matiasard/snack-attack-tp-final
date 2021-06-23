package ar.edu.unju.fi.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.OrderDetails;
import ar.edu.unju.fi.entity.OrderDetailsId;


@Repository
public interface OrderDetailsRepository extends CrudRepository<OrderDetails, OrderDetailsId> {

	
	public List<OrderDetails> findByOrderLineNumber(int orderNumber);
	
}
