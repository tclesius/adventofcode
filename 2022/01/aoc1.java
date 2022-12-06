import java.io.File;
import java.util.*;

class aoc1 {

    private static int blockSum = 0;
    static int[] blocks = {};

    aoc1(String inputFilePath){try {readFile(inputFilePath);} catch (Exception e){};}

    private void readFile(String path) throws Exception{
        File file = new File(path);
        Scanner sc = new Scanner(file);

        while(sc.hasNextLine()){
            String line = sc.nextLine();
            if(line == ""){
                int[] buffer = new int[blocks.length + 1];
                System.arraycopy(blocks,0,buffer,0,blocks.length);
                blocks = buffer;
                blocks[blocks.length - 1] = blockSum;
                blockSum = 0;
                continue;
            }
            blockSum += Integer.parseInt(line);
        }
    }



	public static void main(String[] args)throws Exception
	{
        aoc1 aoc  = new aoc1("D:\\dev\\adventofcode\\2022\\01\\input.txt");
        int max = Integer.MIN_VALUE;
        int maxIndex = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int maxIndex2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        for(int i = 0; i < aoc.blocks.length; i++){
            if (max < aoc.blocks[i]) {max = aoc.blocks[i]; maxIndex = i;}
        }
        for(int i = 0; i < aoc.blocks.length; i++){
            if (max2 < aoc.blocks[i] && i != maxIndex)  {max2 = aoc.blocks[i]; maxIndex2 = i;}
        }
        for(int i = 0; i < aoc.blocks.length; i++){
            if (max3 < aoc.blocks[i] && i != maxIndex && i != maxIndex2) max3 = aoc.blocks[i];
        }

        System.out.println(max); 
        System.out.println(max + max2 + max3);  
    }
}
