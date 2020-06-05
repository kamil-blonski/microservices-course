package guru.springframework.SpringBootMicroservices.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data /* create getters and setters, equals and hash code methods */
@NoArgsConstructor
@AllArgsConstructor
@Builder /* lombook going to implement builder pattern */
public class CustomerDto {

	@Null
	private UUID id;

	@NotBlank
	@Size(min = 3, max = 100)
	private String name;
}
