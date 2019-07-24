package avajlauncher;

public class AircraftFactory {

    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws CustomException{
        
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        
        switch (type) {
            case "baloon":
                return new Baloon(name, coordinates);
            case "jetplane":
                return new JetPlane(name, coordinates);
            case "helicopter":
                return new Helicopter(name, coordinates);
            default:
                throw new CustomException("Invalid aircraft type");
        }
    }
}