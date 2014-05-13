package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import  java.io.*;
@Controller
public class CountController  {

    private static final String fileName = "/Users/shrish/file"; 
    @RequestMapping("/count")
    public @ResponseBody Count count(
            @RequestParam(value="query", required=false, defaultValue="") String query) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        
        String line = null; 
        String result = "";
        int count = 0;
        if(!query.equals("")) {
            while ((line = reader.readLine()) != null) {
                String [] words = line.split(",");
            
                for(String word : words) {
                    if(word.equalsIgnoreCase(query))
                        ++count;
                }
            }
        }
        return new Count( String.valueOf(count) );
    }
}
