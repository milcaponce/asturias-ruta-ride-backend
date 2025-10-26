package dev.milca.ruta_ride.route;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import dev.milca.ruta_ride.route.dtos.RouteDTO;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

@ExtendWith(MockitoExtension.class)
class RouteControllerTest {

    @Mock
    private RouteService routeService;

    @InjectMocks
    private RouteController routeController;

    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(routeController).build();
    }

    @Test
    void testGetAllRoutesEndpointReturnsOk() throws Exception {
        RouteEntity route = new RouteEntity();
        route.setIdRoute(1L);
        route.setName("Ruta del Cares");
        route.setDifficulty("Media");

        when(routeService.getAllRoutes()).thenReturn(List.of(route));

        mockMvc.perform(get("/api/v1/routes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", is("Ruta del Cares")));
    }

    @Test
    void testGetRouteByIdReturnsOk() throws Exception {
        RouteDTO routeDTO = new RouteDTO(
                1L,
                "Ruta del Cares",
                "Picos de Europa",
                12,
                "Moderada",
                "ruta-cares.jpg",
                "Ruta icónica con vistas espectaculares",
                43.1793, -4.8046
        );

        when(routeService.getRouteById(1L)).thenReturn(routeDTO);

        mockMvc.perform(get("/api/v1/routes/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name", is("Ruta del Cares")))
            .andExpect(jsonPath("$.area", is("Picos de Europa")))
            .andExpect(jsonPath("$.difficulty", is("Moderada")));
    }

@Test
void testGetRouteByIdReturnsNotFound() throws Exception {
    when(routeService.getRouteById(99L))
            .thenThrow(new dev.milca.ruta_ride.common.exceptions.ResourceNotFoundException("Route not found"));

    mockMvc.perform(get("/api/v1/routes/99"))
            .andExpect(status().isNotFound());
    }
}
