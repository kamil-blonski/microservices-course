package guru.springframework.SpringBootMicroservices.services.v2;

import guru.springframework.SpringBootMicroservices.web.model.BeerDtoV2;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface BeerServiceV2 {
	BeerDtoV2 getBeerById(UUID beerId);

	BeerDtoV2 saveNewBeer(BeerDtoV2 beerDTO);

	void updateBeer(UUID beerId, BeerDtoV2 beerDTO);

	void deleteById(UUID beerId);
}
