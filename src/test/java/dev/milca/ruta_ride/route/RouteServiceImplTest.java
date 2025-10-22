package dev.milca.ruta_ride.route;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.milca.ruta_ride.common.exceptions.ResourceNotFoundException;
import dev.milca.ruta_ride.route.dtos.RouteDTO;

import java.util.List;
import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void testGetRouteByIdReturnsDTO() {
        RouteEntity route = mockRoutes.get(0);
        when(routeRepository.findById(1L)).thenReturn(Optional.of(route));

        RouteDTO dto = routeService.getRouteById(1L);

        assertThat(dto).isNotNull();
        assertThat(dto.getIdRoute()).isEqualTo(1L);
        assertThat(dto.getName()).isEqualTo("Ruta del Cares");
    }

    @Test
    void testGetRouteByIdThrowsWhenNotFound() {
        when(routeRepository.findById(99L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> routeService.getRouteById(99L))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessageContaining("Route not found");
    }
}
