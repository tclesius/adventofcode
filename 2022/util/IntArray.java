public class IntArray{
    public int length; 
    private int [] data;

    IntArray(int[] data){
        this.data = data; 
        this.length = data.length;
    }
    IntArray(int length){
        this.data = new int [length]; 
        this.length = length;
    }
    IntArray(){
        this.data = new int [0]; 
        this.length = 0;
    }
    
    void append(int i){
        int[] buffer = new int[this.length + 1];
        System.arraycopy(data,0,buffer,0,this.length);
        buffer[this.length] = i;
        this.data = buffer;
        this.length = buffer.length;
    }
    void prepend(int i){
        int[] buffer = new int[this.length + 1];
        System.arraycopy(data,0,buffer,1,this.length);
        buffer[0] = i;
        this.data = buffer;
        this.length = buffer.length;
    }
    void remove(int index){
        assert 0 <= index  && index < length;
        
        int[] buffer;

        if (index > 0 && index < this.length){
            buffer = new int[this.length - 1];
            System.arraycopy(data,0,buffer,0,index);
            System.arraycopy(data,index,buffer,index,buffer.length-1);
        }
        if(this.length > 1) {
            buffer = new int[this.length - 1];
            System.arraycopy(data,index + 1,buffer,0,buffer.length-1);
        }else{
            if (index > this.length) this.get(index);
            buffer = new int[0];
        }
        this.data = buffer;
        this.length = buffer.length;
    }
    int get(int index){return this.data[index];}
    void set(int index, int value){this.data[index] = value;}
    
    @Override
    public String toString(){
        String result = "{ ";
        for (int i = 0; i < this.length; i++){
            result+= String.valueOf(this.data[i]) + ", ";
        }
        return result + "}";
    }

    public static void main(String[] args){
        IntArray array1 = new IntArray();

        for (int i = 0; i < 100; i++){
            array1.append(1);
        }


        System.out.println(array1);

    }
}