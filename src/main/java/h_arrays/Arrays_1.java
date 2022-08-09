package h_arrays;

public class Arrays_1 {
    public static void main(String[] args) {
        int[][] arr=new int[3][];
        arr[0]=new int[3];
        arr[1]=new int[2];
        arr[2]=new int[1];

        for(int i=0;i<arr.length;i++){
            for(int k=0;k<arr[i].length;k++){
                arr[i][k]=i+k;
            }
        }

        for(int[] elems:arr){
            for(int i=0;i<elems.length;i++){
                System.out.println(elems[i]);
            }
        }
    }
}
