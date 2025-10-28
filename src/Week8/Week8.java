package Week8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public void Q1(){

    }
    public void Q2(){

    }
    public void Q3(){

    }
    public void Q4(){

    }
    public void Q5(){

    }
    public void Q6(){

    }
    public void Q7(){

    }
    public void Q8(){

    }

    // TODO: Quiz time :)
    public void Q9(){

    }
    public void Q10(){

    }
    public void Q11(){

    }
    public void Q12(){

    }
    public void Q13(){

    }

    public void Q14(){

    }
}
