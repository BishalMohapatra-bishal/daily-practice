public class SecondLargest {
    public static void main(String[] args) {
        int[] arr = {11,22,33,44,55,66};
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
    }
        System.out.println("SecondLargest number is : " + secondLargest);
        }
}

