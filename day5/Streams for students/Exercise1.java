import java.util.Comparator;
import java.util.Objects;

public class Exercise1 {
   public static void main(String[] args) {
      CountryDao countryDao= InMemoryWorldDao.getInstance();
      CityDao cityDao = InMemoryWorldDao.getInstance();

      countryDao.findAllCountries().forEach(country-> {
         cityDao.findAllCities().stream()
            .filter(c-> Objects.equals(c.getCountryCode(), country.getCode()))
            .max(Comparator.comparingInt(c-> c.getPopulation()))
            .stream()
            .forEach(city-> System.out.println("Country: [" + country.getName() + "], City: [" + city.getName() + "], Population: [" + city.getPopulation() + "]"));
      });
   }
}
