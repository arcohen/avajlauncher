package avajlauncher;

public class WeatherProvider {
    private static String [] weather ={"RAIN", "FOG", "SUN", "SNOW"}; ;
    private static WeatherProvider weatherProvider  = new WeatherProvider();

    private WeatherProvider() {}

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        return weather[(coordinates.getLatitude()+coordinates.getLongitude()+coordinates.getHeight()) % 4];
    }
}