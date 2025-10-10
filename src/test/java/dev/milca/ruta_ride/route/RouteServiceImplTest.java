package dev.milca.ruta_ride.route;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class RouteServiceImplTest {
    @Mock
    private RouteRepository routeRepository;

    @InjectMocks
    private RouteServiceImpl routeService;

    private List<RouteEntity> mockRoutes;

    @BeforeEach
    void setUp() {
        RouteEntity route1 = new RouteEntity();
        route1.setIdRoute(1L);
        route1.setName("Ruta del Cares");
        route1.setDifficulty("Media");
        route1.setKilometres(12);

        RouteEntity route2 = new RouteEntity();
        route2.setIdRoute(2L);
        route2.setName("Lagos de Covadonga");
        route2.setDifficulty("Fácil");
        route2.setKilometres(8);

        mockRoutes = Arrays.asList(route1, route2);
    }

    @Test
    void testGetAllRoutesReturnsList() {
        // Given
        when(routeRepository.findAll()).thenReturn(mockRoutes);

        // When
        List<RouteEntity> routes = routeService.getAllRoutes();

        // Then
        assertThat(routes).isNotEmpty();
        assertThat(routes).hasSize(2);
        assertThat(routes.get(0).getName()).isEqualTo("Ruta del Cares");
    }
}
