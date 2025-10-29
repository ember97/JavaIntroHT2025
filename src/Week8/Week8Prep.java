package Week8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// This is work in progress, read if you want, I need to practice this too :)

public class Week8Prep {
    public void Q1(){
        Pattern pattern = Pattern.compile("kat");
        Matcher matcher = pattern.matcher("min katt har tre konkatenerade kanter");
        System.out.println("Matches: " + matcher.find());
    }
    public void Q2(){
        Pattern pattern = Pattern.compile("kat|kan|kon");
        Matcher matcher = pattern.matcher("min katt har tre konkatenerade kanter");

        int nOfOccurences = 0;

        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }

    // 3 Skriv ett pattern som tar reda på hur många gånger bokstaven "a" med valfri bokstav efter förekommer i strängen. Skriv ut varje sökträff på konsolen.
    public void Q3(){
        Pattern pattern = Pattern.compile("a[a-z]");
        Matcher matcher = pattern.matcher("min katt har tre konkatenerade kanter");

        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }

    // 4 Skriv ett pattern som tar reda på hur många gånger bokstaven "t" förekommer i strängen, omgiven av tecken som inte är t.
    public void Q4(){
        Pattern pattern = Pattern.compile("[^t]t[^t]");
        Matcher matcher = pattern.matcher("min katt har tre konkatenerade kanter");

        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
    // "hands jumbled terrific old-fashioned grass highfalutin stupendous daughter feigned skirt modern truthful"
    public void Q5(){
        Pattern pattern = Pattern.compile("as|od");
        Matcher matcher = pattern.matcher("hands jumbled terrific old-fashioned grass highfalutin stupendous daughter feigned skirt modern truthful");

        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
    /*
    6 Skriv ett pattern som tar reda på hur många gånger bokstäverna "a" eller "e" följs av "n", "d" eller "s" i strängen.

    7 Skriv ett pattern som tar reda på hur många ord i strängen som börjar med "d" eller "h". Sedan ett nytt pattern för hur många ord som slutar med "s".

    8 Ta reda på hur många ord i strängen som har en vokal som andra bokstav.

     */

    public void nOfOccurrences(String patternString, String text){

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);

        int n = 0;

        while(matcher.find()){
            System.out.println(matcher.group());
            n++;
        }

        System.out.println("Number of occurrences: " + n);
    }

    public void Q6(){
        // 6 Skriv ett pattern som tar reda på hur många gånger bokstäverna "a" eller "e" följs av "n", "d" eller "s" i strängen.
        nOfOccurrences("[ae][nds]", "hands jumbled terrific old-fashioned grass highfalutin stupendous daughter feigned skirt modern truthful");
    }
    // 7 Skriv ett pattern som tar reda på hur många ord i strängen som börjar med "d" eller "h". Sedan ett nytt pattern för hur många ord som slutar med "s".
    public void Q7(){
        nOfOccurrences("\\b[dh][a-z]*\\b", "hands jumbled terrific old-fashioned grass highfalutin stupendous daughter feigned skirt modern truthful");
        nOfOccurrences("\\b[a-z]*s\\b", "hands jumbled terrific old-fashioned grass highfalutin stupendous daughter feigned skirt modern truthful");
    }

    //  8 Ta reda på hur många ord i strängen som har en vokal som andra bokstav.
    public void Q8(){
        nOfOccurrences("\\b[a-z][aeiouy][a-z]*\\b","hands jumbled terrific old-fashioned grass highfalutin stupendous daughter feigned skirt modern truthful");
    }
    // 9 Ta reda på hur många gånger en bokstav förekommer dubbelt i strängen. Exempel: "ss", "oo", "pp". Gör detta i ett regex utan att skriva några bokstäver.
    public void Q9(){
        nOfOccurrences("([a-zA-Z])\\1", "hands jumbled terrific old-fashioned grass highfalutin stupendous daughter feigned skirt modern truthful");
        // Explanation: Find a letter, then check again (\\1 means "check this pattern again immediately after"
    }
    public void Q10(){
        // Nope

    }
    /*
    11 Ersätt alla förekomster av bokstäverna "l" och "o" med "1" och "0" i strängen.

    12 Ta reda på hur många ord det finns i strängen som består av 6 bokstäver.

    13 Ta reda på hur många ord det finns i strängen som inte innehåller varken "a" eller "e". Du kan förutsätta att orden är skrivna på engelska.

    14 Hitta första bokstaven i ord som kommer efter en punkt och gör om dessa till upper case. (Använd matcher.replaceAll(Function<MatchResult,String>)
     */
    public void Q11(){
        String word = "hands jumbled terrific old-fashioned grass highfalutin stupendous daughter feigned skirt modern truthful";
        String replacedFst = word.replace("l", "1");
        String replaceSnd = replacedFst.replace("o", "0");
        System.out.println(replaceSnd);
    }
    public void Q12(){
        nOfOccurrences("\\b\\[a-z][A-Z]\\b", "hands jumbled terrific old-fashioned grass highfalutin stupendous daughter feigned skirt modern truthful");
    }

    public void Q13(){
        nOfOccurrences("\\b[a-zA-Z&&[^aeAE]]+\\b", "hands jumbled terrific old-fashioned grass highfalutin stupendous daughter feigned skirt modern truthful");
    }

    public void Q14(){
        String word = "hands jumbled terrific old-fashioned grass highfalutin. stupendous daughter feigned. skirt modern truthful";
        Pattern pattern = Pattern.compile("\\.\\s([a-z])"); // Capture the letter. We have a group consisting of one letter for each match
        Matcher matcher = pattern.matcher(word);
        String result = matcher.replaceAll(m -> ". " + m.group(1).toUpperCase());
        System.out.println(result);
    }
}
