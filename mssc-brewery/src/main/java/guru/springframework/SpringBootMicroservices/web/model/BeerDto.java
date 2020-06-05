package guru.springframework.SpringBootMicroservices.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data /* create getters and setters, equals and hash code methods */
@NoArgsConstructor
@AllArgsConstructor
@Builder /* lombook going to implement builder pattern */
/* we need to enable Settings -> Build, Execution, ... -> COmpiler -> Enable annotation processing */
public class BeerDto {

	@Null
	private UUID id;

	@NotBlank
	private String beerName;

	@NotBlank
	private String beerStyle;

	@Positive
	private Long upc;

	private OffsetDateTime createdDate;
	private OffsetDateTime lastUpdateDate;
}
