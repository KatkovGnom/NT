package task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int val = 1;

        StringBuilder result = new StringBuilder();
        List<Integer> list = new ArrayList<>();

        while (true) {
            for (int i = 1; i <= m; i++) {
                list.add(val);
                ++val;
                if (val > n) {
                    val = 1;
                }
            }

            result.append(list.get(0));
            val = list.get(list.size()-1);

            if (list.get(list.size()-1) == 1) {
                break;
            }

            list.clear();
        }

        System.out.println(result);
    }
}
