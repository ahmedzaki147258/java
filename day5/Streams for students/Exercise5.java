import java.util.Comparator;

public class Exercise5 {
    public static void main(String[] args) {
        CountryDao countryDao = InMemoryWorldDao.getInstance();
        CityDao cityDao = InMemoryWorldDao.getInstance();
        // write your answer here

        City highestPopulatedCapital = countryDao.findAllCountries().stream()
            .map(cnt-> cnt.getCapital()) // capitalID
            .map(capID-> cityDao.findCityById(capID)) // capital object
            .filter(cID-> cID != null)
            .max(Comparator.comparingInt(c-> c.getPopulation()))
            .orElse(null);

        System.out.println("Highest populated capital: [" + highestPopulatedCapital.getName() + "] with population [" + highestPopulatedCapital.getPopulation() + "]");
    }
}
