import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Exercise2 {
    public static void main(String[] args) {
        CountryDao countryDao = InMemoryWorldDao.getInstance();
        CityDao cityDao = InMemoryWorldDao.getInstance();
        // write your answer here

        Map<String, Optional<City>> mostPopulatedCities = cityDao.findAllCities().stream()
            .collect(Collectors.groupingBy(
                city -> countryDao.findCountryByCode(city.getCountryCode()).getContinent(),
                Collectors.maxBy(Comparator.comparingInt(City::getPopulation))
            ));
        mostPopulatedCities.forEach((continent, city) -> 
            System.out.println(continent + ": " + city.orElse(null))
        );
    }
}
