package task4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Task4 {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/main/java/task4/numbers.txt"));
        String[] nums = lines.get(0).split("\\s");
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = Integer.parseInt(nums[i]);
        }

            double sum = 0;
            int result = 0;

            for (int k : arr) {
                sum += k;
            }

            int average = (int) (Math.ceil(sum / arr.length));

            for (int j : arr) {
                while (j != average) {
                    if (j > average) {
                        j -= 1;
                    } else {
                        j += 1;
                    }
                    ++result;
                }
            }
            System.out.println(result);
    }
}