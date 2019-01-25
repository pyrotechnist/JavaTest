package Collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTester {

    public static void main(String[] args) {



        // keys are Strings
        // objects are also Strings
        Map<String, String> map = new HashMap<>();
        fillData(map);

        // get key and value
        System.out.println("get key and value from map: map.forEach((k, v)");
        map.forEach((k, v) -> System.out.printf("%s: %s%n", k, v));

        // convert keys to array
        System.out.println("------------------------------------------------");
        System.out.println("convert keys to array: ");
        String[] strings = keysAsArray(map);
        for (String string : strings) {
            System.out.println(string);
        }
        // convert keys to list
        System.out.println("------------------------------------------------");
        System.out.println("convert keys to list: map.keySet()");
        List<String> list = keysAsList(map);

        for (String string : list) {
            System.out.println(string);
        }

        // convert values to list
        System.out.println("------------------------------------------------");
        System.out.println("convert values to list: map.values() ");
        List<String> list_Values = valuesAsList(map);

       /* for (String string : list_Values) {
            System.out.println(string);
        }*/

       list_Values.forEach(v -> System.out.println(v));


        System.out.println("------------------------------------------------");
        System.out.println("computeIfAbsent ");
        String calculatedVaue = map.computeIfAbsent("VS", it -> "C#");
        System.out.println("calculatedVaue : ");
        System.out.println(calculatedVaue);
        System.out.println("values : ");
        list_Values.forEach(v -> System.out.println(v));
    }

    private static void fillData(Map<String, String> map) {
        map.put("Android", "Mobile");
        map.put("Eclipse IDE", "Java");
        map.put("Eclipse RCP", "Java");
        map.put("Git", "Version control system");
        map.put("VS", "c#");

    }

    private static String[] keysAsArray(Map<String, String> map) {
        return map.keySet().toArray(new String[map.keySet().size()]);
    }

    // assumes the key is of type String
    private static List<String> keysAsList(Map<String, String> map) {
        List<String> list = new ArrayList<String>(map.keySet());
        return list;
    }

    private static List<String> valuesAsList(Map<String, String> map) {
        List<String> list = new ArrayList<String>(map.values());
        return list;
    }
}
