package Week5.Collections;

import java.util.*;

public class Collections {
    // Det vi skrev i main på lektionen
    public static void collections(){
        /*
        Skapa en List<String> med ord.
        Använd Iterator och remove() för att ta bort alla ord som är kortare än fyra bokstäver.
        Vad händer om du försöker ta bort något från listan med remove metoden på List interfacet i din loop?
        https://medium.com/@AlexanderObregon/beginners-guide-to-java-iterators-e8d4eb19bf5d
         */

        /*
        List<String> words = new ArrayList<>();
        words.add("Cykel");
        words.add("Cykelpump");
        words.add("Hjul");
        words.add("Styre");
        words.add("Växellåda");

        for(String word : words){
            if(word.length()<5){
                words.remove(word);
            }
        }



        Iterator<String> iterator = words.iterator();
        while (iterator.hasNext()) {
            String word = iterator.next();
            if(word.length()<5){
                iterator.remove();
            }
        }


        System.out.println(words);
        */


        /*
        Sortera lista
        Skapa en List<Integer> med tio tal. Sortera listan med Collections.sort() och skriv ut resultatet.
        Om vi nu vill lägga till ett nytt värde behöver vi antingen sortera om listan efteråt eller stoppa in
        vårt nya värde på rätt plats i den sorterade listan.
        Finns det någon Collection i Java som är automatiskt sorterad?  https://www.baeldung.com/java-sorted-list

        List<Integer> numbers = new ArrayList<>();

        numbers.add(5);
        numbers.add(12);
        numbers.add(3);
        numbers.add(8);
        numbers.add(1);
        numbers.add(7);
        numbers.add(10);
        numbers.add(4);
        numbers.add(6);
        numbers.add(9);*/

/*
        List<Integer> numbers = Arrays.asList(new Integer[]{3,5,6,2,1,7,8,4});

        Collections.sort(numbers);


        System.out.println("Sorterad lista: " + numbers);

        numbers.add(2);

        Collections.sort(numbers);
        System.out.println("Efter att ha lagt till 2 och sorterat igen " + numbers);


        TreeSet set = new TreeSet<>();
        set.add(2);
        set.add(3);
        set.add(1);
        set.add(4);

        System.out.println("Tree set: " + set);


*/


        /*
        Sortera lista
    Skapa en List<Integer> med tio tal. Sortera listan med Collections.sort() och skriv ut resultatet.
    Om vi nu vill lägga till ett nytt värde behöver vi antingen sortera om listan efteråt eller stoppa in
    vårt nya värde på rätt plats i den sorterade listan.
    Finns det någon Collection i Java som är automatiskt sorterad?  https://www.baeldung.com/java-sorted-list

         */


        /*
        Map<Animal, String> mapOfAnimals = new HashMap<>();
        Animal dolphine = new Animal();

        mapOfAnimals.put(dolphine, "Dolphine");
        mapOfAnimals.get(dolphine); // Exactly the same object to get "Dolphine"
        */



        /*
        Scanner scanner = new Scanner(System.in);
        System.out.println("Skriv en mening :");
        String mening = scanner.nextLine();

        String[]ord = mening.split("\\s+"); // Split words by space
        Set<String> unikaOrd = new HashSet<>();
        for(String o : ord){
            unikaOrd.add(o);
        }
        System.out.println("Antal unika ord: " + unikaOrd.size());
        */

        /*Safe safe = new Safe<String>();
        safe.store("Hello");
        Object answer = safe.retrieve();
        System.out.println(answer);

        List<String> fruits = new ArrayList<>();*/
        //listWithNames();
        //phoneBookWithMap();
    }

    // Det vi gjorde som egna metoder i Main-filen på lektionen

