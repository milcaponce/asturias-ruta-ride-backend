package dev.milca.ruta_ride.route;

import dev.milca.ruta_ride.config.TestConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

@DataJpaTest
@ActiveProfiles("test")
@TestPropertySource(properties = {"spring.sql.init.mode=never"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(TestConfig.class)
class RouteRepositoryTest {
    
    @Autowired
    private RouteRepository routeRepository;

    @Test
    @DisplayName("Should save a route and retrieve it with findAll(all key fields)")
    void testSaveAndFindAll() {
        RouteEntity route = new RouteEntity(
                "Lagos de Covadonga",
                "Cangas de Onís",
                8,
                "Fácil",
                "Ruta panorámica con vistas a los lagos.",
                "covadonga.jpg",
                43.2551,
                -4.9995
        );

        routeRepository.save(route);
        List<RouteEntity> routes = routeRepository.findAll();

        assertThat(routes).isNotEmpty();
        RouteEntity savedRoute = routes.get(0);

        assertThat(savedRoute.getName()).isEqualTo("Lagos de Covadonga");
        assertThat(savedRoute.getArea()).isEqualTo("Cangas de Onís");
        assertThat(savedRoute.getKilometres()).isEqualTo(8);
        assertThat(savedRoute.getDifficulty()).isEqualTo("Fácil");
        assertThat(savedRoute.getImage()).isEqualTo("covadonga.jpg");
        assertThat(savedRoute.getLatitude()).isCloseTo(43.2553, within(1e-2));
assertThat(savedRoute.getLongitude()).isCloseTo(-4.9961, within(1e-2));
    }

}
