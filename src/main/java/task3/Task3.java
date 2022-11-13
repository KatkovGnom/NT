package task3;

import com.google.gson.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Task3 {
    public static void main(String[] args) throws IOException {
        List<Value> values = parseValues();
        List<Test> tests = parseTests();

        for (Test test : tests) {
            for (Value value : values) {
                if (value.getId().equals(test.getId())) {
                    test.setValue(value.getValue());
                }
            }
        }
        Map<String, List<Test>> result = new HashMap<>();
        result.put("tests", tests);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Writer writer = Files.newBufferedWriter(Paths.get("src/main/java/task3/report.json"));

        gson.toJson(result, writer);

        writer.close();
    }

    private static void jsonArrayToSet(JsonArray jAry, List<Test> result, String subArrayKey){
        for (JsonElement el : jAry) {
            JsonObject jObj = el.getAsJsonObject();
            boolean hasSubArray = false;
            JsonArray subArray = null;
            if(jObj.has(subArrayKey)){
                Object possibleSubArray = jObj.get(subArrayKey);
                if(possibleSubArray instanceof JsonArray){
                    hasSubArray = true;
                    subArray = (JsonArray) possibleSubArray;
                }
            }
            if(hasSubArray){
                String id = jObj.get("id").getAsString();
                String title = jObj.get("title").getAsString();
                Test test = new Test();
                test.setId(id);
                test.setTitle(title);
                result.add(test);
                jsonArrayToSet(subArray, result, subArrayKey);
            } else {
                String id = jObj.get("id").getAsString();
                String title = jObj.get("title").getAsString();
                String value = jObj.get("value").getAsString();
                Test test = new Test(id, title, value);
                result.add(test);
            }
        }
    }

    public static List<Value> parseValues() {
        File valuesFile = new File("src/main/java/task3/values.json");
        List<Value> values = new ArrayList<>();
        try {
            JsonElement fileElement = new JsonParser().parse(new FileReader(valuesFile));
            JsonObject fileObject = fileElement.getAsJsonObject();
            JsonArray vals = fileObject.get("values").getAsJsonArray();
            for (JsonElement v : vals) {
                JsonObject valueObject = v.getAsJsonObject();
                String id = valueObject.get("id").getAsString();
                String value = valueObject.get("value").getAsString();

                Value val = new Value(id, value);
                values.add(val);
            }
        } catch (FileNotFoundException | NullPointerException e) {
            System.err.println("Error input file not found!");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error processing input file!");
            e.printStackTrace();
        }
        return values;
    }

    public static List<Test> parseTests() {
        File valuesFile = new File("src/main/java/task3/tests.json");
        List<Test> tests = new ArrayList<>();
        try {
            JsonElement fileElement = new JsonParser().parse(new FileReader(valuesFile));
            JsonObject fileObject = fileElement.getAsJsonObject();
            JsonArray tsts = fileObject.get("tests").getAsJsonArray();
            jsonArrayToSet(tsts, tests, "values");
        } catch (FileNotFoundException | NullPointerException e) {
            System.err.println("Error input file not found!");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error processing input file!");
            e.printStackTrace();
        }
        return tests;
    }
}
