package avajlauncher;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);

        if (weather == "SUN") {
            coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
            AvajLauncher.output.println("Helicopter#" + this.name + "(" + this.id +  "): Sun baby!.");
        } else if (weather == "RAIN") {
            coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
            AvajLauncher.output.println("Helicopter#" + this.name + "(" + this.id +  "): Close the window.");
        } else if (weather == "FOG") {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight() - 3);
            AvajLauncher.output.println("Helicopter#" + this.name + "(" + this.id +  "): Chilling in a helicopter in the fog.");
        } else if (weather == "SNOW") {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
            AvajLauncher.output.println("Helicopter#" + this.name + "(" + this.id +  "): Chilling in a helicopter in the snow.");
        }

        if (coordinates.getHeight() == 0) {
            weatherTower.unregister(this, "Helicopter");
        }
    }
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this, "Helicopter");
    }
}