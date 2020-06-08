package guru.springframework.mscbeerservice.services;

import guru.springframework.mscbeerservice.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
	BeerDto getById(UUID beerId);

	BeerDto saveNewBeer(BeerDto beerDto);

	BeerDto updateById(UUID beerId, BeerDto beerDto);
}
