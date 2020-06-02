package guru.springframework.SpringBootMicroservices.web.model;

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
public class BeerDto {
	private UUID id;
	private String beerName;
	private String beerStyle;
	private Long upc;
}
