package MidtermPartB;

public class SmallestSubArraySum {

    public static int smallestSubWithSum(int arr[], int x) {

        int sum = 0, from = 0, min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            while (sum > x) {

                min = Math.min(min, i - from + 1);
                sum -= arr[from];
                from++;
            }
        }

        return (min == Integer.MAX_VALUE) ? 0 : min ;
    }
}
