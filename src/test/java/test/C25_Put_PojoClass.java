package test;

import baseURL.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.JsonPlaceHolderReqBodyPojo;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class C25_Put_PojoClass extends JsonPlaceHolderBaseURL {

    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
 body’e sahip bir PUT request yolladigimizda donen response’in
 response body’sinin asagida verilen ile ayni oldugunu test ediniz
     Request Body
    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }
    Expected Body
    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }
     */

    @Test
    public void put01(){

        // 1- Url ve body hazirla

        specJsonPlace.pathParams("pp1","posts","pp2",70);

        JsonPlaceHolderReqBodyPojo reqBody= new JsonPlaceHolderReqBodyPojo("Ahmet","Merhaba",10,70);

        System.out.println("reqBody = " + reqBody);

        // 2- Expected data hazirla

        JsonPlaceHolderReqBodyPojo expBody= new JsonPlaceHolderReqBodyPojo("Ahmet","Merhaba",10,70);

        // 3- Response'i kaydet

        Response response= given()
                                .spec(specJsonPlace)
                                .contentType(ContentType.JSON)
                            .when()
                                .body(reqBody).put("/{pp1}/{pp2}");

        response.prettyPrint();

        // 4- Assertion

        //JsonPath resJP= response.jsonPath();
        //Map<String,Object> resMap= response.as(HashMap.class);
        JsonPlaceHolderReqBodyPojo resPojo= response.as(JsonPlaceHolderReqBodyPojo.class);

        Assert.assertEquals(expBody.getTitle(),resPojo.getTitle());
        Assert.assertEquals(expBody.getBody(),resPojo.getBody());
        Assert.assertEquals(expBody.getUserId(),resPojo.getUserId());
        Assert.assertEquals(expBody.getId(),resPojo.getId());


    }

}
