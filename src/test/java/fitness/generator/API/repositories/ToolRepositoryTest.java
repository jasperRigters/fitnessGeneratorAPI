package fitness.generator.API.repositories;

import fitness.generator.API.models.Tool;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ToolRepositoryTest {

       @Autowired
    private ToolRepository repository;

    @Test
    void testSaveTool() {
        Tool tool = new Tool();
        tool.setName("Dumbbells");

        Tool savedTool = repository.save(tool);
        assertThat(savedTool).isNotNull();
        assertThat(savedTool.getId()).isGreaterThan(0);
    }
}