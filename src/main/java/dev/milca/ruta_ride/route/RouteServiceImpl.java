package dev.milca.ruta_ride.route;

import org.springframework.stereotype.Service;
import java.util.List;

import dev.milca.ruta_ride.common.exceptions.ResourceNotFoundException;
import dev.milca.ruta_ride.route.dtos.RouteDTO;

@Service
public class RouteServiceImpl implements RouteService {
    
    private final RouteRepository routeRepository;

    public RouteServiceImpl(RouteRepository routeRepository) { this.routeRepository = routeRepository;
    }

    @Override
    public List<RouteEntity> getAllRoutes() {
        return routeRepository.findAll();
    }

    @Override
    public RouteDTO getRouteById(Long id) {
        RouteEntity route = routeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Route not found with id: " + id));

        return new RouteDTO(
                route.getIdRoute(),
                route.getName(),
                route.getArea(),
                route.getKilometres(),
                route.getDifficulty(),
                route.getImage(),
                route.getDescription()
        );
    }
}
