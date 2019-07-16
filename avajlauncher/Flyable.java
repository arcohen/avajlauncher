package avajlauncher;

public interface Flyable {
    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
	public String getName();
	public long getId();
}