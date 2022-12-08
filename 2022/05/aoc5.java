import java.io.File;
import java.util.*;

class aoc5{
    static Scanner input(String filePath)throws Exception{
        File file = new File(filePath);
        return new Scanner(file);
    }

    static List<List<String>> loadStacks(Scanner sc) throws Exception{
        boolean init = true;

        List<List<String>> stacks = new ArrayList<List<String>>();  

        while(sc.hasNextLine()){
            String nextLine = sc.nextLine();
            if (nextLine.equals("")) break;
            String[] rawSplitLine = nextLine.split("");
            
            if (init == true) {
                init = false;
                for (int i = 0; i < (rawSplitLine.length / 4)+1; i++) {
                    stacks.add(new ArrayList<String>((rawSplitLine.length / 4)+1));
                }
            }
            
            for (int i = 0; i < (rawSplitLine.length / 4)+1; i++){
                stacks.get(i).add(rawSplitLine[1+i*4]);
            }
            
        }
        stacks.forEach((l)-> l.removeIf((e) -> e.trim().isEmpty()));
        return stacks;
    }

    static String solution1() throws Exception{
        Scanner sc = input("D:\\dev\\adventofcode\\2022\\05\\input.txt");
        String result = "";
        List<List<String>> stacks = loadStacks(sc);
        
        // parse instructions
        while(sc.hasNextLine()){
            String nextLine = sc.nextLine();
            Scanner line = new Scanner(nextLine);
            
            int amount = -1;
            int from = -1;
            int to = -1;

            while(line.hasNext()){
                String nextToken = line.next();

                if (nextToken.equals("move")){
                    amount = Integer.parseInt(line.next());
                }
                if (nextToken.equals("from")){
                    from = Integer.parseInt(line.next());
                }
                if (nextToken.equals("to")){
                    to = Integer.parseInt(line.next());
                }
            }
            line.close();
            
            List<String> copy = stacks.get(from-1).subList(0, amount);
            Collections.reverse(copy);
            stacks.get(to-1).addAll(0, copy);
            stacks.get(from-1).subList(0, amount).clear();
        }

        for (int i = 0; i < stacks.size(); i++) {
            result += stacks.get(i).get(0);
        }
        return result;
    }
    
    static String solution2() throws Exception {
        Scanner sc = input("D:\\dev\\adventofcode\\2022\\05\\input.txt");
        String result = "";
        List<List<String>> stacks = loadStacks(sc);
        
        // parse instructions
        while(sc.hasNextLine()){
            String nextLine = sc.nextLine();
            Scanner line = new Scanner(nextLine);
            
            int amount = -1;
            int from = -1;
            int to = -1;

            while(line.hasNext()){
                String nextToken = line.next();

                if (nextToken.equals("move")){
                    amount = Integer.parseInt(line.next());
                }
                if (nextToken.equals("from")){
                    from = Integer.parseInt(line.next());
                }
                if (nextToken.equals("to")){
                    to = Integer.parseInt(line.next());
                }
            }
            line.close();
            
            List<String> copy = stacks.get(from-1).subList(0, amount);
            stacks.get(to-1).addAll(0, copy);
            stacks.get(from-1).subList(0, amount).clear();
        }
        for (int i = 0; i < stacks.size(); i++) {
            result += stacks.get(i).get(0);
        }
        return result;
    }
    public static void main(String[] args) throws Exception{
        System.out.println(solution1());
        System.out.println(solution2());
    } 
}


