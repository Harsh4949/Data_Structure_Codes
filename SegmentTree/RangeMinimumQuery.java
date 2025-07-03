import java.util.*;

public class RangeMinimumQuery {
  
    public static int stree[];
    public static int n=0;
    
    public static void print(int[] args) {
        
        for (int string : args) {
            System.out.print(" "+string);
        }
        System.out.println();
    }
    
    public static void init(int nums[])
    {
      
      n=nums.length;
      stree= new int[4*n];
      
      buildMINST(nums,0,n-1,0);
    }
    
  
    public static int buildMINST(int nums[],int st,int end,int i)
    {
      
      if (st==end){ 
      
        stree[i]=nums[st];
        return nums[st];
      }
      
      int mid=(st+end)/2;
      int left=buildMINST(nums,st,mid,2*i+1);
      int right=buildMINST(nums,mid+1,end,2*i+2);
      
      
      return stree[i]=Math.min(left,right);
      
    }
    
    public static int MinQuery(int si,int sj,int i, int qi,int qj)
    {
      
      if(si<qi ||qj<sj){
        
        return Integer.MAX_VALUE;
      }
      else if (si>=qi && sj<=qj)  {
        return stree[i];
        
      } else{
        
        
        int mid=(si+sj)/2;
        int left=MinQuery(si,mid,2*i+1,qi,qj);
        int right=MinQuery(mid+1,sj,2*i+1,qi,qj);
        
        return Math.min(left,right);
        
      }
      
      
    }

    public static void updateST(int si,int sj,int i, int newval,int idx){
      
      if(idx<si || idx>sj){
        
        return;
      }
      
      if(si==sj){
        stree[i]=Math.min(stree[i],newval);
        return;
      }
      
      int mid=(si+sj)/2;
      updateST(si,mid,2*i+1,newval,idx);
      updateST(mid+1,sj,2*i+2,newval,idx);
      
      stree[i]=Math.min(stree[i],newval);
      
    }
    
  
    public static void main(String[] args) {
      
      int arr[]={6,8,-1,2,17,1,3,2,4};

        init(arr);
        
        print(arr);
        print(stree);
        
        updateST(0,n-1,0,-10,2);
        print(stree);
        
        
      

  }
}