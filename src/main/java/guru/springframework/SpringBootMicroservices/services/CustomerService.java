package guru.springframework.SpringBootMicroservices.services;

import guru.springframework.SpringBootMicroservices.web.model.CustomerDTO;

import java.util.UUID;

public interface CustomerService {
	CustomerDTO getCustomerById(UUID userID);
}
