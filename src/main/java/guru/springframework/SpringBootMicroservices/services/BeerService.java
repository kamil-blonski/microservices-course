package guru.springframework.SpringBootMicroservices.services;

import guru.springframework.SpringBootMicroservices.web.model.BeerDTO;

import java.util.UUID;

public interface BeerService {
	BeerDTO getBeerById(UUID beerId);

	BeerDTO saveNewBeer(BeerDTO beerDTO);
}
