package GreedyAlgorithms;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    
    public static void findNoOfActivityPerformed(int[] start ,int[]end){ //logn

        ArrayList<Integer>activityName=new ArrayList<>();

        //first we need to sort the Activities as per end time.
        // for that we create a aary with 3 rows for index starttime endtime

        int sortedEndtime[][]=new int[start.length][3];

        for (int i = 0; i < start.length; i++) {
            
            sortedEndtime[i][0]=i;  // at first column we store indedx , start time end time 0-> index
            sortedEndtime[i][1]=start[i];   //1= start index
            sortedEndtime[i][2]=end[i];     //2=end index
        }


        //sort as per index value
        //we lamda function of comparator interface

        Arrays.sort(sortedEndtime,Comparator.comparingDouble(o->o[2]));  // remainber syntax

        int noOfActivites=1;    // by default is done 1 atlist even if all activies are garter..
        activityName.add(0);

        // now see the second activity starttime must be grater than>= end of 1st Activity

        int lastEnd=sortedEndtime[0][2];

        for (int i = 1; i < sortedEndtime.length; i++) {    // we started with second indes and consider one activity is done
            
            if (lastEnd<=sortedEndtime[i][1]) {
                noOfActivites++;
                activityName.add(sortedEndtime[i][0]);          // add indexes to letter print

                lastEnd=sortedEndtime[i][2];                     //initialize the end of ith acitvity
            }

        }

        System.out.println(noOfActivites);

        for (int i : activityName) {
            System.out.print(" A"+i);
        }

    }

    public static void main(String[] args) {

        int[]start={1,3,0,5,8,5};
        int[]end={2,4,6,7,9,9};
        
        findNoOfActivityPerformed(start, end);

    }
}

/*
 * we have example were each activity have start and end time and 
 * one person can do one Activity at time 
 * we need to find no. activity person can perform 
 * sol: 
 *  the one activity need to end to do second activtiy as visulize in D:\vscodeProgram\GreedyAlgorithms\ActivitSlectionLogic.png
 * 
 * 
 */