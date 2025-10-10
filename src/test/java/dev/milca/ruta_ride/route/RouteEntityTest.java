package dev.milca.ruta_ride.route;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


class RouteEntityTest {

    @Test
    void testRouteEntityGettersAndSetters() {
        RouteEntity route = new RouteEntity();
        route.setIdRoute(1L);
        route.setName("Ruta del Cares");
        route.setArea("Picos de Europa");
        route.setKilometres(12);
        route.setDifficulty("Media");
        route.setDescription("Una de las rutas más populares de Asturias");

        assertThat(route.getIdRoute()).isEqualTo(1L);
        assertThat(route.getName()).isEqualTo("Ruta del Cares");
        assertThat(route.getArea()).isEqualTo("Picos de Europa");
        assertThat(route.getKilometres()).isEqualTo(12);
        assertThat(route.getDifficulty()).isEqualTo("Media");
        assertThat(route.getDescription()).contains("Asturias");
    }

    @Test
    void testEqualsAndHashCode() {
        RouteEntity route1 = new RouteEntity();
        route1.setIdRoute(1L);

        RouteEntity route2 = new RouteEntity();
        route2.setIdRoute(1L);

        assertThat(route1).isEqualTo(route2);
        assertThat(route1.hashCode()).isEqualTo(route2.hashCode());
    }
}
