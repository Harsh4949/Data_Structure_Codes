package Array_quetions;
public class Traping_rainwater{

    public static void trapped_water_calculate(int numarry[]) {

        int leftMaxBoundry[]=new int[numarry.length];
        int rightMaxBoundry[]=new int[numarry.length];
        int trapWater=0;

        leftMaxBoundry[0]=numarry[0];

        for(int i=1;i<numarry.length;i++){
            
            leftMaxBoundry[i]=Math.max(numarry[i],leftMaxBoundry[i-1]);
        }

        rightMaxBoundry[numarry.length-1]=numarry[numarry.length-1];

        for(int j=numarry.length-2;j>=0;j--)
        {
            rightMaxBoundry[j]=Math.max(numarry[j],rightMaxBoundry[j+1]);
        }

        if(numarry.length>2){
            
            for(int i=0;i<numarry.length;i++){

                int waterleval=(int)Math.min(leftMaxBoundry[i],rightMaxBoundry[i]);
                trapWater+=(waterleval-numarry[i]);
            }
            System.out.println("traped water is :" +trapWater);
        }
        
    }

    public static void main(String args[]){

        int height[]={4,2,0,6,3,2,5};

        trapped_water_calculate(height);

    }
}

//steps to calculate taraped water quetion

// - calculate leftMaxBoundry arry i.e Math.max(height[i]- leftMaxBoundry[i-1])  Left --->Right Addition -sright loop
// - calculate rightMaxBoundry arry i.e Math.max(height[i]- leftMaxBoundry[i+1])  Left<--- Right Addition -reverse loop 
 
//-loop to evalute arry
//-waterleval=Math.min(leftMaxBoundry[i],rightMaxBoundry[i]);
//-calculate Traped Water=(waterleval-height[i])*width(if width is given);

//consider corner conditions length arry must be >2

//slove on pepar first*