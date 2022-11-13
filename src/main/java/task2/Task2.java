package task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Task2 {
    public static void main(String[] args) throws IOException {
        List<String> file1 = Files.readAllLines(Paths.get("src/main/java/task2/file1.txt"));

        String circleStart = file1.get(0);
        String[] arr = circleStart.split("\\s");
        int[] circleStartCoordinates = new int[arr.length];
        for(int i = 0 ; i < arr.length ; i++) {
            circleStartCoordinates[i] = Integer.parseInt(arr[i]);
        }

        int radius = Integer.parseInt(file1.get(1));

        List<String> file2 = Files.readAllLines(Paths.get("src/main/java/task2/file2.txt"));

        if (file2.size() > 100) {
            System.out.println("По условиям задачи точек должно быть не больше ста");
        } else {
            for (int i = 0; i < file2.size(); i++) {
                String point = file2.get(i);
                String[] arr1 = point.split("\\s");
                float[] pointCoordinates = new float[arr1.length];
                for (int j = 0; j < arr1.length; j++) {
                    pointCoordinates[j] = Float.parseFloat(arr1[j]);
                }
                double s = Math.sqrt(Math.pow((pointCoordinates[0] - circleStartCoordinates[0]), 2) + Math.pow((pointCoordinates[1] - circleStartCoordinates[1]), 2));

                if (s < radius) {
                    System.out.println(i + " - точка внутри");
                } else if (s == radius) {
                    System.out.println(i + " - точка лежит на окружности");
                } else {
                    System.out.println(i +" - точка снаружи");
                }
            }
        }
    }
}
