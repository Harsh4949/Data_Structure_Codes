package Recursion;


public class RecursionBaiscPrograms {
    

  public static void printNummberDecresingOrder(int no){

      if(no==1){
        System.out.print(" "+no);
        return;
      }

      System.out.print(" "+no);
      printNummberDecresingOrder(no-1);
  } 

  public static void printNummberIncresingOrder(int no){

    if(no==1){
      System.out.print(" "+no);
      return;
    }

    printNummberIncresingOrder(no-1);
    System.out.print(" "+no);
    
  }

  public static int fact(int n) {
    
    if(n==0)
      return 1;
    return (n*fact(n-1));

    //5*fact(4) = 120
    //4*fact(3) = 24 
    //3*fact(2) = 6
    //2*fact(1) = 2
    //1*fact(0) = 1 
  }

  public static int SumofnaturlNums(int n) {
    
    if (n==1) 
      return 1;

     return (n+SumofnaturlNums(n-1)); 

     //5+SumofnaturlNums(4) = 15
    //4+SumofnaturlNums(3) = 10 
    //3+SumofnaturlNums(2) = 6
    //2+SumofnaturlNums(1) = 3
  }

  public static int fibonacciSeries(int n) {    // for understanding call tree forms
   
    if(n==0||n==1)
      return n;

      //System.out.println(n);
      return fibonacciSeries(n-1)+fibonacciSeries(n-2);
  }

  public static boolean checkArrayIsSorted(int[] args,int i ) {
  
     if(i==args.length-1)
          return true;

      if(args[i]<args[i+1])
          return checkArrayIsSorted(args, i+1);

    return false;
  }

  public static int firstOccurenceElementIndex(int [] args,int key,int i) {

    if(i==args.length-1)
          return -1;

    if(args[i]==key)
          return i;

    return firstOccurenceElementIndex(args, key, i+1);
  }

  public static int lastOccurenceElementIndex(int [] args,int key,int i) {

    if(i==0 && args[0]!=key ){
      return -1;
    }
          

    if(args[i]==key)
          return i;

    return lastOccurenceElementIndex(args, key, i-1);
  }

  public static void allOccurenceElementIndex(int[] args,int key,int idx) {
    
    if(idx==args.length-1)
      return;

    if (args[idx]==key) {
      System.out.print(" "+idx);
    }  

    allOccurenceElementIndex(args, key, idx+1);
    
  }

  public static int powerOfN(int n,int power) {   //O(n)

    if(power==0)
       return 1;

    return (n*powerOfN(n, power-1));

    //2* powerOfN(3)= 8
    //2* powerOfN(2)= 4
    //2* powerOfN(1)= 2
    //2* powerOfN(0)= 2
  }

  public static int optimizedPowerOfN(int n, int power) {  //O(log n)
    
    if(power==0)
        return 1;

    int halfPow=optimizedPowerOfN(n, power/2);
    
    if (power%2==0) 
      return halfPow*halfPow;

    return n*halfPow*halfPow;  
  }

  public static void printNums(int no) {

    String wNum[]={"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    
    if (no==0) 
      return;

    int lastDigit = no%10;
    printNums(no/10);
    System.out.println(wNum[lastDigit]);
    
  }

  public static void printConsecativeSubString(String str,int l,int r) {
    
    if(l==r)
    {
      System.out.print(" "+str.charAt(r)+"\n");
      return;
    }
    
    System.out.print(" "+str.charAt(l));
    printConsecativeSubString(str, l+1, r);
    
    
    printConsecativeSubString(str, l, r-1);
    System.out.print(" "+str.charAt(r));
   
  }

  public static void main(String[] args) {

    int []arry={10,20,30,40, 30, 54};
        
      // printNummberDecresingOrder(10);
      // System.out.println();
      // printNummberIncresingOrder(10);

      // System.out.println("\n "+fact(5));
      // System.out.println(" "+SumofnaturlNums(5));

      // System.out.println( fibonacciSeries(5));
      // System.out.println( fibonacciSeries(4));
      // System.out.println( fibonacciSeries(3));
      // System.out.println( fibonacciSeries(2));
      // System.out.println( fibonacciSeries(1));

      // System.out.println(checkArrayIsSorted(arry,0));

      //allOccurenceElementIndex(arry, 30, 0);
     // System.out.println(firstOccurenceElementIndex(arry,30, 0));
      // System.out.println(lastOccurenceElementIndex(arry,40, arry.length-1));

      // System.out.println(powerOfN(2,10));
      // System.out.println(optimizedPowerOfN(2,10));

      // printNums(1234);

      printConsecativeSubString("abc", 0, "abc".length()-1);


  }

}
