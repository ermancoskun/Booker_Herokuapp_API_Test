package baseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class DummyBaseUrl {

    protected RequestSpecification specDummy;

    @Before
    public void setUp(){

        specDummy= new RequestSpecBuilder()
                .setBaseUri("http://dummy.restapiexample.com")
                .build();

    }



}
