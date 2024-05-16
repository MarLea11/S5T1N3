package cat.itacademy.barcelonactiva.pagliaruzza.marcos.s05.t01.n03.S05T01N03PagliaruzzaMarcos.controllers;

import cat.itacademy.barcelonactiva.pagliaruzza.marcos.s05.t01.n03.S05T01N03PagliaruzzaMarcos.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.pagliaruzza.marcos.s05.t01.n03.S05T01N03PagliaruzzaMarcos.model.services.ClientFlowerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/flower")
@Tag(name = "Client Flower Controller", description = "Endpoints for flowers management")
public class ClientFlowerController {

    @Autowired
    private ClientFlowerService clientFlowerService;

    @PostMapping("/clientFlowerAdd")
    @Operation(summary = "Add a flower", description = "Adding a flower to the database")
    public Mono<ResponseEntity<FlowerDTO>> addFlower(@RequestBody FlowerDTO flowerDTO) {
        return clientFlowerService.addFlower(flowerDTO);
    }

    @PutMapping("/clientFlowerUpdate/{id}")
    @Operation(summary = "Update a flower", description = "Updating a flower in the database")
    public Mono<ResponseEntity<FlowerDTO>> updateFlower(@RequestBody FlowerDTO flowerDTO, @PathVariable int id) {
        return clientFlowerService.updateFlower(flowerDTO, id);
    }

    @DeleteMapping("/clientFlowerDelete/{id}")
    @Operation(summary = "Delete a flower", description = "Deleting a flower in the database")
    public Mono<ResponseEntity<Void>> deleteFlower(@PathVariable int id) {
        return clientFlowerService.deleteFlower(id);
    }

    @GetMapping("/clientFlowerGetOne/{id}")
    @Operation(summary = "Selecting a flower", description = "Selecting a flower in the database")
    public Mono<ResponseEntity<FlowerDTO>> getFlower(@PathVariable int id) {
        return clientFlowerService.getFlower(id);
    }

    @GetMapping("/clientFlowerGetAll")
    @Operation(summary = "Selecting all flowers", description = "Selecting all flowers in the database")
    public Mono<ResponseEntity<List<FlowerDTO>>> getFlowers() {
        return clientFlowerService.getAllFlowers();
    }
}