    public static void listWithNames(){
        /*
        Skapa en List<String> med fem namn.
        Lägg till ett nytt namn, ta bort ett annat,
        Skriv ut alla namn med en for-loop.
        Hur skriver vi ut första och sista namnet i listan?
         */
        List<String> names = new ArrayList<>();
        names.add("Elyse");
        names.add("Ben");
        names.add("Juliette");
        names.add("Noah");
        names.add("Kevin");

        names.remove("Kevin");
        names.add("Mozart");

        for (String name : names){
            System.out.println(name);
        }

        System.out.println("First name: " + names.getFirst());
        System.out.println("Last name: " + names.getLast());

    }

    public static void phoneBookWithMap(){
        /*
        Telefonbok med Map
        1. Skapa en Map<String, String> där nyckeln är ett namn och värdet är ett telefonnummer.
        2. Lägg till tre personer och skriv ut alla poster med en for-each över entrySet().
        3. Lägg till möjlighet att hämta ut ett telefonnummer genom att ange ett namn och
        få telefonnumret utskrivet.
         */

        Map<String, String> phoneBook = new HashMap<>();

        phoneBook.put("Anna", "123");
        phoneBook.put("Beatrice", "456");
        phoneBook.put("Cindy", "789");

        Set<Map.Entry<String, String>> entrySet = phoneBook.entrySet();
        for(Map.Entry<String, String> pair : entrySet){
            System.out.println("Name: " + pair.getKey() + ", Phone: " + pair.getValue());
        }

        String name = "Beatrice";
        String phoneNr = phoneBook.get(name);
        System.out.println("Phone number: " + phoneNr);
    }

    public static void countOccurencesWithMap(){
        /*
        Räkna förekomster med Map
        Läs in en större text och räkna hur många gånger varje ord förekommer.
        Använd en Map<String, Integer> och
        kontrollera om nyckeln finns med containsKey().
         */

        String text = "Det är kul att cykla haha cykla haha haha";
        Map<String, Integer> map = new HashMap<>();
        String[] ord = text.split("\\s+");
        List<String> list = Arrays.asList(ord);

        for(String word : list){
            // Case 1: Word does not exist as key
            if(!map.containsKey(word)){
                map.put(word,1);
            }
            // Case 2: Word exists, increase amount by 1
            else{
                int amountOfTimes = map.get(word);
                map.put(word, amountOfTimes + 1);
            }
        }

        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();

        System.out.println(text);

        for(Map.Entry<String, Integer> pair : entrySet){
            System.out.println("Word: " + pair.getKey() + ", Amount: " + pair.getValue());
        }


    }

    public static void mapWithDefaultValue(){
        /*
        Map med default-värde
        Skapa en Map<String, Integer> med några nycklar.
        Använd getOrDefault() för att hämta värden, även om nyckeln inte finns.
         */

        Map<String, Integer> map = new TreeMap<>();
        map.put("Cindy", 5);
        map.put("Beatrice", 8);
        map.put("Anna", 4);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Write a name");
        String name = scanner.nextLine();
        Integer length = map.getOrDefault(name, null);

        if(length == null){
            System.out.println("Could not find name, please try again");
        }
        else{
            System.out.println(length);
        }

    }

    public static void groupWordsByLength(){
        /*
        Skapa en List<String> med ord.
        Skapa en Map<Integer, List<String>> där nyckeln är ordets längd
        och värdet är en lista med ord av den längden. Lägg till varje ord i rätt lista med hjälp av putIfAbsent().
         */


        String text = "Det är kul att cykla haha cykla haha haha";
        String[] ord = text.split("\\s+");
        List<String> list = Arrays.asList(ord);

        Map<Integer, List<String>> map = new HashMap<>();

        for(String word: list){
            List<String> listOfThisWord = new ArrayList<>();

            // Add empty list if word has not been seen before
            map.putIfAbsent(word.length(), listOfThisWord);

            // Add word to list
            List<String> wordsWithSameLength = map.get(word.length());
            wordsWithSameLength.add(word);
            map.put(word.length(), wordsWithSameLength);
        }


        Set<Map.Entry<Integer, List<String>>> entrySet = map.entrySet();
        for(Map.Entry<Integer, List<String>> pair : entrySet){
            System.out.println("Length: " + pair.getKey() + ", Words: " + pair.getValue());
        }
    }
}
