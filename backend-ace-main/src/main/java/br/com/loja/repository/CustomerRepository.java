package br.com.loja.repository;

import br.com.loja.model.Customer;
import java.util.Optional;
import org.springframework.data.jpa.repository.*;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
  boolean existsByPhone(String phone);

  Optional<Customer> findByPhone(String phone);
}
