package Week2;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// String input = System.console().readLine();

public class Week2Loops {

    // 1 Skriv ett program som skriver ut talen 1 till 16 med hjälp av en loop.
    public void Q1() {
        int i = 1;
        while (i < 17) {
            System.out.println(i);
            i++;
        }

    }


    public void Q2() {
        for (int i = 65536; i > 2; i = i >> 1) {
            System.out.println(i);
        }
    }

    /*
    3 Skriv ett program som skriver ut de jämna talen 20 till 2 i den ordningen,
    med hjälp av en loop. Tips: Modulo operatorn %
     */
    public void Q3() {

        for (int i = 20; i >= 2; i -= 2) {
            System.out.println(i);
        }
    }


    public void Q4() {
        String output = "";

        while (true) {
            String input = System.console().readLine();
            if (input.equals(".") || input.isEmpty()) {
                break;
            } else if (output.length() == 0) {
                output += input;
            } else {
                output += " " + input;
            }
        }

        System.out.println(output);

    }

    public void Q4_2() {
        String ord = System.console().readLine("enter a word: ");
        String allWords = " ";

        while (!ord.equals(" ") && !ord.equals(".")) {
            allWords = allWords + ord + " ";
            System.out.println("all words are: " + allWords);
            ord = System.console().readLine("Enter another word: ");
        }
        System.out.println("All the words you entered are: " + allWords);
    }


    public void Q5() {
        System.out.println("Give us a number, actions might vary depending on input");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        while (input >= 2) {
            if (input % 2 == 1)
                input = input * 3 + 1;
            else {
                input = input / 2;
            }
            System.out.println(input);
        }
        scanner.close();
    }

    public void Q6() {
        Scanner scanner = new Scanner(System.in);
        //Skapa ett random nummer 1-100
        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1;
        //Få ett tal från användaren


        while (true) {
            System.out.println("Skriv in ett nummer: ");
            int userInput = scanner.nextInt();
            //För högt
            if (secretNumber < userInput) {
                System.out.println("För högt!");
            } else if (secretNumber > userInput) {
                //För lågt
                System.out.print("För lågt!");
                //Korrekt
            } else {
                System.out.println("Korrekt! Bra jobbat!");
                break;
            }
        }
    }

    public void Q6_2(){
        int tal = Integer.parseInt(System.console().readLine("Gissa ett tal mellan tal 1-100: "));
        Random random = new Random();
        int randomTal = random.nextInt(100)+1;

        while (tal != randomTal) {
            if (randomTal < tal) {
                System.out.println("Du gissade för högt:");
                tal = Integer.parseInt(System.console().readLine("Gissa igen: "));
            }
            if (randomTal > tal) {
                System.out.println("Du gissade för lågt: ");
                tal = Integer.parseInt(System.console().readLine("Gissa igen: "));
            }
        }
        System.out.println("Du gissade rätt!! Talet var " + randomTal);
    }



// 7 Vad skriver följande program ut:
    public void Q7(){
        for(int y=0; y<5; y++) {
            for(int x=0; x<5; x++) {
                if( x == y )
                    System.out.println("#");
                else
                    System.out.println(".");
            }
            System.out.println("");
        }
    }

    /*
    8 Skapa ett program som lagrar och skriver ut fem tal.
    Deklarera en array av typen int med namnet numbers och storleken 5.
    Använd en for-loop för att tilldela varje element i arrayen ett värde (t.ex. 10, 20, 30, 40, 50).
    Använd en annan for-loop för att iterera igenom arrayen och skriva ut varje element på en ny rad.
     */
    public void Q8(){
        int[] numbers = new int[5];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (i+1)*10;
        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

    }

    /*
    9 Skapa ett program som skriver ut varje tecken i en textsträng.
    Deklarera en String variabel med namnet message och tilldela den en mening (t.ex. "Hej Java!").
    Använd en while-loop som fortsätter så länge som loopens räknare är mindre
     än längden på strängen (message.length()).
    Inuti loopen, använd message.charAt(index) för att hämta ut tecknet
     på det aktuella indexet och skriv ut det.
    Glöm inte att öka på din räknare i slutet av loopen.
     */
    public void Q9(){
        String message = "Hej hopp galopp";
        int index = 0;
        while(index <message.length()){
            System.out.println(message.charAt(index));
            index++;
        }

    }

