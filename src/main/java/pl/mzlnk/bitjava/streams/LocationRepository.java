package pl.mzlnk.bitjava.streams;

import java.util.ArrayList;
import java.util.List;

public class LocationRepository {

    private List<Location> locations = new ArrayList<>();

    public LocationRepository() {
        locations.add(new Location(0, 0, 0, "Nexus", "Nexus"));
        locations.add(new Location(100, 20, -50, "White Tower", "Nexus"));
        locations.add(new Location(300, -120, 500, "Black Tower", "Emerald Kingdom"));
        locations.add(new Location(-2000, 200, 780, "Blue Tower", "Silver Kingdom"));
        locations.add(new Location(0, 80, -520, "Yellow Tower", "Silver Kingdom"));
        locations.add(new Location(1000, 0, 0, "Stone Mansion", "Bronze Kingdom"));
        locations.add(new Location(-2000, 70, -50, "Golden Mansion", "Emerald Kingdom"));
        locations.add(new Location(-9000, 1000, -10050, "Wilderness", "Wilderness"));
    }

    public List<Location> findAll() {
        Location loc = Location.builder()
                .land("land")
                .y(12)
                .build();
        return locations;
    }

}
