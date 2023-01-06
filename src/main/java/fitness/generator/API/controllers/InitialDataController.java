package fitness.generator.API.controllers;

import fitness.generator.API.dto.InitialDataDto;
import fitness.generator.API.services.InitialDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





@RestController
@RequestMapping("/api")
public class InitialDataController {

    private final InitialDataService initialDataService;

    public InitialDataController(InitialDataService initialDataService) {
        this.initialDataService = initialDataService;
    }


    @GetMapping("/initialData")
    public  ResponseEntity<InitialDataDto> getInitialData() {
        InitialDataDto initialData = initialDataService.getInitialData();

        return ResponseEntity.ok(initialData);
    }

    @GetMapping("/initialData/{id}")
    public ResponseEntity<InitialDataDto> getInitialDataWithUser() {
        InitialDataDto initialData = new InitialDataDto();

        return ResponseEntity.ok(initialData);
    }
}
