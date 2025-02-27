package ArrayList;

import java.util.ArrayList;

public class MostFreqNumKey {

    public static int mostFrequentNum(ArrayList list,int key){  //this method done using frequency array;

        int []arr=new int[1001];

        for(int i=0;i<list.size()-1;i++ ){

            if ((int)list.get(i)==key) {
                
                arr[(int)list.get(i+1)]++;
            }
        }

        int mxin=Integer.MIN_VALUE;
        int mxno=Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            //0<2
            if(mxno<arr[i]){
                
                mxno=arr[i];
                mxin=i;
            }
           
        }

        return mxin;
    }

    public static int mostFrequentNum2(ArrayList list,int key){     //optimim

        int count=0;
        int maxno=0;
        for(int i=0;i<list.size()-1;i++ ){

            if ((int)list.get(i)==key) {
            
                if (count==0) {
                    maxno=(int)list.get(i+1);
                }

                if ((int)list.get(i)==maxno) {
                    count++;
                }else
                     count--;
            }
        }
        return maxno;
    }
    
    public static void main(String[] args) {
        
        ArrayList<Integer> nums =new ArrayList<>();


        nums.add(1); //nums = [1,100,200,1,100], key = 1
        nums.add(100);
        nums.add(200);
        nums.add(1);
        nums.add(100);

        System.out.println(mostFrequentNum(nums, 1));
        System.out.println(mostFrequentNum2(nums, 1));
    }
}
