package cat.itacademy.barcelonactiva.pagliaruzza.marcos.s05.t01.n03.S05T01N03PagliaruzzaMarcos.model.services;



import cat.itacademy.barcelonactiva.pagliaruzza.marcos.s05.t01.n03.S05T01N03PagliaruzzaMarcos.model.dto.FlowerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientFlowerService {
    private final WebClient webClient;
    @Autowired
    public ClientFlowerService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:9001/flower").build();
    }

    public Mono<ResponseEntity<FlowerDTO>> addFlower(FlowerDTO flowerDTO) {
        return webClient.post()
                .uri("/add")
                .bodyValue(flowerDTO)
                .retrieve()
                .toEntity(FlowerDTO.class);
    }

    public Mono<ResponseEntity<FlowerDTO>> updateFlower(FlowerDTO flowerDTO, int id) {
        return webClient.put()
                .uri("/update/{id}", id)
                .bodyValue(flowerDTO)
                .retrieve()
                .toEntity(FlowerDTO.class);
    }

    public Mono<ResponseEntity<Void>> deleteFlower(int id) {
        return webClient.delete()
                .uri("/delete/{id}", id)
                .retrieve()
                .toBodilessEntity();
    }

    public Mono<ResponseEntity<FlowerDTO>> getFlower(int id) {
        return webClient.get()
                .uri("/getOne/{id}", id)
                .retrieve()
                .toEntity(FlowerDTO.class);
    }

    public Mono<ResponseEntity<List<FlowerDTO>>> getAllFlowers() {
        return webClient.get()
                .uri("/getAll")
                .retrieve()
                .toEntityList(FlowerDTO.class);
    }
}
