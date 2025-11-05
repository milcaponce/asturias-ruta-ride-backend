package dev.milca.ruta_ride.route.dtos;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RouteDTOTest {
    @Test
    @DisplayName("Should create DTO with all fields")
    void testConstructorWithAllFields() {
        RouteDTO dto = new RouteDTO(
                1L,
                "Ruta del Cares",
                "Picos de Europa",
                12,
                "Media",
                "cares.jpg",
                "Ruta icónica con vistas espectaculares",
                43.1873,
                -4.8293
        );

        assertThat(dto.getIdRoute()).isEqualTo(1L);
        assertThat(dto.getName()).isEqualTo("Ruta del Cares");
        assertThat(dto.getArea()).isEqualTo("Picos de Europa");
        assertThat(dto.getKilometres()).isEqualTo(12);
        assertThat(dto.getDifficulty()).isEqualTo("Media");
        assertThat(dto.getImage()).isEqualTo("cares.jpg");
        assertThat(dto.getDescription()).contains("icónica");
        assertThat(dto.getLatitude()).isEqualTo(43.1873);
        assertThat(dto.getLongitude()).isEqualTo(-4.8293);
    }

    @Test
    @DisplayName("Should allow setting values through setters")
    void testSetters() {
        RouteDTO dto = new RouteDTO();

        dto.setIdRoute(5L);
        dto.setName("Senda del Oso");
        dto.setArea("Teverga");
        dto.setKilometres(22);
        dto.setDifficulty("Fácil");
        dto.setImage("oso.jpg");
        dto.setDescription("Ruta apta para familias y ciclistas");
        dto.setLatitude(null);
        dto.setLongitude(null);

        assertThat(dto.getIdRoute()).isEqualTo(5L);
        assertThat(dto.getName()).isEqualTo("Senda del Oso");
        assertThat(dto.getArea()).isEqualTo("Teverga");
        assertThat(dto.getKilometres()).isEqualTo(22);
        assertThat(dto.getDifficulty()).isEqualTo("Fácil");
        assertThat(dto.getImage()).isEqualTo("oso.jpg");
        assertThat(dto.getDescription()).contains("familias");
        assertThat(dto.getLatitude()).isNull();
        assertThat(dto.getLongitude()).isNull();
    }
    
}
