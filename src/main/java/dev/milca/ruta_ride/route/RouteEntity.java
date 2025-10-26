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
    @Column(name = "id_route")
    private Long idRoute;

    private String name;
    private String area;
    private Integer kilometres;
    private String difficulty;
    private String image;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = true)
    private Double latitude;

    @Column(nullable = true)
    private Double longitude;

    // ---Constructors ---
    public RouteEntity() {}

    public RouteEntity(String name, String area, Integer kilometres, String difficulty, String description, String image, Double latitude, Double longitude) {
        this.name = name;
        this.area = area;
        this.kilometres = kilometres;
        this.difficulty = difficulty;
        this.description = description;
        this.image = image;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public String getImage() { return image; }
    public void setImage(String image) {
        this.image = image; }
    
    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }
    

     // ===== equals() y hashCode() =====
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RouteEntity)) return false;
        RouteEntity that = (RouteEntity) o;
        return idRoute != null && idRoute.equals(that.idRoute);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
