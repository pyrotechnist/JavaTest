package main.java;

import main.java.hexa.HexUtil;


import java.util.HashMap;
import java.util.Map;
import com.ipx.common.util.Base64;

public class Main {

    public static void main(String[] args) {


        // Hexa

        String  test = "Signera kortköp\n" +
                "\n" +
                "Obs! Koden får aldrig lämnas ut till annan person.\n" +
                "\n" +
                "Köpställe: Klarna AB\n" +
                "Belopp: SEK 866,30\n" +
                "Datum och tid: 2018-12-20 10:42\n" +
                "Kortnummer: ";

        String  test2 = "Signera kortköp\n";

        String  test3 =
                "öp\n\n";


        int c=test2.charAt(15);
        String udh = "0500030F0201";

        String theHexaStringAdapter = HexUtil.stringToHexa (test3,false);

        String theHexaStringUtils = HexUtil.toHexString(test3.getBytes(),test3.getBytes().length);

        System.out.println("convert to hex adapter: " + theHexaStringAdapter);
        System.out.println("convert to hex utils:   " + theHexaStringUtils);


        //theHexaStringAdapter = udh + theHexaStringAdapter;
        //theHexaStringUtils = udh + theHexaStringUtils;



        System.out.println("After adding UDH for sunrise adapter : " + theHexaStringAdapter);

        System.out.println("After adding UDH for sunrise utils: " + theHexaStringUtils);

        System.out.println( "Res: adapter " + HexUtil.fromHexString(theHexaStringAdapter));

        System.out.println( "Res: utils " +HexUtil.fromHexString(theHexaStringUtils));


        //System.out.println( "Res: adapter " + Base64.encodeBase64(HexUtil.fromHexString(theHexaStringAdapter)));

        //System.out.println( "Res: utils " +Base64.encodeBase64(HexUtil.fromHexString(theHexaStringUtils)));

        //Map<String,Integer> map = createMap();
       // map.put("Android", 1 + map.getOrDefault("Android", 0));

       // map.put("Android", 1 );

        // write to command line
        //map.forEach((k, v) -> System.out.printf("%s %s%n", k, v));

        try {

           // JDBCPreparedStatementSelectTest.selectRecordsFromTable(10279111);
        }catch (Exception e)
        {
            System.out.println(e);
        }


    }

    private static Map<String, Integer> createMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Eclipse IDE", 0);
        map.put("Eclipse RCP", 0);
        map.put("Git", 0);
        map.put("Android", 0);
        return map;
    }
}
