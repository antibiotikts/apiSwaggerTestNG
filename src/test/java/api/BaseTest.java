package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected final String URL = "https://petstore.swagger.io/v2/";

    @BeforeTest
    public void setUrlAndContentType() {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(URL)
                .setContentType(ContentType.JSON)
                .build();
    }
}
