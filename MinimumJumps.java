public class MinimumJumps {

    public static int minJumps(int[] arr) {
        if(arr[0] == 0 || arr.length == 1) return -1;
        int n = arr.length-1;
        int jumps = 0;
        int i=n;

        while(i >= 0)
        {
            i -= arr[i];
            jumps++;
        }

        return jumps;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int[] arr2 = {1, 4, 3, 2, 6, 7};
        System.out.println(minJumps(arr1)); // Output: 3
        System.out.println(minJumps(arr2)); // Output: 2
    }
}
