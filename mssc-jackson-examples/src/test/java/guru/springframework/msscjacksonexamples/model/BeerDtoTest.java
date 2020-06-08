package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.io.IOException;

@JsonTest
class BeerDtoTest extends BaseTest{

	@Autowired
	ObjectMapper objectMapper;

	@Test
	void testSerializeDto() throws JsonProcessingException {
		BeerDto beerDto = getDto();
		String jsonString = objectMapper.writeValueAsString(beerDto);
		System.out.println(jsonString);
	}
	@Test
	void testDeserialize() throws IOException {
		String json = "{\"id\":\"57c71ed7-9963-4efa-9dba-b9f3aa365c88\",\"beerName\":\"Beer name\",\"beerStyle\":\"Ale\",\"upc\":123123123123,\"price\":12.99,\"createdDate\":\"2020-06-08T13:00:27.6766592+02:00\",\"lastUpdatedDate\":\"2020-06-08T13:00:27.6776567+02:00\"}\n";
		BeerDto beerDto = objectMapper.readValue(json, BeerDto.class);
		System.out.println(beerDto);
	}
}