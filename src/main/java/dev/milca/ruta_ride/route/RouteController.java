package dev.milca.ruta_ride.route;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.milca.ruta_ride.route.dtos.RouteDTO;



@RestController
@RequestMapping("/api/v1/routes")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping
    public List<RouteEntity> getAllRoutes() {
        return routeService.getAllRoutes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RouteDTO> getRouteById(@PathVariable Long id) {
        RouteDTO route = routeService.getRouteById(id);
        return ResponseEntity.ok(route);
    }
}
