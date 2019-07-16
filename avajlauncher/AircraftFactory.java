package avajlauncher;

public class AircraftFactory {

    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws CustomException{
        
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        
        switch (type) {
            case "Baloon":
                return new Baloon(name, coordinates);
            case "Jetplane":
                return new JetPlane(name, coordinates);
            case "Helicopter":
                return new Helicopter(name, coordinates);
            default:
                throw new CustomException("Invalid aircraft type");
        }
    }
}