package dev.milca.ruta_ride.route;

import dev.milca.ruta_ride.config.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@TestPropertySource(properties = {"spring.sql.init.mode=never"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(TestConfig.class)
class RouteRepositoryTest {
    
    @Autowired
    private RouteRepository routeRepository;

    @Test
    void testSaveAndFindAllRoutes() {
        RouteEntity route = new RouteEntity();
        route.setName("Lagos de Covadonga");
        route.setArea("Cangas de Onís");
        route.setKilometres(8);
        route.setDifficulty("Fácil");
        route.setDescription("Ruta panorámica con vistas a los lagos.");

        routeRepository.save(route);

        List<RouteEntity> routes = routeRepository.findAll();

        assertThat(routes).isNotEmpty();
        assertThat(routes.get(0).getName()).isEqualTo("Lagos de Covadonga");
    }
}