    /*
    10 Skapa ett program som beräknar summan av alla element i en array.
     Deklarera en array int[] numbers = {5, 12, 8, 21, 3};
     Räkna nu ut summan av talen i arrayen med hjälp av en loop.
     Hur kan vi hitta det största och minsta värdet i arrayen?
     */
    public void Q10(){
        int[] numbers= {5, 12, 8, 21, 3};
        int sum = 0;
        int smallest = numbers[0];
        int largest = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            sum+=numbers[i];
            if(smallest > numbers[i]) {
                smallest = numbers[i];
            }
            if(largest < numbers[i]){
                largest = numbers[i];
            }
        }
        System.out.println("Summan av alla tal är: " + sum);
        System.out.println("Det minsta talet är " + smallest);
        System.out.println("Det största talet är " + largest);
    }
    /*
    11 Skapa en Record för att representera en bok som har String title och int pages.
     Skapa flera böcker med olika titlar och antal sidor och placera dessa i en array.
     Skriv en algoritm som kan hitta boken med flest sidor i arrayen.
     Skriv ut alla böcker snyggt formaterat med titel och antal sidor.
     */

    public void Q11(){
        record Bok (String title, int pages){}

        Bok[] books = new Bok[10];
        String userInput = "";
        int indexCounter = 0;

        while (!userInput.equalsIgnoreCase("n")){
            String title = System.console().readLine("Write a title: ");
            int pages = Integer.parseInt(System.console().readLine("Write a pages: "));
            Bok bok = new Bok(title, pages);
            books[indexCounter] = bok;
            indexCounter++;

            userInput = System.console().readLine("Do you want to continue adding books? (y/n)");
        }
        Bok largestBook = books[0];
        for (int i = 0; i < indexCounter; i++) {
            if(largestBook.pages < books[i].pages){
                largestBook = books[i];
            }
        }

        System.out.println("Book with largest amount of pages: " + largestBook.title);

        for (int i = 0; i < indexCounter; i++){
            System.out.printf("Title: %s\n Pages: %s\n", books[i].title, books[i].pages);
            System.out.println("Title: " + books[i].title);
            System.out.println(" Pages: " + books[i].pages);
        }



    }

/*
12 Skapa ett program som kollar om en given sträng är ett palindrom
   (läses likadant framlänges som baklänges). Tex: abba, anna, radar.

13 Låt programmet från uppgift 12 ignorera mellanslag vilket gör att
   följande text blir ett palindrom: “Ni talar bra latin”
 */
    public void Q12(){
        String word = (System.console().readLine("Skriv in ett ord: ").toLowerCase().replace(" ", ""));
        String newWord = ""; // “nitalarbralatin”

        for (int i = word.length()-1; i >=0; i--) {
            // Add letter
            newWord +=word.charAt(i);
        }

        if(word.equals(newWord)){
            System.out.println(word + " är samma som " + newWord);
        }
        else{
            System.out.println(word + " är inte samma som " + newWord);
        }
    }
/*
14 En annan rolig sak med ord är anagram.
Om man kastar om bokstäverna i ett ord så kan man få ett annat ord.
Skriv ett program som kollar om två ord är anagram.


"abcde".Substring(2) → "cde"
"abcde".Substring(2, 1) → "c"
 */
    public void Q14(){
        String word1 = "heartn";
        String word2 = "listen";

        // If not same length, cannot be anagram
        if(word1.length() != word2.length()){
            System.out.println("Inte anagram");
            return;
        }

        // Change strings to char arrays
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();

        // Sort the arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        if(Arrays.equals(arr1,arr2)){
            System.out.println("Orden är anagram");
        }
        else{
            System.out.println("Orden är inte anagram");
        }
    }


}
