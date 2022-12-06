import java.io.File;
import java.util.Scanner;
class aoc2{
    static int solution1() throws Exception {
        File file = new File("D:\\dev\\adventofcode\\2022\\02\\input.txt");
        Scanner sc = new Scanner(file);
        
        int score = 0;

        String playerEncoding = " XYZ";
        
        while(sc.hasNextLine()){    
            String play = sc.nextLine().replaceAll("\\s","");
            char[] plays = play.toCharArray();


            if(play.equals("BZ") | play.equals("AY") | play.equals("CX")){
                score += playerEncoding.indexOf(plays[1]) + 6;
            }
            else if(play.equals("AX") | play.equals("BY") | play.equals("CZ")){
                score += playerEncoding.indexOf(plays[1]) + 3;
            }else{
                score += playerEncoding.indexOf(plays[1]);
            }
        }
        return score;
    }

    static int solution2() throws Exception{
        File file = new File("D:\\dev\\adventofcode\\2022\\02\\input.txt");
        Scanner sc = new Scanner(file);
        String encoding = "ABC";
        int[] loosingPlays = {3,1,2};
        int[] winningPlays = {2,3,1};
        int score = 0;

        while(sc.hasNextLine()){    
            String play = sc.nextLine().replaceAll("\\s","");
            char[] plays = play.toCharArray();


            if(plays[1] == 'Z'){
                score += winningPlays[encoding.indexOf(plays[0])] + 6;
            }
            else if(plays[1] == 'Y'){
                score += encoding.indexOf(plays[0]) + 1 + 3;
            }else{
                score += loosingPlays[encoding.indexOf(plays[0])];
            }
        }
        return score;
    }


    public static void main(String[] args) throws Exception {
        System.out.println(solution1());
        System.out.println(solution2());
    }
}
