import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'checkMagazine' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY magazine
     *  2. STRING_ARRAY note
     */

    public static void checkMagazine(List<String> magazine, List<String> note) {
    // Write your code here
    HashMap<String, Integer> noteMap = new HashMap<String, Integer>();
        for(String word: note){
            if(noteMap.containsKey(word)){
                noteMap.put(word, noteMap.get(word)+1);
            }
            else{
                noteMap.put(word, 1);
            }
        }
        
    HashMap<String, Integer> magMap = new HashMap<String, Integer>();
        for(String w : magazine){
            if(noteMap.containsKey(w)){
                if(magMap.containsKey(w)){
                    if(!magMap.get(w).equals(noteMap.get(w))){
                        magMap.put(w, magMap.get(w)+1);
                    }
                }
                else{
                    magMap.put(w, 1);
                }
            }
        }
        
    if(noteMap.equals(magMap)){
        System.out.println("Yes");
    }
    else{
        System.out.println("No");
    }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .collect(toList());

        List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .collect(toList());

        Result.checkMagazine(magazine, note);

        bufferedReader.close();
    }
}
