import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection 
{
    // when sorted end times are given

    /*
    public static void main(String[] args) 
    {  // T.C = O(n)
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};

        // end time basis sorted
        int maxActivities = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // 1st Activity 
        maxActivities = 1;
        ans.add(0);
        int lastEnd  = end[0];
        for(int i=1; i<end.length; i++)
        {
            if(start[i] >= lastEnd)
            {
                // activity select 
                maxActivities++;
                ans.add(i);
                lastEnd = end[i];
            }
        }
        System.out.println(maxActivities);
        for(int i=0; i<ans.size(); i++)
        {
            System.out.print("A" + ans.get(i) +" ");
        }
    }    
    */


    // for unsorted problems


    public static void main(String[] args) 
    {
        int start[] = {0, 1, 3, 5, 5, 8};
        int end[] = {6, 2, 4, 7, 9, 9};

        int activitiesToStart[][] = new int[start.length][3];
        for(int i=0; i<start.length; i++)
        {
            activitiesToStart[i][0] = i;
            activitiesToStart[i][1] = start[i];
            activitiesToStart[i][2] = end[i];
        }
       
        // lambda function to sort the 2d matrix
        Arrays.sort(activitiesToStart, Comparator.comparingDouble(o -> o[2]));


        ArrayList<Integer> ans = new ArrayList<>();
        int maxActivities = 0;
        ans.add(activitiesToStart[0][0]);
        maxActivities = 1;
        int lastEnd = activitiesToStart[0][2];
        for(int i=1; i<end.length; i++)
        {
            if(activitiesToStart[i][1] >= lastEnd)
            {
                maxActivities++;
                ans.add(activitiesToStart[i][1]);
                lastEnd = activitiesToStart[i][2];
            }
        }

        System.out.println(maxActivities);
        System.out.println(ans);
    }
}