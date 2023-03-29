package api.steps.user;

import api.methods.ApiMethods;
import api.pojo.Response;
import api.pojo.user.User;
import api.steps.BaseStep;
import org.testng.Assert;

import java.util.Collections;
import java.util.List;

public class UserSteps extends BaseStep {
    ApiMethods methods = new ApiMethods(URL);

    public void getUserByName() {
        Response expectedResponse = new Response(1, "error", "User not found");
        Response response = methods
                .getRequest("user/{username}", "bob", 404)
                .then().extract()
                .as(Response.class);

        Assert.assertEquals(expectedResponse.getCode(), response.getCode());
        Assert.assertEquals(expectedResponse.getType(), response.getType());
        Assert.assertEquals(expectedResponse.getMessage(), response.getMessage());
    }

    public void postUserWithList() {
        Response expectedResponse = new Response(200, "unknown", "ok");
        User user = new User(0, "bobi", "bob", "tesla", "bob@g.com", "ff", "333", 0);
        List<User> userList = Collections.singletonList(user);

        Response response = methods
                .postRequest(userList, "user/createWithArray", 200)
                .then().extract()
                .as(Response.class);

        Assert.assertEquals(expectedResponse.getCode(), response.getCode());
        Assert.assertEquals(expectedResponse.getType(), response.getType());
        Assert.assertEquals(expectedResponse.getMessage(), response.getMessage());
    }

    public void postUserWithArray() {
        Response expectedResponse = new Response(200, "unknown", "ok");
        User user = new User(0, "bobi", "bob", "tesla", "bob@g.com", "ff", "333", 0);
        User[] users = {user};

        Response response = methods
                .postRequest(users, "user/createWithArray", 200)
                .then().extract()
                .as(Response.class);

        Assert.assertEquals(expectedResponse.getCode(), response.getCode());
        Assert.assertEquals(expectedResponse.getType(), response.getType());
        Assert.assertEquals(expectedResponse.getMessage(), response.getMessage());
    }
}
