package guru.springframework.SpringBootMicroservices.web.controller;

import guru.springframework.SpringBootMicroservices.services.CustomerService;
import guru.springframework.SpringBootMicroservices.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {
	private final CustomerService customerService;

	public CustomerController(CustomerService customerService){
		this.customerService = customerService;
	}

	@GetMapping("/{customerId}")
	public ResponseEntity<CustomerDto> getCustomer(@PathVariable UUID customerId){
		return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity handlePost(@RequestBody CustomerDto customerDTO){
		CustomerDto saveDTO = customerService.handlePost(customerDTO);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/api/vi/customer" + saveDTO.getId().toString());

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@PutMapping({"/{customerId}"})
	public ResponseEntity handleUpdate(@PathVariable UUID customerId, @RequestBody CustomerDto customerDTO){
		customerService.updateCustomer(customerId, customerDTO);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping({"/customerId"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable UUID customerId){
		customerService.deleteById(customerId);
	}

}
