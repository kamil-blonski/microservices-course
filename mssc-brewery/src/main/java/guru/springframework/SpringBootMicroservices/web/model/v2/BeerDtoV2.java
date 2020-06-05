package guru.springframework.SpringBootMicroservices.web.model.v2;

import guru.springframework.SpringBootMicroservices.web.model.v2.BeerStyleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data /* create getters and setters, equals and hash code methods */
@NoArgsConstructor
@AllArgsConstructor
@Builder /* lombook going to implement builder pattern */
/* we need to enable Settings -> Build, Execution, ... -> COmpiler -> Enable annotation processing */
public class BeerDtoV2 {
	private UUID id;
	private String beerName;
	private BeerStyleEnum beerStyle;
	private Long upc;
}
