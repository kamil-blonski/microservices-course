package guru.springframework.SpringBootMicroservices.services.v2;

import guru.springframework.SpringBootMicroservices.web.model.BeerDtoV2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceV2Impl implements BeerServiceV2 {
	@Override
	public BeerDtoV2 getBeerById(UUID beerId) {
		return null;
	}

	@Override
	public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDTO) {
		return null;
	}

	@Override
	public void updateBeer(UUID beerId, BeerDtoV2 beerDTO) {

	}

	@Override
	public void deleteById(UUID beerId) {

	}
}