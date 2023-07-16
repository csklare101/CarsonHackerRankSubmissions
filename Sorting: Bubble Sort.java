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
     * Complete the 'countSwaps' function below.
     *
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static void countSwaps(List<Integer> a) {
    // Write your code here
    int swaps = 0;
    int first = a.get(0);
    int last = a.get(a.size()-1);
    
        for(int i = 0; i < a.size(); i++){
            for(int j = 0; j < a.size()-1; j++){
                if(a.get(j) > a.get(j+1)){
                    swaps++;
                    if(a.get(j) > last){
                        last = a.get(j);
                    }
                    if(a.get(j+1) < first){
                        first = a.get(j+1);
                    }
                    Collections.swap(a, j, j+1);
                }
            }
        }
    System.out.println("Array is sorted in " + swaps + " swaps.");
    System.out.println("First Element: " + first);
    System.out.println("Last Element: " + last);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.countSwaps(a);

        bufferedReader.close();
    }
}
