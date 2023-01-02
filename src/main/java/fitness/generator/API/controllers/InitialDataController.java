package fitness.generator.API.controllers;

import fitness.generator.API.dto.InitialDataDto;
import fitness.generator.API.dto.InitialDataWithUserDto;
import fitness.generator.API.services.InitialDataService;
import fitness.generator.API.services.MuscleService;
import fitness.generator.API.services.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





@RestController
@RequestMapping("/api")
public class InitialDataController {

    @Autowired
    private InitialDataService initialDataService;

    @Autowired
    private ToolService toolService;

    @Autowired
    private MuscleService muscleService;

    @GetMapping("/initialData")
    public  ResponseEntity<InitialDataDto> getInitialData() {
        InitialDataDto initialData = initialDataService.getInitialData();

        return ResponseEntity.ok(initialData);
    }

    @GetMapping("/initialData/{id}")
    public ResponseEntity<InitialDataWithUserDto> getInitialDataWithUser() {
        InitialDataWithUserDto initialData = new InitialDataWithUserDto();

        return ResponseEntity.ok(initialData);
    }
}
