package hello;

import  java.io.*;
import java.util.Map;
import java.util.HashMap;

public class WordCountUtil  {

    private static final String fileName = "/Users/shrish/file"; 
    private static WordCountUtil instance = null;
    private static Map<String,Integer> wordsMap = null;    
    private WordCountUtil() throws IOException {
        wordsMap = new HashMap<String,Integer>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        
        String line = null; 
        
        while ((line = reader.readLine()) != null) {
            String [] words = line.split(",");
            
            for(String word : words) {
                Integer value = wordsMap.get(word);

                if(value != null) {
                    wordsMap.put(word,value + 1);
                } else {
                    wordsMap.put(word , 1);
                }
            }
        }
    }

    public static WordCountUtil getInstance() throws IOException{
        if(instance == null) {
            instance = new WordCountUtil();
        }
        return instance;
    }
    public static Count count(String query) throws IOException {

        Integer  value = wordsMap.get(query);
        if(value != null)
            return new Count( value.toString() );
        else
            return new Count("0");
    }
}
