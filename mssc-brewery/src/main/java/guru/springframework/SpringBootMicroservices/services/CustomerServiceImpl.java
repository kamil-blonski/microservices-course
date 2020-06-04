package guru.springframework.SpringBootMicroservices.services;

import guru.springframework.SpringBootMicroservices.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
	@Override
	public CustomerDto getCustomerById(UUID userID) {
		return CustomerDto.builder()
						.id(UUID.randomUUID())
						.name("Kamil")
						.build();
	}

	@Override
	public CustomerDto handlePost(@RequestBody CustomerDto customerDTO) {
		return CustomerDto.builder()
						.id(UUID.randomUUID())
						.build();
	}

	@Override
	public void updateCustomer(UUID customerId, @RequestBody CustomerDto customerDTO) {
		//todo: impl - would add a real impl to update cucstomer
		log.debug("updating customer ...");
	}

	@Override
	public void deleteById(UUID customerId) {
		log.debug("Deleting a customer ...");
	}
}
