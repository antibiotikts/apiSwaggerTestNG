package api.steps;

import api.methods.ApiMethods;

public class BaseStep {
    private final String URL = "https://petstore.swagger.io/v2/";
    protected ApiMethods methods = new ApiMethods(URL);
}
