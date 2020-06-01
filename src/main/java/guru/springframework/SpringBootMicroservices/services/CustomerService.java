package guru.springframework.SpringBootMicroservices.services;

import guru.springframework.SpringBootMicroservices.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
	CustomerDto getCustomerById(UUID userID);

	CustomerDto handlePost(CustomerDto customerDTO);

	void updateCustomer(UUID customerId, CustomerDto customerDTO);

	void deleteById(UUID customerId);
}
