import java.io.File;
import java.util.*;

class aoc3{
    static String encoding = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    static int solution1() throws Exception{
        File file = new File("D:\\dev\\adventofcode\\2022\\03\\input.txt");
        Scanner sc = new Scanner(file);
        int sum = 0;
        while(sc.hasNextLine()){    
            char[] line = sc.nextLine().toCharArray();
            ArrayList<Character> lhs = new ArrayList<Character>();
            ArrayList<Character> rhs = new ArrayList<Character>();


            for(int i = 0; i<line.length/2; i++){
                lhs.add(line[i]);
            }
            for(int i = line.length/2; i<line.length; i++){
                rhs.add(line[i]);
            }           

            lhs.retainAll(rhs);
            sum += encoding.indexOf(lhs.get(0));
        }
        return sum;
    }
    
    public static void main(String[] args)throws Exception{
        System.out.println(solution1());
    }
}