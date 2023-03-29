package api.methods;

import api.Specifications;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiMethods {

    private final String apiEndpoint;
    Specifications specifications = new Specifications();

    public ApiMethods(String apiEndpoint) {
        this.apiEndpoint = apiEndpoint;
    }

    public Response getRequest(String path, String pathParams, int code) {
        specifications.installSpecification(apiEndpoint, code);
        return given()
                .when()
                .get(path, pathParams);
    }

    public Response postRequest(Object object, String path, int code) {
        specifications.installSpecification(apiEndpoint, code);
        return given()
                .body(object)
                .when()
                .post(path);
    }
}
