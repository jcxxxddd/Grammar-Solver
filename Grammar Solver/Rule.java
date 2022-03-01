import java.util.Random;

public class Rule {
    public String[] translationArray;
    public Random rng = new Random();

    public Rule(String ruleString){
        translationArray = ruleString.split("[|]");
    }

    public String toString(){
        String output = " ";
        for(String translation:translationArray){
            output += translation + ",";
        }
        return output;
    }

    public String getRandomTranslation(){
        return translationArray[rng.nextInt(translationArray.length)];
    }
}
