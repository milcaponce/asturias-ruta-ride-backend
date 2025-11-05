package dev.milca.ruta_ride.route;

import dev.milca.ruta_ride.common.exceptions.ResourceNotFoundException;
import dev.milca.ruta_ride.route.dtos.RouteDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
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

    private RouteEntity route1;
    private RouteEntity route2;

    @BeforeEach
    void setUp() {
        route1 = new RouteEntity();
        route1.setIdRoute(1L);
        route1.setName("Ruta del Cares");
        route1.setArea("Picos de Europa");
        route1.setDifficulty("Media");
        route1.setKilometres(12);
        route1.setDescription("Ruta icónica");
        route1.setImage("cares.jpg");

        route2 = new RouteEntity();
        route2.setIdRoute(2L);
        route2.setName("Lagos de Covadonga");
        route2.setArea("Cangas de Onís");
        route2.setDifficulty("Fácil");
        route2.setKilometres(8);
    }

    @Test
    @DisplayName("getAllRoutes() should return a list of routes")
    void shouldReturnListOfRoutes_WhenGetAllRoutes() {
        when(routeRepository.findAll()).thenReturn(List.of(route1, route2));

        List<RouteEntity> routes = routeService.getAllRoutes();

        assertThat(routes).hasSize(2);
        assertThat(routes.get(0).getName()).isEqualTo("Ruta del Cares");
        assertThat(routes.get(1).getName()).isEqualTo("Lagos de Covadonga");
    }

    @Test
    @DisplayName("getRouteById() should return a RouteDTO when route exists")
    void shouldReturnRouteDTO_WhenRouteExists() {
        when(routeRepository.findById(1L)).thenReturn(Optional.of(route1));

        RouteDTO dto = routeService.getRouteById(1L);

        assertThat(dto).isNotNull();
        assertThat(dto.getIdRoute()).isEqualTo(1L);
        assertThat(dto.getName()).isEqualTo("Ruta del Cares");
        assertThat(dto.getArea()).isEqualTo("Picos de Europa");
        assertThat(dto.getDifficulty()).isEqualTo("Media");
        assertThat(dto.getKilometres()).isEqualTo(12);
        assertThat(dto.getImage()).isEqualTo("cares.jpg");
    }

    @Test
    @DisplayName("getRouteById() should throw ResourceNotFoundException when route not found")
    void shouldThrowException_WhenRouteNotFound() {
        when(routeRepository.findById(99L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> routeService.getRouteById(99L))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessageContaining("Route not found");
    }
}
