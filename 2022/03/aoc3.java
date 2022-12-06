import java.io.File;
import java.util.*;

class aoc3{
    static String encoding = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    

    static boolean all(boolean [] array){
        for(boolean b : array) if(!b) return false;
        return true;
    }


    static String commonChars(String... groups){
        String commonChars = "";


        for (char c : encoding.toCharArray()){
            boolean commonCharTest[] = new boolean[groups.length];
            for (int i = 0; i < groups.length; i++){
                commonCharTest[i] = groups[i].indexOf(c) < 0 ? false : true;
            }

            if (all(commonCharTest)) commonChars += c;
        }
        return commonChars;
    }



    static int solution1() throws Exception{
        File file = new File("D:\\dev\\adventofcode\\2022\\03\\input.txt");
        Scanner sc = new Scanner(file);
        int sum = 0;
        while(sc.hasNextLine()){    
            String s = sc.nextLine();
            String common = commonChars(s.substring(0,s.length()/2),s.substring(s.length()/2,s.length()));
            for(char c : common.toCharArray()){
                sum += encoding.indexOf(c);
            }
        }
        return sum;
    }

    static int solution2()throws Exception{
        File file = new File("D:\\dev\\adventofcode\\2022\\03\\input.txt");
        Scanner sc = new Scanner(file);
        Set<Character> commonChars = new LinkedHashSet<>();
        int sum = 0;
        while(sc.hasNextLine()){    
            String lines = "";
            
            for(int i = 0; i < 3; i++){
                lines += sc.nextLine() + " ";
            }

            String [] linesArr = lines.split(" ");
            
            String common = commonChars(linesArr);
            for(char c : common.toCharArray()){
                sum += encoding.indexOf(c);
            }
        }


        return sum;
    }
    
    public static void main(String[] args)throws Exception{
        System.out.println(solution1());
        System.out.println(solution2());
    }
}