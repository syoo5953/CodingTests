package HackerRank;

public class HackerrankMinIncrement {
    public static void main (String[] args)
    {
        int arr[] = {5, 6, 2, 4, 3};
        printMinOp(arr);
    }
    static void printMinOp(int arr[])
    {
        int arraySum, smallest, arr_size = arr.length;
        arraySum = 0;
        smallest = arr[0];
        for (int i = 0; i < arr_size ; i ++)
        {
            /* If current element is smaller than
               update smallest */
            if (arr[i] < smallest){
                smallest = arr[i];
                System.out.println(smallest);
            }
            //smallest = 5   arraySum = 5
            /*find array sum */
            arraySum += arr[i];
            System.out.println(arraySum);
        }

        int minOperation = arraySum - arr_size * smallest;

        /* Print min operation required */
        System.out.println("Minimum Operation = " +
                minOperation);

    }
}
