package testData;

import org.json.JSONObject;

import java.util.HashMap;

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

    public HashMap bookingdatesMap (){

        HashMap<String ,Object> bookingdates = new HashMap<>();

        bookingdates.put("checkin" , "2021-06-01");
        bookingdates.put("checkout" , "2021-06-10");

        return bookingdates;
    }

    public HashMap reqBodyMap (){

        HashMap<String ,Object> booking = new HashMap<>();

        booking.put("firstname" , "Ali");
        booking.put("lastname" , "Bak");
        booking.put("totalprice" , 500.0);
        booking.put("depositpaid" , false);
        booking.put("additionalneeds" , "wi-fi");
        booking.put("bookingdates", bookingdatesMap());

        return booking;
    }

    public HashMap expBodyMap(){

        HashMap<String,Object> expBody = new HashMap<>();

        expBody.put("bookingid" , 24);
        expBody.put("booking" , reqBodyMap());

        return expBody;
    }
}
