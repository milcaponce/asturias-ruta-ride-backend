package dev.milca.ruta_ride.route;

import java.util.List;
import dev.milca.ruta_ride.route.dtos.RouteDTO;

public interface RouteService {
    List<RouteEntity> getAllRoutes();

    RouteDTO getRouteById(Long id);
}
