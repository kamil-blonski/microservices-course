package guru.springframework.SpringBootMicroservices.web.controller.v2;

import guru.springframework.SpringBootMicroservices.services.v2.BeerServiceV2;
import guru.springframework.SpringBootMicroservices.web.model.BeerDtoV2;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/api/v2/beer")
@RequiredArgsConstructor
@RestController
public class BeerControllerV2 {

	private final BeerServiceV2 beerServiceV2;

	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDtoV2> getBeer(@PathVariable UUID beerId){
		return new ResponseEntity<>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity handlePost(@RequestBody BeerDtoV2 beerDTO){
		BeerDtoV2 saveDTO = beerServiceV2.saveNewBeer(beerDTO);
		HttpHeaders headers = new HttpHeaders();
		//TODO: add host name to url
		headers.add("Location", "/api/v1/beer" + saveDTO.getId().toString());

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@PutMapping({"/{beerId}"})
	public ResponseEntity handleUpdate(@PathVariable UUID beerId, @RequestBody BeerDtoV2 beerDTO){
		beerServiceV2.updateBeer(beerId, beerDTO);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping({"/{beerId}"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable UUID beerId){
		beerServiceV2.deleteById(beerId);
	}
}
