package dev.milca.ruta_ride.route.dtos;

public class RouteDTO {
    private Long idRoute;
    private String name;
    private String area;
    private Integer kilometres;
    private String difficulty;
    private String image;
    private String description;

    public RouteDTO() {}

    public RouteDTO(Long idRoute, String name, String area, Integer kilometres, String difficulty, String image, String description) {
        this.idRoute = idRoute;
        this.name = name;
        this.area = area;
        this.kilometres = kilometres;
        this.difficulty = difficulty;
        this.image = image;
        this.description = description;
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

}
