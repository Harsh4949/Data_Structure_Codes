package Array_quetions;

public class rotatedarry_Search{
  
    public static int rotatedarry_Search(int numarry[],int target){

        int left=0,right=numarry.length-1;              //{4,5,6,7,0,1,2}

        while(left<=right){
            
            int mid=(left+right)/2;

            if(numarry[mid]==target){
                return mid;
            }

            if(numarry[left]<=numarry[mid]){

                if(target<numarry[mid]&&numarry[left]<=target){

                    right=mid-1;
                }else{
                    left=mid+1;
                }

            }else{
                
                if(target>numarry[mid]&&target<=numarry[right]){

                    left=mid+1;
                }else{

                    right=mid-1;
                }
            }
        }

        return -1;

    }

    public static void main(String args[]){

      
        int numbers[]={4,5,6,7,0,1,2};

        System.out.println(rotatedarry_Search(numbers,0));

    }
}
//first write binary shearch as it is then make chages on it;
//first find the sorted arry between two arry see witch arry is sorted with mid 
//then applay binary sherch on it if the target lies between mid and other end it may left or right.
//increse left or right.