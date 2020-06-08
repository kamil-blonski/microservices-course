package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("snake")
@JsonTest
public class BeerDtoSnakeTest extends BaseTest {

	@Test
	void testSnake() throws JsonProcessingException {
		BeerDto beerDto = getDto();
		String json = objectMapper.writeValueAsString(beerDto);
		System.out.println(json);
	}

}
