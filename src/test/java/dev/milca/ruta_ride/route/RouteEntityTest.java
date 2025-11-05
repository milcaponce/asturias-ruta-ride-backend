package dev.milca.ruta_ride.route;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


class RouteEntityTest {

    @Test
    @DisplayName("Debe crear una ruta con todos los campos correctamente asignados")
    void shouldCreateRouteWithAllFields() {
        RouteEntity route = new RouteEntity(
                "Ruta del Cares",
                "Picos de Europa",
                12,
                "Media",
                "Una de las rutas más populares de Asturias",
                "cares.jpg",
                43.3,
                -5.0
        );

        assertThat(route.getName()).isEqualTo("Ruta del Cares");
        assertThat(route.getArea()).isEqualTo("Picos de Europa");
        assertThat(route.getKilometres()).isEqualTo(12);
        assertThat(route.getDifficulty()).isEqualTo("Media");
        assertThat(route.getDescription()).contains("Asturias");
        assertThat(route.getImage()).isEqualTo("cares.jpg");
        assertThat(route.getLatitude()).isEqualTo(43.3);
        assertThat(route.getLongitude()).isEqualTo(-5.0);
    }

    @DisplayName("Debe permitir latitud y longitud nulas")
    void shouldAllowNullLatitudeAndLongitude() {
        RouteEntity route = new RouteEntity(
                "Ruta del Alba",
                "Sobrescobio",
                8,
                "Fácil",
                "Ruta apta para toda la familia",
                "alba.jpg",
                null,
                null
        );

        assertThat(route.getLatitude()).isNull();
        assertThat(route.getLongitude()).isNull();
    }

    @Test
    @DisplayName("equals() y hashCode() deben coincidir cuando el ID es el mismo")
    void equalsAndHashCode_ShouldMatchWhenIdIsSame() {
        RouteEntity route1 = new RouteEntity();
        route1.setIdRoute(1L);

        RouteEntity route2 = new RouteEntity();
        route2.setIdRoute(1L);

        assertThat(route1).isEqualTo(route2);
        assertThat(route1.hashCode()).isEqualTo(route2.hashCode());
    }

    @Test
    @DisplayName("equals() debe fallar cuando el ID es diferente")
    void equals_ShouldNotMatch_WhenIdIsDifferent() {
        RouteEntity route1 = new RouteEntity();
        route1.setIdRoute(1L);

        RouteEntity route2 = new RouteEntity();
        route2.setIdRoute(2L);

        assertThat(route1).isNotEqualTo(route2);
    }
}
