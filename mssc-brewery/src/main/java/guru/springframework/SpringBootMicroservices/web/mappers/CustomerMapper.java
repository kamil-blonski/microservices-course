package guru.springframework.SpringBootMicroservices.web.mappers;

import guru.springframework.SpringBootMicroservices.domain.Customer;
import guru.springframework.SpringBootMicroservices.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
	Customer customerDtoToCustsomer(CustomerDto customerDto);

	CustomerDto customerToCustomerDto(Customer customer);
}
