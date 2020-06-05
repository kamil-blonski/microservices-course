package guru.springframework.SpringBootMicroservices.web.mappers;

import guru.springframework.SpringBootMicroservices.domain.Beer;
import guru.springframework.SpringBootMicroservices.web.model.BeerDto;
import org.mapstruct.Mapper;

/*
Mapper generates methods required to map Beer <=> BeerDto. Mave, -> Lifecycle -> Clean & Compile.
Methos are available in target/generated-sources
 */
@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

	BeerDto beerToBeerDto(Beer beer);

	Beer beerDtoToBeer(BeerDto beerDto);
}
