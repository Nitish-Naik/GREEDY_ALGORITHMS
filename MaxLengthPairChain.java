import java.util.Arrays;
import java.util.Comparator;

public class MaxLengthPairChain 
{
    public static int findLongestChain(int[][] pairs) 
    {
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));
        int chainLen = 1;
        int chainEnd = pairs[0][1]; // last selected pair chain end

        for(int i=0; i<pairs.length; i++)
        {
            if(pairs[i][0] > chainEnd)
            {
                chainLen++;
                chainEnd = pairs[i][1];
            }
        }
        return chainLen;
    }
    public static void main(String[] args) 
    {
        int [][]pairs = {
                        {1,2},
                        {2,3},
                        {3,4}};
// Output: 2
        System.out.println(findLongestChain(pairs));
    }
}    

