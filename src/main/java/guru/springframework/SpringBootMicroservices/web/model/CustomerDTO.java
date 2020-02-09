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
public class CustomerDTO {
	private UUID id;
	private String name;
}
