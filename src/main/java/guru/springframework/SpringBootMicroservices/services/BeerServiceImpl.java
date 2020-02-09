package guru.springframework.SpringBootMicroservices.services;

import guru.springframework.SpringBootMicroservices.web.model.BeerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
	@Override
	public BeerDTO getBeerById(UUID beerId) {
		return BeerDTO.builder()
						.id(UUID.randomUUID())
						.beerName("Galaxy Cat")
						.beerStyle("Pale Ale")
						.build();
	}

	@Override
	public BeerDTO saveNewBeer(BeerDTO beerDTO) {
		return BeerDTO.builder()
						.id(UUID.randomUUID())
						.build();
	}
}
