package dev.milca.ruta_ride.route;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {
    
    private final RouteRepository routeRepository;

    public RouteServiceImpl(RouteRepository routeRepository) { this.routeRepository = routeRepository;
    }

    @Override
    public List<RouteEntity> getAllRoutes() {
        return routeRepository.findAll();
    }
}
