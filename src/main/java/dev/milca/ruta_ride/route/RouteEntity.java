package dev.milca.ruta_ride.route;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "routes")
public class RouteEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRoute;

    private String name;
    private String area;
    private Integer kilometres;
    private String difficulty;

    @Column(columnDefinition = "TEXT")
    private String description;

    // ---Constructors ---
    public RouteEntity() {}

    public RouteEntity(String name, String area, Integer kilometres, String difficulty, String description) {
        this.name = name;
        this.area = area;
        this.kilometres = kilometres;
        this.difficulty = difficulty;
        this.description = description;
    }

    // ---Getter y Setters ---
    public Long getIdRoute() { return idRoute; }
    public void setIdRoute(Long idRoute) {this.idRoute = idRoute; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }

    public Integer getKilometres() { return kilometres; }
    public void setKilometres(Integer kilometres) { this.kilometres = kilometres; }

    public String getDifficulty() { return difficulty; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
