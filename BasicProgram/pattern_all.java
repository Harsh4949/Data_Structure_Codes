package BasicProgram;
public class pattern_all{

    public static void hollow_Rectangle(int rows,int cols){

        for(int i=1;i<=rows;i++){
            for(int j=1;j<=cols;j++){

                if(i==1||i==rows||j==1||j==cols){
                    System.out.print("*");

                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void inverted_half_Pyramid(int n){

        for(int i=1;i<=n;i++){

            for(int j=1;j<n-i+1;j++){

                System.out.print(" ");
            }

            for(int k=1;k<=i;k++){

                System.out.print("*");
            }

            System.out.println();
        }
    }

    public static void inverted_half_Pyramid_numbers(int n){
    
        for(int i=1;i<=n;i++){

            for(int j=1;j<=n-i+1;j++){

                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void floyds_Triangle(int n){

        int k=1;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){

                System.out.print(k+" ");
                k++;
            }
            System.out.println();
        } 
    }

    public static void triangle_0_1(int n) {
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){

                if((i+j)%2==0){
                    System.out.print("1 ");
                }else{
                    System.out.print("0 ");
                }
            }

            System.out.println();
        }
    }

    public static void Butterfly (int n) {
        
        for(int i=1;i<=n;i++){     //first half
           
           
            for(int j=1;j<=i;j++){

                System.out.print("*");
            }

            for(int j=1;j<=(n-i)*2;j++){

                System.out.print(" ");
            }

            for(int j=1;j<=i;j++){

                System.out.print("*");
            }

            System.out.println();
        }

        for(int i=n;i>=1;i--){     //secend half
           
           
            for(int j=1;j<=i;j++){

                System.out.print("*");
            }

            for(int j=1;j<=(n-i)*2;j++){

                System.out.print(" ");
            }

            for(int j=1;j<=i;j++){

                System.out.print("*");
            }

            System.out.println();
        }

    }

    public static void rhombus(int n){

        for(int i=1;i<=n;i++){

            for(int j=1;j<=n-i+1;j++){

                System.out.print(" ");
            }

            for(int j=1;j<=n;j++){
                
                System.out.print("*");
            }

            System.out.println();
        }

    }

    public static void hollw_Rhombus(int n){

        for(int i=1;i<=n;i++){

            for(int j=1;j<=n-i+1;j++){

                System.out.print(" ");
            }

            for(int j=1;j<=n;j++){

                if(j==1||j==n||i==1||i==n)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }

            System.out.println();
        }

    }

    public static void diamond(int n) {
        
        for(int i=1;i<=n;i++){      //First Half

            for(int j=1;j<=n-i+1;j++){

                System.out.print(" ");
            }

            for(int j=1;j<=(i*2)-1;j++){

                System.out.print("*");
            }

            System.out.println();
        }

        for(int i=n;i>=1;i--){      //Secend Half

            for(int j=1;j<=n-i+1;j++){

                System.out.print(" ");
            }

            for(int j=1;j<=(i*2)-1;j++){

                System.out.print("*");
            }

            System.out.println();
        }

    }

    public static void cross(int n) {

        for(int i=1;i<=n;i++){

            for(int j=1;j<=n;j++){

                if(i==j||j+i==n+1 ){
                    System.out.print("*");

                }else{
                    System.out.print(" ");
                }
                    
            }

            System.out.println();
        }
        
    }

    public static void patern_1_allside(int n) {
        
        for(int i=1;i<=n;i++){

            int no=1;
            int nor=n;
            for(int j=1;j<=n-i+1;j++){
                System.out.print(" ");
            }
                
            for(int j=1;j<=i;j++){

                
                System.out.print(no++);
            }
            

           

            System.out.println();
        }
    }


    public static void main(String args[]){

        // hollow_Rectangle(5,10);
        // inverted_half_Pyramid(5);
        // inverted_half_Pyramid_numbers(5);
        // floyds_Triangle(5);
        // triangle_0_1(5);
        // Butterfly(4);
        // rhombus(10);
        // hollw_Rhombus(8);
        //diamond(4);
        //z cross(5);
       // patern_1_allside(6);
    }
  
}