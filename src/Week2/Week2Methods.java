package Week2;


import java.text.DecimalFormat;
import java.time.LocalDate;
//import java.time.temporal.ChronoUnit.DAYS;

public class Week2Methods {
    
    public int year(String date){
        LocalDate dateFormatted = LocalDate.parse(date);
        int year = dateFormatted.getYear();
        return year;
    }
    /*
    public double daysBetween(String startDate, String endDate){
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        double numOfDays = ChronoUnit.DAYS.between(start, end);
        return numOfDays;
    }*/


    /*
    3 Skriv en funktion som översätter en temperatur i Fahrenheit till Celsius.
  Den ska ta en parameter och returnera ett värde. Välj lämpliga datatyper.
  Formel:
            degreesCelsius(T) = ((T-32) * 5)/9
     */

    public double CConverter(double F) {
        double celsius = (int) ((F-32) * 5 / 9);


        return celsius;
    }

    /*
    4 Skriv en funktion som inte tar några argument och som returnerar summan av de 100 första heltalen.
      Använd en loop. Förbättra sedan funktionen så att den tar en parameter, som är hur många tal som ska läggas ihop.
     */
    public int numbers(int count) {
        int sumofnumbers = 0;
        for (int i = 0; i <= count ; i++) {
            sumofnumbers += i;
        }
        return sumofnumbers;

    }

    /*
    5 Skriv en funktion som tar en sträng som parameter och returnerar strängen baklänges.
     */
    public String reverseWord(String word){
        String reversedWord = "";

        for (int i = word.length() - 1; i >= 0; i--){
            reversedWord += word.charAt(i);
        }
        return reversedWord;
    }

    /*
    6 Skriv en funktion som tar ett tal som parameter och returnerar true om det är ett primtal.
      Ett primtal är ett heltal som bara är delbart med sig självt och 1. De första primtalen är 2, 3, 5, 7.
      Men 8 är inget primtal eftersom 8 / 2 == 4.
     */

    public boolean isPrime(int number){
        if(number < 1){
            return false;
        }

        for (int i = 2; i < number; i++) {
            if(number % i == 0){
                return false;
            }
        }

        return true;
    }

    /*
    7 Skriv en funktion som beräknar medelvärdet av parametrarna som skickas in.
      Gör flera versioner (överlagring, overloading) av metoden som tar olika antal parametrar
      men har samma funktionsnamn.
      Vi vill kunna hantera 2,3,4,5…
     */
    public double meanOfNumbers(double a, double b){
        //double mean = (a + b) / 2
        return (a + b) / 2;
    }

    public double meanOfNumbers(double a, double b, double c){
        //double mean = (a + b + c) / 2
        return (a + b + c) / 3;
    }
    public double meanOfNumbers(double a, double b, double c, double d){
        //double mean = (a + b + c + d) / 2
        return (a + b + c + d) / 4;
    }

}


