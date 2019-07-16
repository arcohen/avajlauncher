package avajlauncher;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);

        if (weather == "SUN") {
            coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
            Avajlauncher.output.println("Lovely day to drift and drink champagne.");
        } else if (weather == "RAIN") {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
            Avajlauncher.output.println("Way to spoil a romantic ballon ride. Thanks rain.");
        } else if (weather == "FOG") {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
            Avajlauncher.output.println("Sitting in a basket and I can't see shit.");
        } else if (weather == "SNOW") {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
            Avajlauncher.output.println("Snoooow. Time to snuggle in this blacket I prudently brought along.");
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