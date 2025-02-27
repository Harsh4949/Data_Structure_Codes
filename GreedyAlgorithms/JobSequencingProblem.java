package GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class JobSequencingProblem {
    
    static class job {
    
        int deadline;
        int profit;
        int id;

        public job(int id,int deadline,int profit){

            this.deadline=deadline;
            this.id=id;
           this.profit=profit; 
        }
    }

    public static void usingClassApproch(int[][]jobInfo){

        ArrayList<job> jobs=new ArrayList<>();
        ArrayList<Integer> seq=new ArrayList<>();

        for (int i = 0; i < jobInfo.length; i++) {

            jobs.add(new job(i,jobInfo[i][0],jobInfo[i][1]));
        }

        Collections.sort(jobs,(obj1,obj2)->obj2.profit-obj1.profit); // syntax to sort the object aary

        int time=0;

        for (int i = 0; i < jobInfo.length; i++) {
            
            job cur=jobs.get(i);

            if (cur.deadline>time) {
                
                seq.add(cur.id);
                time+=cur.deadline;
            }
        }

        for (Integer integer : seq) 
            System.out.print(" "+integer);

        System.out.println();

    }

    public static void findJobSeq(int[][]jobInfo) {
        
        int sortedJobInfo[][]=new int[jobInfo.length][3];

        for (int i = 0; i < jobInfo.length; i++) {

            sortedJobInfo[i][0]=i;          // Job Id
            sortedJobInfo[i][1]=jobInfo[i][0];      //0= deadline
            sortedJobInfo[i][2]=jobInfo[i][1];     //1= profit
        }
        
   
       // Arrays.sort(sortedJobInfo,Comparator.comparingInt(o->o[2])); // sort in asending order

        Arrays.sort(sortedJobInfo,Comparator.comparingInt((int[]obj)->obj[2]).reversed()); //sort desending order

        //sort as per profit 40 30 20 20

        int time=0;
              
        ArrayList<Integer> seq=new ArrayList<>();

        // we reverse the loop to hight profit on top

        for (int i=0;i<sortedJobInfo.length;i++) {  //40 30 20 20

            int deadline=sortedJobInfo[i][1];

            if (deadline>time) {
                
                seq.add(sortedJobInfo[i][0]);
                time+=deadline;
            }
        }
  
        
        for (Integer integer : seq)     
            System.out.print(" "+integer);
        
        System.out.println();
    }

    public static void main(String[] args) {
        
        int jobInfo[][]={{4,20},{1,20},{1,40},{1,30}};

        usingClassApproch(jobInfo);
        findJobSeq(jobInfo);
    }
}

// this example also done by doing same gradidy aapproch but now we do somthing new