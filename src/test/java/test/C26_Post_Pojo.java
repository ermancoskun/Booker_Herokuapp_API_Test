package test;

import baseURL.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.PojoHerokuAppBooking;
import pojos.PojoHerokuAppBookingDates;
import pojos.PojoHerokuAppExpBody;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class C26_Post_Pojo extends HerokuAppBaseUrl {

    /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un id disinda asagidaki gibi oldugunu test edin.
                        Request body
                   {
                        "firstname" : "Ali",
                        "lastname" : “Bak",
                        "totalprice" : 500,
                        "depositpaid" : false,
                        "bookingdates" : {
                                 "checkin" : "2021-06-01",
                                 "checkout" : "2021-06-10"
                                          },
                        "additionalneeds" : "wi-fi"
                    }
                        Response Body = Expected Data
                        {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ali",
                        "lastname":"Bak",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                              }
                    }
         */

    @Test
    public void post01(){

        // 1- Url ve Body hazirla

        specHerokuApp.pathParam("pp1","booking");

        PojoHerokuAppBookingDates bookingDates= new PojoHerokuAppBookingDates("2021-06-01","2021-06-10");

        PojoHerokuAppBooking reqBody= new PojoHerokuAppBooking("Ali","Bak",500,false,bookingDates,"wi-fi");

        // 2- Expected data hazirla

        PojoHerokuAppExpBody expBody= new PojoHerokuAppExpBody(24,reqBody);

        // 3- Response kaydet

        Response response= given()
                .spec(specHerokuApp)
                .contentType(ContentType.JSON)
                .when()
                .body(reqBody)
                .post("/{pp1}");

        response.prettyPrint();

        // 4- Assertion

        PojoHerokuAppExpBody resPojo= response.as(PojoHerokuAppExpBody.class);

        Assert.assertEquals(expBody.getBooking().getFirstname(),resPojo.getBooking().getFirstname());
        Assert.assertEquals(expBody.getBooking().getLastname(),resPojo.getBooking().getLastname());
        Assert.assertEquals(expBody.getBooking().getTotalprice(),resPojo.getBooking().getTotalprice());
        Assert.assertEquals(expBody.getBooking().isDepositpaid(),resPojo.getBooking().isDepositpaid());
        Assert.assertEquals(expBody.getBooking().getBookingdates().getCheckin(),resPojo.getBooking().getBookingdates().getCheckin());
        Assert.assertEquals(expBody.getBooking().getBookingdates().getCheckout(),resPojo.getBooking().getBookingdates().getCheckout());
        Assert.assertEquals(expBody.getBooking().getAdditionalneeds(),resPojo.getBooking().getAdditionalneeds());


    }




}
