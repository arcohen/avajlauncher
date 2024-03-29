package avajlauncher;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);

        if (weather == "SUN") {
            coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
            AvajLauncher.output.println("Baloon#" + this.name + "(" + this.id +  "): Lovely day to drift and drink champagne.");
        } else if (weather == "RAIN") {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
            AvajLauncher.output.println("Baloon#" + this.name + "(" + this.id +  "): Way to spoil a romantic ballon ride. Thanks rain.");
        } else if (weather == "FOG") {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
            AvajLauncher.output.println("Baloon#" + this.name + "(" + this.id +  "): Sitting in a basket and I can't see shit.");
        } else if (weather == "SNOW") {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
            AvajLauncher.output.println("Baloon#" + this.name + "(" + this.id +  "): Snoooow. Time to snuggle in this blacket I prudently brought along.");
        }

        if (coordinates.getHeight() == 0) {
            weatherTower.unregister(this, "Baloon");
        }
    }
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this, "Baloon");
    }
}