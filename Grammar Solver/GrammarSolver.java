import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class GrammarSolver {


    public Map<String, Rule > rules = new TreeMap<String, Rule>();

    public GrammarSolver(List<String> grammar){
        for (String string : grammar) {
            String[] ruleParts = string.split(":");
            rules.put(ruleParts[0], new Rule(ruleParts[1]));
            
        }

    }

    public boolean grammarContains(String symbol){
        return rules.keySet().contains(symbol);
    }
   
    public String[] generate(String symbol, int times){
        String[] output = new String[times];
        for(int i=0; i<times; i++){
            String generatedString = symbol;
            while(true){
                for(String nonTerminal:rules.keySet()){
                    if(generatedString.contains(nonTerminal))
                        generatedString = generatedString.replaceAll(nonTerminal, rules.get(nonTerminal.getRandomTranslation()));
                }
                

            }

            output[i] = generatedString;

        }
        return output;
    }

    public String getSymbols(){
        String symbols = "[";
        for(String key:rules.keySet()){
            symbols += key + ",";
        }

        return symbols.substring(0,symbols.length()-1)+ "]";

    }
    public String toString(){
        String output = "grammar rules\n";
        for(Map.Entry<String, Rule> entry:rules.entrySet()){
            output += entry.getKey() + " \t || " + entry.getValue() + "\n";
        }
        return output;
    }
    public static void main(String[] args) throws FileNotFoundException{
        Scanner input = new Scanner(new File("sentence.txt"));

        // read the grammar file and construct the grammar solver
        List<String> grammar = new ArrayList<String>();
        while (input.hasNextLine())
            grammar.add(input.nextLine());
        GrammarSolver gs = new GrammarSolver(grammar);
        System.out.println(gs);
        System.out.println(gs.getSymbols());
        System.out.println(gs.grammarContains("<adj>"));
        System.out.println(gs.grammarContains("<iwejfkjwe>"));

        
    }
}

