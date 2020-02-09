package guru.springframework.SpringBootMicroservices.web.controller;

import guru.springframework.SpringBootMicroservices.services.BeerService;
import guru.springframework.SpringBootMicroservices.web.model.BeerDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
	private final BeerService beerService;

	public BeerController(BeerService beerService){
		this.beerService = beerService;
	}

	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDTO> getBeer(@PathVariable UUID beerId){
		return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity handlePost(BeerDTO beerDTO){
		BeerDTO saveDTO = beerService.saveNewBeer(beerDTO);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/api/v1/beer" + saveDTO.getId().toString());

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}
}
