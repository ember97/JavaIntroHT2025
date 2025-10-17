package Week6;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.TreeMap;


public class Week6 {
    List<Country> countries = Country.getCountries();

    /*
    2 Skriv ut namnet på det första och det sista landet i listan på konsolen.
     */
    public void Q2(){
        String nameOfFirst = countries.stream()
                .map(Country::countryName)
                .findFirst()
                .orElse("no name found");

        System.out.println(nameOfFirst);

        countries.stream()
                .skip(countries.size() - 1)
                .findFirst()
                .ifPresent(stad -> System.out.println(stad));

        String s2 = countries.stream()
                .reduce((first, second) -> second)
                .map(Country::countryName)
                .orElse("");
        System.out.println(s2);
    }

    /*
    3 Skriv ut namnen på alla länder i listan, sorterade i bokstavsordning.
     */
    public void Q3(){
        countries.stream()
                .map(Country::countryName)
                .sorted()
                .forEach(System.out::println);
    }
    /*
    4 Skriv ut namnen på alla länder i listan, sorterade efter befolkning,
      med den högsta befolkningen först.
     */
    public void Q4(){
        countries.stream()
                .sorted(Comparator.comparingDouble(Country::population).reversed())
                .map(Country::countryName)
                .forEach(System.out::println);

        // Alternativ:
        countries.stream()
                .sorted(Comparator.comparingDouble(Country::population).reversed())
                .forEach(country -> System.out.println(country.countryName()));
    }
    /*
    5 Skriv ut vilken den största befolkningsmängden är.
     */
    public void Q5(){
        countries.stream()
                .max(Comparator.comparing(Country::population))
                .ifPresent(c->System.out.println("Landet med störst befolning är " + c.getName() + " med " + c.getPopulation() + "miljoner invånare"));

        // Alternativt:
        Country c = countries.stream()
                .max(Comparator.comparing(Country::population))
                .orElseThrow();

        System.out.println("Landet med störst befolning är " + c.getName() + " med " + c.getPopulation() + "miljoner invånare");



    }
    /*
    6 Skriv ut genomsnittsarean och hur många länder som
      har en mindre area än genomsnittet.
     */
    public void Q6(){
        double avgArea = countries.stream()
                .mapToInt(Country::area)
                .average()
                .orElse(0.0);

        long nOfCountries = countries.stream()
                .filter(c -> c.area() < avgArea)
                .count();

        System.out.println("Avg area: " + avgArea);
        System.out.println("Number of countries with area less than avg: " + nOfCountries);

    }
    /*
    7 Skriv ut namnen på alla länder som har en befolkning som är mindre än 5 miljoner.
      ---- data: name -----    condition: population less than five million
     */
    public void Q7(){
        countries.stream()
                .filter(c -> c.population() < 5)
                .map(Country::getName)
                .forEach(System.out::println);
    }
    /*
    8 Använd tre queries för att skriva ut hur många länder som har en area över 10 000,
  över 100 000 och över 1 000 000 respektive.
     */



    public void Q8(){

        var over10k = countries.stream().filter(country -> country.area() > 10000).count();
        var over100k = countries.stream().filter(country -> country.area() > 100000).count();
        var over1000k = countries.stream().filter(country -> country.area() > 1000000).count();

        System.out.println("\nOver 10k:" + over10k +
                " Over 100k:" + over100k +
                " over 1000k:" + over1000k);

    }
    /*
    Skriv ut namn och huvudstad för alla länder vars huvudstad börjar
    på samma bokstav som landets namn.
     */
    public void Q9(){
        countries.stream()
                .filter(country -> country.getName().charAt(0) == country.capital().charAt(0))
                .forEach(country -> System.out.println("name: " + country.getName() + ", capital: " + country.capital()));
    }
    /*
    10 Skriv ut alla land vars namn är längre än namnet på deras huvudstad.
     */
    public void Q10(){
        countries.stream()
                .filter(c -> c.getName().length() > c.capital().length())
                .forEach(System.out::println);

    }
    /*
    11 Skriv ut de fem första länderna som har minst folkmängd.
     */
    public void Q11(){
        countries.stream()
                .sorted(Comparator.comparingDouble(Country::population))
                .limit(5)
                .forEach(System.out::println);

    }

    /*
    12 Skriv ut de tre första länderna som har minst folkmängd och över 7 miljoner.
       Exempelvis kommer Norge inte med för det har bara 5 miljoner,
       men Sverige har 10 miljoner så det kommer med.
     */
    public void Q12(){
        countries.stream()
                .filter(c -> c.population() > 7)
                .sorted(Comparator.comparingDouble(Country::population))
                .limit(3)
                .forEach(System.out::println);
    }
    public void Q13(){

    }

