package Assignment7;

import java.util.Random;

public class MyIndexOutOfBoundException extends Exception {

    private int lowerBound, upperBound, index;

    MyIndexOutOfBoundException(int index, int lowerBound, int upperBound) {

        this.index = index;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    @Override
    public String toString() {

        return "Error Message: Index: " + index + ", but Lower bound: " + lowerBound + ", Upper bound: " + upperBound;
    }

    public static void main(String[] args) {

        final int size = 100;
        int[] nums = new int[size];
        Random random = new Random();

        while (true) {

            int i = random.nextInt(size + size / 4);

            try {

                if (i >= size)
                    throw new MyIndexOutOfBoundException(i, 0, size - 1);
                else {
                    nums[i] = random.nextInt(size);
                    System.out.println(nums[i]);
                }
            } catch (Exception e) {

                System.out.println(e);
                return;
            }
        }
    }
}
