package dev.milca.ruta_ride.route.dtos;

public class RouteDTO {
    private Long idRoute;
    private String name;
    private String area;
    private Integer kilometres;
    private String difficulty;
    private String image;
    private String description;
    private Double latitude;
    private Double longitude;

    public RouteDTO() {}

    public RouteDTO(Long idRoute, String name, String area, Integer kilometres, String difficulty, String image, String description, Double latitude, Double longitude) {
        this.idRoute = idRoute;
        this.name = name;
        this.area = area;
        this.kilometres = kilometres;
        this.difficulty = difficulty;
        this.image = image;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    //Get y Set
    public Long getIdRoute() { return idRoute; }
    public void setIdRoute(Long idRoute) { this.idRoute = idRoute; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }

    public Integer getKilometres() { return kilometres; }
    public void setKilometres(Integer kilometres) { this.kilometres = kilometres; }

    public String getDifficulty() { return difficulty; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }

}
