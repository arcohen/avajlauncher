package avajlauncher;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);

        if (weather == "SUN") {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
            AvajLauncher.output.println("Jetplane#" + this.name + "(" + this.id +  "): Full speed ahead motherfckers.");
        } else if (weather == "RAIN") {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5, coordinates.getHeight());
            AvajLauncher.output.println("Jetplane#" + this.name + "(" + this.id +  "): Splitting raindrops with dees wings.");
        } else if (weather == "FOG") {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight() - 3);
            AvajLauncher.output.println("Jetplane#" + this.name + "(" + this.id +  "):  Watch out for those mountains pilot.");
        } else if (weather == "SNOW") {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
            AvajLauncher.output.println("Jetplane#" + this.name + "(" + this.id +  "): Would be cool if we could land little bit snowy.");
        }

        if (coordinates.getHeight() == 0) {
            weatherTower.unregister(this, "JetPlane");
        }
    }
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this, "JetPlane");
    }
}