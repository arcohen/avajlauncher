package avajlauncher;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0;
    
    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        id = nextId();
    }

    public String getName() {
        return this.name;
    }

    public long getId() {
        return this.id;
    }

    private long nextId() {
        return Aircraft.idCounter++;
    }
}