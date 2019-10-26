package pl.mzlnk.bitjava.streams;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Location {

    private static final String PATTERN = "Location: {name}, {country} -> {x}, {y}, {z}";

    @Getter
    private int x;
    private int y;
    private int z;

    private String name;
    private String land;

    public double distance(Location location) {
        return Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public String toString() {
        return PATTERN
                .replace("{name}", name)
                .replace("{country}", land)
                .replace("{x}", String.valueOf(x))
                .replace("{y}", String.valueOf(y))
                .replace("{z}", String.valueOf(z));
    }

}
