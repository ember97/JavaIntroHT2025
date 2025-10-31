package Week8;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Förklaring:
På många frågor finns flera lösningar. Dessa är förslag från klassen under övningen. En del fungerar, andra inte.
Jag har låtit alla vara kvar eftersom det kan vara bra att fundera på varför en del lösningar fungerar och inte andra.
 */


public class Week8 {
    public String firstText = "min katt har tre konkatenerade kanter";
    public String secondText = "hands jumbled terrific old-fashioned grass highfalutin stupendous daughter feigned skirt modern truthful";

    public void printAndCountMatches(String patternString, String text){
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);

        int n = 0;

        while(matcher.find()){
            System.out.println(matcher.group());
            n++;
        }

        System.out.println("Number of occurrences: " + n);
    }

    // 1 Skriv ett regex-mönster som testar om ordet strängen "kat" förekommer i strängen "min katt har tre konkatenerade kanter"
    //Skriv ut svaret på konsolen.
    public void Q1(){
        Pattern pattern = Pattern.compile("kat");
        Matcher matcher = pattern.matcher(firstText);
        boolean exists = matcher.find();

        System.out.println(exists);
    }

    // 2 Skriv ett pattern som tar reda på hur många gånger orden "kat", "kan" och "kon" förekommer i samma sträng som uppgift 1
    //Loopa sedan igenom matchningarna och skriv ut varje sökträff på konsolen.
    public void Q2(){
        String patternText = "kat|kan|kon";
        printAndCountMatches(patternText, firstText);

    }

    //3 Skriv ett pattern som tar reda på hur många gånger bokstaven "a" med valfri bokstav efter förekommer i strängen
    //Skriv ut varje sökträff på konsolen.
    public void Q3(){
        String patternText = "a[a-z]";
        String patternText2 = "a.";
        printAndCountMatches(patternText, firstText);
        printAndCountMatches(patternText2, firstText);


    }
    // 4 Skriv ett pattern som tar reda på hur många gånger bokstaven "t" förekommer i strängen,
    //omgiven av tecken som inte är t.
    public void Q4(){
        String patternText = "(?<!t)t(?!t)";
        String patternText2 = "[^t]t[^t]";
        printAndCountMatches(patternText, firstText);
        printAndCountMatches(patternText2, firstText);
    }

    //5 Skriv ett pattern som tar reda på hur många gånger bokstaven "a"
    // följs av "s", eller "o" följs av "d" i strängen.
    public void Q5(){
        printAndCountMatches("as|od", secondText);
        printAndCountMatches("a[s]|o[d]", secondText);
    }

    // 6 Skriv ett pattern som tar reda på hur många gånger
    // bokstäverna "a" eller "e" följs av "n", "d" eller "s" i strängen.
    public void Q6(){
        printAndCountMatches("[ae][nds]", secondText);
        printAndCountMatches("(a|e)(n|d|s)", secondText);

        /*
        [ae][nds] → kort, snabbt, perfekt för enkla mönster.
        (a|e)(n|d|s) → mer flexibel, behövs om du vill referera till grupper i koden eller matcha längre mönster.
         */
    }

    // 7 Skriv ett pattern som tar reda på hur många ord i strängen som börjar med "d" eller "h"
    //Sedan ett nytt pattern för hur många ord som slutar med "s".
    public void Q7(){
        printAndCountMatches("\\b[dh]\\w*", secondText);
        printAndCountMatches("\\w*s\\b", secondText);

        // Suggestions:
        // \\s(d|h)         s\\s
        // \\b[dh]\\w*      \\w*s\\b
        // \\b[dh]\\w*
        // "\\b[dh]\\w*";
    }

    /*
    8 Ta reda på hur många ord i strängen som har en vokal som andra bokstav.
     */
    public void Q8(){
        printAndCountMatches("\\b\\w[aeiouy]\\w*", secondText);
        printAndCountMatches("\\b[a-z][aeiouy][a-z]*\\b", secondText);
        printAndCountMatches("\\b.[aeiouyäöå]", secondText);
        printAndCountMatches("\\b\\w{1}?[aeiouy]\\w*", secondText);
    }

    // 9 Ta reda på hur många gånger en bokstav förekommer dubbelt i strängen
    //Exempel: "ss", "oo", "pp"
    //Gör detta i ett regex utan att skriva några bokstäver.
    public void Q9(){
        printAndCountMatches("(.)\\1", secondText);
        printAndCountMatches("([a-zA-Z])\\1", secondText);
    }

    // 10 Ta reda på om det finns några kombinationer av tre bokstäver som förekommer flera gånger i strängen.
    public void Q10(){

        Pattern p1 = Pattern.compile("(\\w{3}).*?\1");
        Matcher m1 = p1.matcher(secondText);
        System.out.println(m1.find());

        // Suggestion 1
        Pattern p = Pattern.compile("\\b([a-zA-Z]{3})\\b(?=.*\\b\\1\\b)");


        // Suggestion 2
        Pattern pattern = Pattern.compile("(?=([a-zA-z]{3}))");
        Matcher matcher = pattern.matcher("hands jumbled terrific. old-fashioned grass highfalutin stupendous. daughter feigned, skirt modern truthful");

        Map<String, Integer> map = new HashMap<>();

        while(matcher.find()){
            String triplet = matcher.group(1).toLowerCase();
            map.put(triplet, map.getOrDefault(triplet, 0) + 1);
        }
        int count = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() > 1){
                System.out.println("Triplet: " + entry.getKey() + " occur: " + entry.getValue() + " times");
                count++;
            }
        }
        System.out.println("Antal tripletter som förekommer flera gånger är: " + count);
    }
    // 11 Ersätt alla förekomster av bokstäverna "l" och "o" med "1" och "0" i strängen.
    public void Q11(){
        String str1 = secondText.replace("l", "1");
        String finalProduct = str1.replace("o","0");
        System.out.println(finalProduct);

        // Example of replaceAll
        String replaceFive = secondText.replaceAll("\\b[a-z]{5}\\b", "5");
        System.out.println(replaceFive);
    }

    // 12 Ta reda på hur många ord det finns i strängen som består av 6 bokstäver.
    public void Q12(){
        printAndCountMatches("\\b\\w{6}\\b", secondText);
        printAndCountMatches("\\b[a-zA-Z]{6}\\b", secondText);
    }

    // 13 Ta reda på hur många ord det finns i strängen som inte innehåller varken "a" eller "e"
    //    Du kan förutsätta att orden är skrivna på engelska.
    public void Q13(){
        printAndCountMatches("[^ae]", secondText);
        printAndCountMatches("\\b[a-z&&[^ae]]+\\b", secondText);

        // Other solution:
        Pattern pattern = Pattern.compile("\\b[^ae\\s]+\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(secondText);

        int n = 0;

        while(matcher.find()){
            System.out.println(matcher.group());
            n++;
        }

        System.out.println("Number of occurrences: " + n);
    }
    /*
    14 Hitta första bokstaven i ord som kommer efter en punkt och gör om dessa till upper case
    (Använd matcher.replaceAll(Function<MatchResult,String>)
        */
    public void Q14(){
        String textWithDots = "hands jumbled terrific old-fashioned grass. highfalutin stupendous daughter. feigned skirt modern truthful";
        Pattern p = Pattern.compile("(?<=\\.)\\s*([a-z])");

        Pattern pattern = Pattern.compile("\\.\\s([a-z])"); // Capture the letter. We have a group consisting of one letter for each match
        Matcher matcher = pattern.matcher(textWithDots);
        String result = matcher.replaceAll(m -> ". " + m.group(1).toUpperCase()); // Each match has a group consisting of the letter
        System.out.println(result);

        // Match 1: ". highfalutin"  -> group(1): highfalutin
        // Match 2: ". feigned"      -> group(1): feigned
    }
}
