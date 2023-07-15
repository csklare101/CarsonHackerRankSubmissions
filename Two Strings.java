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
     * Complete the 'twoStrings' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static String twoStrings(String s1, String s2) {
    // Write your code here
    Map<Character, Integer> s1map = new HashMap<Character, Integer>();
    Map<Character, Integer> s2map = new HashMap<Character, Integer>();
    
    for(int i = 0; i < s1.length(); i++){
        if(!s1map.containsKey(s1.charAt(i))){
            s1map.put(s1.charAt(i), 1);
        }
    }
    for(int j = 0; j < s2.length(); j++){
        if(!s2map.containsKey(s2.charAt(j))){
            s2map.put(s2.charAt(j), 1);
        }
        if(s1map.containsKey(s2.charAt(j))){
            return "YES";
        }
    }
    return "NO";
    
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s1 = bufferedReader.readLine();

                String s2 = bufferedReader.readLine();

                String result = Result.twoStrings(s1, s2);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
