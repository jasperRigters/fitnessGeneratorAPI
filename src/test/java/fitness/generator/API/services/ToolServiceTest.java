package fitness.generator.API.services;

import fitness.generator.API.models.Tool;
import fitness.generator.API.repositories.ToolRepository;
import fitness.generator.API.services.impl.ToolServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.mockito.Mockito.*;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
public class ToolServiceTest {

    @Mock
    private ToolRepository repository;

    private ToolService service;

    @BeforeEach
    void setUp() {
        service = new ToolServiceImpl(repository);
    }
    @Test
    void testSaveTool() {
        Tool tool = new Tool();
        tool.setName("Dumbbells");

        when(repository.save(tool)).thenReturn(tool);

        Tool bla = service.saveTool(tool);
        verify(repository, times(1)).save(tool);
    }

    @Test
    void testGetAllTools() {
        service.getAllTools();
        verify(repository, times(1)).findAll();
    }

    @Test
    void testGetToolById() {
        service.findToolById(1L);
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void testFindToolByName() {
        service.findToolByName("Dumbbells");
        verify(repository, times(1)).findByName("Dumbbells");
    }
}