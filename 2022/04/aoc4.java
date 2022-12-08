import java.io.File;
import java.util.Scanner;

class aoc4{
    static Scanner input(String filePath)throws Exception{
        File file = new File(filePath);
        return new Scanner(file);
    }

    static int solution1() throws Exception{
        Scanner in = input("D:\\dev\\adventofcode\\2022\\04\\input.txt");
        int count = 0;
        while(in.hasNextLine()){
            //>-->      
            String[] assignments = in.nextLine().split(",");


            int first = Integer.parseInt(assignments[0].split("-")[0]);
            int second = Integer.parseInt(assignments[0].split("-")[1]);
            int third = Integer.parseInt(assignments[1].split("-")[0]);
            int fourth = Integer.parseInt(assignments[1].split("-")[1]);

            if (first >= third && second <= fourth || second >= fourth && first <= third) count++;
        }
        
        return count;
    }
    
    static int solution2() throws Exception {
        Scanner in = input("D:\\dev\\adventofcode\\2022\\04\\input.txt");
        int count = 0;
        while(in.hasNextLine()){
            //>-->      
            String[] assignments = in.nextLine().split(",");


            int first = Integer.parseInt(assignments[0].split("-")[0]);
            int second = Integer.parseInt(assignments[0].split("-")[1]);
            int third = Integer.parseInt(assignments[1].split("-")[0]);
            int fourth = Integer.parseInt(assignments[1].split("-")[1]);

            if (first <= third && third <= second || first <= fourth && fourth <= second || third <= first && first <= fourth || third <= second && second <= fourth) count++;
        }
        
        return count;
    }
    public static void main(String[] args) throws Exception{
        System.out.println(solution1());
        System.out.println(solution2());
    } 
}


