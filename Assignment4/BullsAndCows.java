package Assignment4;

public class BullsAndCows {

    public String getHint(String secret, String guess) {

        int bulls = 0;
        int cows = 0;
        int[] nums = new int[10];

        for (int i = 0; i < secret.length(); i++) {

            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));

            if (s == g)
                bulls++;
            else {

                if (nums[s] < 0)
                    cows++;
                if (nums[g] > 0)
                    cows++;
                nums[s]++;
                nums[g]--;
            }
        }
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {

        BullsAndCows numbers = new BullsAndCows();
//        System.out.println(numbers.getHint("1807","7810"));
//        System.out.println(numbers.getHint("1123","0111"));
        System.out.println(numbers.getHint("1122","1222"));
    }
}
