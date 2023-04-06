package test;

import org.json.JSONObject;
import org.junit.Test;

public class C3_JsonObjesiOlusturma {

    /*
    Asagidaki JSON Objesini olusturup
    konsolda yazdirin.
    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":1
    }
     */

    @Test
    public void jsonObje01(){

        JSONObject ilkJsonObje= new JSONObject();

        ilkJsonObje.put("title","Ahmet");
        ilkJsonObje.put("body","Merhaba");
        ilkJsonObje.put("userId",1);

        System.out.println("ilkJsonObje = " + ilkJsonObje);
        System.out.println("=============================");
    }

    @Test
    public void jsonObje02() {

    /*
    {
                 "firstname":"Jim",
                 "additionalneeds":"Breakfast",
                 "bookingdates":{
                         "checkin":"2018-01-01",
                         "checkout":"2019-01-01"
                    },
                  "totalprice":111,
                  "depositpaid":true,
                  "lastname":"Brown"
                  }
     */

        JSONObject bookingDates= new JSONObject();

        bookingDates.put("checkin","2018-01-01");
        bookingDates.put("checkout","2019-01-01");

        JSONObject outerJson= new JSONObject();

        outerJson.put("firstname","Jim");
        outerJson.put("additionalneeds","Breakfast");
        outerJson.put("bookingdates",bookingDates);
        outerJson.put("totalprice",111);
        outerJson.put("depositpaid",true);
        outerJson.put("lastname","Erman");

        System.out.println(outerJson);
    }


}
