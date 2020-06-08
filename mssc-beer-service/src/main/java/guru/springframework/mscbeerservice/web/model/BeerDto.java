package guru.springframework.mscbeerservice.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data //give me getters, setters, hashCode and equals
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {

	@Null //Adding Null addnotation causes walidation error when somebody tries to change readonly values from outside world
	private UUID id;

	@Null
	private Integer version;

	@Null
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
	private OffsetDateTime createDate;

	@Null
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
	private OffsetDateTime lastModifiedDate;

	@NotBlank(message = "Beer name is mandatory.")
	private String beerName;

	@NotNull
	private BeerStyleEnum beerStyle;

	@Positive
	@NotNull
	private Long upc;

	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@NotNull
	@Positive
	private BigDecimal price;


	private Integer quantityOnHand;
}
