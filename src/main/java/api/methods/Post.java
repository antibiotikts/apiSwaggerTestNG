package api.methods;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;

import static io.restassured.RestAssured.given;

public class Post {

    private final Object request;
    private  Object response;

    public Post(Object request, Object response) {
        this.request = request;
        this.response = response;
    }

    public Object getResponse() {
        return response;
    }

    public void postRequest(String path) {
        response = given()
                .body(request)
                .when()
                .post(path).then().extract().as(response.getClass());
    }

    public Post checkResponseCode(int responseCode) {
        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(responseCode)
                .build();
        return this;
    }


}