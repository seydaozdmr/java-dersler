package x_interview.algorithms;

public class Union {
    private int [] array;
    private int count;

    public Union(int N) {
        this.count=N;
        this.array = new int[N];
        for(int i=0;i<N;i++){
            array[i]=i;
        }
    }

    public int count(){
        return count;
    }

    public boolean connected(int p,int q){
        return find(p) == find(q);
    }

    private int find(int e){
        return array[e];
    }

    public void union(int p,int q){
        int pId= find(p);
        int qId= find(q);

        if(pId==qId)
            System.out.println("already connected");
        else{
            for(int i=0;i< array.length;i++){
                if(array[i] == pId)
                    array[i] = qId;
            }
        }
        count--;
    }

    public static void main(String[] args) {
        Union union=new Union(10);
        union.union(3,4);
        union.union(8,3);
        System.out.println(union.count);
    }
}
