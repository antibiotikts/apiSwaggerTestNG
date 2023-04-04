package api.methods;

import api.pojo.pet.Pet;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.RestAssured.given;

public class Post {

    private final static Logger logger = LogManager.getLogger(Post.class);

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
                .post(path).then().log().all().extract().as(response.getClass());
        logger.info("{}", response);
    }

    public Post checkResponseCode(int responseCode) {
        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(responseCode)
                .build();
        return this;
    }


}