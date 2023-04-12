package testData;

import org.json.JSONObject;

public class TestDataHerokuApp {

    public int basarilistatusCode=200;

    public JSONObject bookingdatesJson(){

        JSONObject bookingdates = new JSONObject();

        bookingdates.put("checkin" , "2021-06-01");
        bookingdates.put("checkout" , "2021-06-10");

        return bookingdates;

    }

    public JSONObject reqBodyJson(){

        JSONObject bookingdates = new JSONObject();

        bookingdates.put("firstname" , "Ali");
        bookingdates.put("lastname" , "Bak");
        bookingdates.put("totalprice" , 500);
        bookingdates.put("depositpaid" , false);
        bookingdates.put("bookingdates",bookingdatesJson());
        bookingdates.put("additionalneeds" , "wi-fi");

        return bookingdates;

    }

    public JSONObject expBodyJson(){

        JSONObject expBody = new JSONObject();

        expBody.put("bookingid",24);
        expBody.put("booking",reqBodyJson());

        return expBody;

    }

}
