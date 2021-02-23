package WesleyCodingTeam;

public class Location {
    private String name;
    private int enabled = 0;

    // if enabled = 0, not accessible, if enabled = 1, accesisble
    public Location(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }



}
