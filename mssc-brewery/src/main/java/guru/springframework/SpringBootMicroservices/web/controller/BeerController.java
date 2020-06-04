package guru.springframework.SpringBootMicroservices.web.controller;

import guru.springframework.SpringBootMicroservices.services.BeerService;
import guru.springframework.SpringBootMicroservices.web.model.BeerDto;
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

import javax.validation.Valid;
import java.util.UUID;

@Deprecated
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
	private final BeerService beerService;

	public BeerController(BeerService beerService){
		this.beerService = beerService;
	}

	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDto> getBeer(@PathVariable UUID beerId){
		return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity handlePost9(@Valid @RequestBody BeerDto beerDTO){
		BeerDto saveDTO = beerService.saveNewBeer(beerDTO);
		HttpHeaders headers = new HttpHeaders();
		//TODO: add host name to url
		headers.add("Location", "/api/v1/beer" + saveDTO.getId().toString());

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@PutMapping({"/{beerId}"})
	public ResponseEntity handleUpdate(@PathVariable UUID beerId, @Valid @RequestBody BeerDto beerDTO){
		beerService.updateBeer(beerId, beerDTO);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping({"/{beerId}"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable UUID beerId){
		beerService.deleteById(beerId);
	}
}
