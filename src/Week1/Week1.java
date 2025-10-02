package Week1;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Week1 {


    public void Q1(){

        /*
        int x;
        x = 15;
        System.out.println(x);
*/

/*
        int x = 10;
        int y = x - 1;
        System.out.println(y);
*/

/*
        int x, y;
        x = (int)120.954;
        y = x * 2;
        System.out.println(x + y);
*/


/*
        String s = "amm";
        s = "fäkt";
        System.out.println("An" + s + "a");
*/

/*
        String a = "an", b = "be", d= "do";
        System.out.println(a + b + a + d + b);
         */

/*
        int x = 2, y = 4, z = 8;
        // (x * y + z) / y = 4
        // - z               -4
        System.out.println( (x * y + z) / y - z + y / (x * z / x) );
*/
    }

    public void Q2(){
        int age = 32;
        double weight = 55;
        char initial = 'S';
        String initial2 = "S";

        System.out.println(age);
        System.out.println(weight);
        System.out.println(initial);
        System.out.println(initial2);
    }

    public void Q3() {
        System.out.println("Vad heter du?");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println("Hej " + name + ", välommen!");
        scanner.close();
    }


    public void Q4(){
        double width = 4, height = 2;
        double area = width * height;
        System.out.println("Area is " + area);
    }

    public void Q5() {
        int age = 17;
        int ageUntil = 18 - age;
        if (age >= 18) {
            System.out.println("Du är gammal nog att ta körkort!");
        }  else {
            System.out.println("Du behöver vänta i " + ageUntil + " år till.");
        }
    }

    public void Q6(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ange två tal, separera med mellanslag");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int average = (x + y) / 2;
        int max = Integer.max(x, y);
        System.out.println(average + " " + max);

    }

    public void testReadLine(){
        String input = System.console().readLine();

        try{
            int parsedInput = Integer.parseInt(input);
        }
        catch(Exception e){
            System.out.println("Not a number");
        }

    }

    public void Q7(){
        Scanner scanner = new Scanner(System.in);

        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("sv", "SE"));
        symbols.setDecimalSeparator(',');
        DecimalFormat formatter = new DecimalFormat("#,##0.00", symbols);

        String pattern = "###,###.###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);


        System.out.println("Hur mycket har du handlat för?");
        double tal = Double.parseDouble(scanner.nextLine().replace(',', '.'));

        System.out.println("Vad är momsen på det du har handlat för? (6, 12 eller 25%) ");
        double momsProcent = Double.parseDouble(scanner.nextLine().replace(',', '.'));

        double totalAmount = tal * (1.0 + momsProcent);


        System.out.println("Den totala summan blir: " + formatter.format(totalAmount));
        System.out.println("Exkl moms: " + formatter.format(tal));
        System.out.println("Moms är: " + formatter.format(momsProcent));
    }


    public void Q7_2(){
        Scanner sc = new Scanner(System.in);

// Formatter för svenska tal
        NumberFormat nf = NumberFormat.getNumberInstance(new Locale("en", "UK"));
        nf.setMinimumFractionDigits(1);
        nf.setMaximumFractionDigits(5);

// Fråga efter summa
        System.out.print("Ange bruttosumma (kr): ");
        double brutto = sc.nextDouble();

// Fråga efter moms
        System.out.print("Ange moms (6, 12 eller 25): ");
        double momsProcent = sc.nextDouble();

// Räkna ut moms och totalsumma
        double moms = brutto * momsProcent / 100.0;
        double totalt = brutto + moms;

// Skriv ut resultat
        System.out.println("Brutto summa: " + nf.format(brutto) + " kr");
        System.out.println("Moms " + (int)momsProcent + "%    : " + nf.format(moms) + " kr");
        System.out.println("Totalt       : " + nf.format(totalt) + " kr");

        sc.close();
    }


    public void Q8() {
        double grade = 85.5;
        double attendance = 75.0;

        if (grade >= 70.0 && attendance >= 80.0) {
            System.out.println("Grattis, du har klarat kursen!");
        } else {
            System.out.println("Tyvärr, du måste göra om kursen!");
        }
    }

    public void Q9(){
        char grade = 'D';


        switch (grade) {
            case 'A' -> System.out.println("Utmärkt");
            case 'B' -> System.out.println("Bra jobbat");
            case 'C', 'D' -> System.out.println("Godkänt");
            default -> System.out.println("underkänt");

        }

    }

    // TODO: We are here!! :)
    /*
    10 Skapa ett program som använder en statisk metod för att beräkna medelvärdet av tre tal.
    Skapa en statisk metod med namnet calculateAverage som tar tre double parametrar (num1, num2, num3).
    Inuti metoden, beräkna medelvärdet: (num1 + num2 + num3) / 3.0. Returnera resultatet.
    I din main-metod, deklarera tre double variabler, tilldela dem valfria värden.
    Kalla på calculateAverage metoden med dessa tre variabler och lagra resultatet i en ny variabel averageResult.
    Använd en if/else if/else-struktur för att bedöma medelvärdet:
    Om medelvärdet är högre än 90.0, skriv ut: "Mycket bra jobbat!".
    Om det är mellan 70.0 och 90.0 (inklusive), skriv ut: "Bra jobbat.".
    Annars, skriv ut: "Öva lite mer."
     */

    public static void calculateAverage(double num1, double num2, double num3){
        double numA = 1.2;
        double numB = 2.3;
        double numC = 3.4;
        double divider = 3.0;
        double averageResult = (num1 + num2 + num3) / divider;

        if(averageResult > 90.0){
            System.out.println("Mycket bra jobbat!");
        } else if(averageResult <= 90.0 && averageResult > 70.0){
            System.out.println("Bra jobbat.");
        } else {
            System.out.println("Öva lite mer");
        }
    }




    public void Q10(){


       // calculateAverage(numA, numB, numC);
    }

    // Write calculateAverage here and call it from Q10


    public void Q11(){
        int a = 3; //  Vad händer om vi istället initialiserar a med 2 eller 3?
        if( a > 1 )
            System.out.println("a > 1 (första)");
        a--;
        if( a > 1 ) {
            System.out.println("a > 1 (andra)");
        }
        else {
            System.out.println("a <= 1");
        }

    }

    public void Q12(){
        final char c = 'a';
        switch( c ) {
            case 'a':
                System.out.println("variable is 'a'");
                break;
            case 'b':
                System.out.println("variable is 'b'");
                break;
            default:
                System.out.println("variable is another letter");
                break;
        }

    }

    /*
    Bonus: Fizzbuzz

    Skriv en metod som tar in en integer.
    Om talet är jämnt delbart med 3, skriv ut "Fizz"
    Om talet är jämnt delbart med 5, skriv ut "Buzz"
    Om talet är både jämnt delbart med 3 och 5, skriv ut "Fizz Buzz"
     */

    /*

     */

    public void testFizzBuzz(){
       int x = 7;
       fizzBuzz(x);
    }

    // Bonus question
    public void fizzBuzz(int x){
        if(x%3==0 && x%5==0){
            System.out.println("Fizz Buzz");
        }else if(x%3==0){
            System.out.println("Fizz");

        }else if(x%5==0){
            System.out.println("Buzz");
        }
        else{
            // Do nothing
        }

    }


}
