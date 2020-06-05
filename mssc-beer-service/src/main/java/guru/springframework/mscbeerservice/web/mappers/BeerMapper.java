package guru.springframework.mscbeerservice.web.mappers;

import guru.springframework.mscbeerservice.domain.Beer;
import guru.springframework.mscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
	BeerDto beerToBeerDto(Beer beer);

	Beer beerDtoToBeer(BeerDto beerDto);
}
