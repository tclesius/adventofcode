import java.io.IOException;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
class aoc6 {

    static int solution1() throws IOException{
        Scanner scanner = new Scanner(new File("D:\\dev\\adventofcode\\2022\\06\\input.txt")).useDelimiter("\\Z");
        String input = scanner.next();

        for (int i = 0; i < input.length() - 4; i++) {
            String sequence = input.substring(i, i + 4);
            if(sequence.chars().filter(e-> Collections.frequency(sequence.chars().boxed().collect(Collectors.toList()), e) > 1).count() == 0){
                return i+4;  
            }
        }
        
        return -1;
    }
    static int solution2() throws IOException{
        Scanner scanner = new Scanner(new File("D:\\dev\\adventofcode\\2022\\06\\input.txt")).useDelimiter("\\Z");
        String input = scanner.next();

        for (int i = 0; i < input.length() - 14; i++) {
            String sequence = input.substring(i, i + 14);
            if(sequence.chars().filter(e-> Collections.frequency(sequence.chars().boxed().collect(Collectors.toList()), e) > 1).count() == 0){
                return i+14;  
            }
        }
        
        return -1;
    }

    public static void main(String[] args) throws IOException{
        System.out.println(solution1());
        System.out.println(solution2());
    }
}
