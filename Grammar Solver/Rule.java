import java.util.Random;

public class Rule {
    public String[] translationArray;
    public Random rng = new Random();

    public Rule(String ruleString){
        translationArray = ruleString.split("[|]");
        //removeWhiteSpace();
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
    private void removeWhiteSpace(){
        for(String Trans: translationArray){
            System.out.println("before" + Trans);
            Trans = Trans.replaceAll(" ", "");
            System.out.println("after" + Trans);

        }
    }
}
