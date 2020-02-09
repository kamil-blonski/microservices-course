package guru.springframework.SpringBootMicroservices.services;

import guru.springframework.SpringBootMicroservices.web.model.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Override
	public CustomerDTO getCustomerById(UUID userID) {
		return CustomerDTO.builder()
						.id(UUID.randomUUID())
						.name("Kamil")
						.build();
	}
}