    /*
    14 Skriv ut hur många länder det finns som börjar på varje bokstav som finns i listan.
   Exempelvis så finns det tre länder vars namn börjar på S, ett som börjar på D och två som börjar på F.
     */
    public void Q14(){
        Map<Character, Long> dir = countries.stream()
                .collect(Collectors.groupingBy(c -> c.getName().charAt(0), Collectors.counting()));

        System.out.println(dir);
    }

    /*
    15 Skriv ut hur många länder det finns som har en befolkning på X miljoner och deras namn.
   Sortera dem i bokstavsordning på namnet.
   Befolkningsmängden ska avrundas nedåt till ett heltal.
   Utskriften ska se ut ungefär så här:
    Länder med 0 miljoner invånare:
    - Island
    - Niue
    Länder med 3 miljoner invånare:
    - Mongoliet
    osv.
     */

    public void Q15(){
        System.out.println("Länder med mindre än 1mil medborgare");
        countries.stream()
                .filter(stad -> Math.floor(stad.getPopulation()) < 1)
                .map(stad -> stad.getName())
                .forEach(stad -> System.out.println(stad));

        // Alternativ:
        Map<Integer, List<String>> grupperadeLander = countries.stream()
                .collect(Collectors.groupingBy(
                        c -> (int) Math.floor(c.population()),                // Avrundar nedåt till heltal
                        TreeMap::new,                                        // Sorterar grupperna i stigande ordning
                        Collectors.mapping(Country::getName, Collectors.toList()) // Samlar namn i varje grupp
                ));

        grupperadeLander.forEach((miljoner, namnLista) -> {
            System.out.println("Länder med " + miljoner + " miljoner invånare:");
            namnLista.stream()
                    .sorted()                                            // Sorterar namn alfabetiskt
                    .forEach(namn -> System.out.println("- " + namn));
        });

    }


    /*
    16a Skriv ut namnet och befolkningsmängden för alla länder,
    men räkna om befolkningsmängden till faktiska tal.
    Alltså ska till exempel 1.5 miljoner skrivas ut som 1500000.
     */
    public void Q16a(){
        countries.stream()
                .map(Statistics::of)
                .forEach(System.out::println);

    }

    /*
    16b Skriv ut namnet på alla länder och hur trångbodda de är.
    Trångboddheten räknar du ut genom att ta befolkningsmängden delat med arean.
    Räkna om befolkningsmängden till faktiska tal som i 16a först.
     */
    public void Q16b(){
        countries.stream()
                .map((Statistics::crowdedness))
                .forEach(System.out::println);
    }

    /*
    17 Skriv ut namnet på alla länder, sorterat fallande efter deras huvudstäders namn baklänges.
   Till exempel kommer Tyskland före Niue, eftersom Alofi → ifola kommer före Berlin → nilreB.
     */
    public void Q17(){
        countries.stream()
                .sorted(Comparator.comparing(c -> c.getReverse()))
                .map(Country::countryName)
                .forEach(System.out::println);
        /*
        Såhär kan man också reverse Strings:
        Comparator.comparing(c -> new StringBuilder(c.capital).reverse())
         */
    }

    /*
    18 Skriv ut hur stor befolkning de 6 minsta länderna har tillsammans.
        Skriv också ut hur stor befolkning de 3 största länderna har tillsammans.
     */
    public void Q18(){

        double befolkningMinsta6 = countries.stream()
                .sorted(Comparator.comparing(countries -> countries.getPopulation()))
                .limit(6)
                .mapToDouble(countries -> countries.getPopulation())
                .sum();

        double befolkningStörsta3 = countries.stream()
                .sorted(Comparator.comparing(Country::population).reversed())
                .limit(3)
                .mapToDouble(countries -> countries.getPopulation())
                .sum();

        System.out.println("Största 3: " + (befolkningStörsta3 * 1000000) + ", minsta 6:" + (befolkningMinsta6 * 1000000));

    }

    /*

    19 Skriv ut hur stor befolkning alla länder vars namn är 7 tecken långt har tillsammans
     */
    public void Q19(){
        double sumOfSevenLargest = countries.stream()
                .filter(c -> c.getName().length() == 7)
                .mapToDouble(countries -> countries.getPopulation())
                .sum();

        System.out.println(sumOfSevenLargest);
    }

}
