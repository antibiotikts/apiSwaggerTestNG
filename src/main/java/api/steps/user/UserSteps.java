package api.steps.user;

import api.generators.UserGenerator;
import api.pojo.ApiResponse;
import api.pojo.user.User;
import api.steps.BaseStep;
import org.testng.Assert;

import java.util.Collections;
import java.util.List;

public class UserSteps extends BaseStep {

    public void getUserByName() {
        ApiResponse expectedApiResponse = new ApiResponse(1, "error", "User not found");
        ApiResponse apiResponse = methods
                .getRequest("user/{username}", "bob", 404)
                .then().extract()
                .as(ApiResponse.class);

        Assert.assertEquals(expectedApiResponse.getCode(), apiResponse.getCode());
        Assert.assertEquals(expectedApiResponse.getType(), apiResponse.getType());
        Assert.assertEquals(expectedApiResponse.getMessage(), apiResponse.getMessage());
    }

    public void getUserByName2() {
        ApiResponse expectedApiResponse = new ApiResponse(1, "error", "User not found");
        ApiResponse apiResponse = methods
                .getRequest("user/{username}", "bob", 404)
                .then().extract()
                .as(expectedApiResponse.getClass());
    }


    public void postUserWithList() {
        ApiResponse expectedApiResponse = new ApiResponse(200, "unknown", "ok");
        User user = UserGenerator.crateUser();
        List<User> userList = Collections.singletonList(user);

        ApiResponse apiResponse = methods
                .postRequest(userList, "user/createWithArray", 200)
                .then().extract()
                .as(ApiResponse.class);

        Assert.assertEquals(expectedApiResponse.getCode(), apiResponse.getCode());
        Assert.assertEquals(expectedApiResponse.getType(), apiResponse.getType());
        Assert.assertEquals(expectedApiResponse.getMessage(), apiResponse.getMessage());
    }

    public void postUserWithArray() {
        ApiResponse expectedApiResponse = new ApiResponse(200, "unknown", "ok");
        User user = UserGenerator.crateUser();
        User[] users = {user};

        ApiResponse apiResponse = methods
                .postRequest(users, "user/createWithArray", 200)
                .then().extract()
                .as(ApiResponse.class);

        Assert.assertEquals(expectedApiResponse.getCode(), apiResponse.getCode());
        Assert.assertEquals(expectedApiResponse.getType(), apiResponse.getType());
        Assert.assertEquals(expectedApiResponse.getMessage(), apiResponse.getMessage());
    }
}
