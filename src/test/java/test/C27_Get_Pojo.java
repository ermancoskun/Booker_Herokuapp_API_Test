package test;

import baseURL.DummyBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.PojoDummyData;
import pojos.PojoDummyExpBody;

import static io.restassured.RestAssured.given;

public class C27_Get_Pojo extends DummyBaseUrl {

     /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
     gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
    Response Body
    {
    "status":"success",
    "data":{
            "id":3,
            "employee_name":"Ashton Cox",
            "employee_salary":86000,
            "employee_age":66,
            "profile_image":""
            },
    "message":"Successfully! Record has been fetched."
    }
     */

    @Test
    public void get01(){

        // 1- Url hazirla

        specDummy.pathParams("pp1","api","pp2","v1","pp3","employee","pp4",3);

        // 2- Expected data

        PojoDummyData data= new PojoDummyData(3,"Ashton Cox",86000,66,"");

        PojoDummyExpBody expBody= new PojoDummyExpBody("success",data,"Successfully! Record has been fetched.");

        // 3- Response kaydet

        Response response=given().spec(specDummy).when().get("/{pp1}/{pp2}/{pp3}/{pp4}");

        response.prettyPrint();

        // 4- Assertion

        PojoDummyExpBody resPojo= response.as(PojoDummyExpBody.class);

        Assert.assertEquals(expBody.getStatus(),resPojo.getStatus());
        Assert.assertEquals(expBody.getMessage(),resPojo.getMessage());
        Assert.assertEquals(expBody.getData().getId(),resPojo.getData().getId());
        Assert.assertEquals(expBody.getData().getEmployee_name(),resPojo.getData().getEmployee_name());
        Assert.assertEquals(expBody.getData().getEmployee_salary(),resPojo.getData().getEmployee_salary());
        Assert.assertEquals(expBody.getData().getEmployee_age(),resPojo.getData().getEmployee_age());
        Assert.assertEquals(expBody.getData().getProfile_image(),resPojo.getData().getProfile_image());

    }


}
