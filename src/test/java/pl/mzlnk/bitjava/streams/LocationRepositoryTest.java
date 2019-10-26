package pl.mzlnk.bitjava.streams;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LocationRepositoryTest {

    private LocationRepository locationRepository;
    private int[] numbers = {1, 4, 2, 9, 7, 3, 2, 2, 10, 0, -3, -9, -12, 3, 2, 5};

    @Before
    public void setUp() {
        locationRepository = new LocationRepository();
    }

    @Test
    public void findAllTest() {
        System.out.println("Number of locations: " + locationRepository.findAll().size());
    }

    @Test
    public void streamForEachTest() {
        locationRepository.findAll()
                .stream()
                .forEach(location -> System.out.println(location.toString()));

        locationRepository.findAll()
                .stream()
                .forEach(System.out::println);
    }

    @Test
    public void streamFilterTest() {
        locationRepository.findAll()
                .stream()
                .filter(location -> location.getLand().contains("Kingdom"))
                .forEach(System.out::println);
    }

    @Test
    public void streamMapTest() {

        locationRepository.findAll()
                .stream()
                .map(Location::getName)
                .filter(name -> name.contains("Tower"))
                .forEach(System.out::println);
    }

    @Test
    public void streamDistinctTest() {
        Arrays.stream(numbers)
                .map(v -> v *= 2)
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    public void streamLimitTest() {
        locationRepository.findAll()
                .stream()
                .limit(3)
                .forEach(System.out::println);
    }

    @Test
    public void streamFindAnyTest() {
        locationRepository.findAll()
                .stream()
                .filter(location -> location.getX() < -5000)
                .findAny()
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("No location found on x < -5000"));
    }

    @Test
    public void streamSortedTest() {
        locationRepository.findAll()
                .stream()
                .sorted((o1, o2) -> {
                    if (o1.getX() > o2.getX()) return 1;
                    else if (o1.getX() == o2.getX()) return 0;
                    else return -1;
                })
                .forEach(System.out::println);

//        locationRepository.findAll()
//                .stream()
//                .sorted((o1, o2) -> Integer.compare(o1.getX(), o2.getX()))
//                .forEach(System.out::println);
//
//        locationRepository.findAll()
//                .stream()
//                .sorted(Comparator.comparingInt(Location::getX))
//                .forEach(System.out::println);
    }

    @Test
    public void streamBoxedAndToArrayTest() {
        Integer[] negativeNumbers = Arrays.stream(numbers)
                .boxed()
                .filter(v -> v < 0)
                .toArray(Integer[]::new);

        System.out.println(Arrays.toString(negativeNumbers));
    }

    @Test
    public void streamCollectTest() {
        List<String> locationNames = locationRepository.findAll()
                .stream()
                .map(Location::getName)
                .collect(Collectors.toList());

        System.out.println(locationNames.toString());
    }

    @Test
    public void streamCollectToMapTest() {
        Map<String, String> namesMap = locationRepository.findAll()
                .stream()
                .collect(Collectors.toMap(Location::getName, Location::getLand));

        System.out.println("White Tower -> " + namesMap.get("White Tower"));
    }

}