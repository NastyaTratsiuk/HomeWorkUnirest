
import enums.StatusCode;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;
import model.JsonResponse;
import model.Post;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.*;

import java.util.List;

public class RestApiTest {

    @Test
    public void testCaseAPI() {
        JsonResponse jsonResponsePosts = ApiUtils.get(JsonParseUtils.getElementFromJsonParse("config.json", "/url")
                + JsonParseUtils.getElementFromJsonParse("config.json", "/postsRoute"));
        JSONArray jsonArrayPosts = jsonResponsePosts.getBody().getArray();
        List<Post> posts = GsonUtils.parseListPosts(jsonArrayPosts);
        Assert.assertEquals(jsonResponsePosts.getStatusCode(), StatusCode.CODE_200.count, "Status code is not correct.");
        Assert.assertEquals(posts, SortUtils.sortPostsById(posts), "Incorrect difference.");
        JsonResponse jsonResponsePost99 = ApiUtils.get(JsonParseUtils.getElementFromJsonParse("config.json", "/url")
                + JsonParseUtils.getElementFromJsonParse("config.json", "/postsRoute")
                + JsonParseUtils.getElementFromJsonParse("testFile.json", "/post99"));
        JSONObject jsonObjectPost = jsonResponsePost99.getBody().getObject();
        Assert.assertEquals(jsonResponsePost99.getStatusCode(), StatusCode.CODE_200.count, "Status code is not correct.");
        Assert.assertEquals(jsonObjectPost.get("userId"), posts.get(Integer.parseInt(JsonParseUtils.getElementFromJsonParse("testFile.json", "/indexPost"))).getUserId(),
                "User ids don't match.");
        Assert.assertEquals(jsonObjectPost.get("id"), posts.get(Integer.parseInt(JsonParseUtils.getElementFromJsonParse("testFile.json", "/indexPost"))).getId(),
                "Ids don't match.");
        Assert.assertNotNull(jsonObjectPost.get("title"), "Title is null.");
        Assert.assertNotNull(jsonObjectPost.get("body"), "Body is null.");
        JsonResponse jsonResponsePost150 = ApiUtils.get(JsonParseUtils.getElementFromJsonParse("config.json", "/url")
                + JsonParseUtils.getElementFromJsonParse("config.json", "/postsRoute")
                + JsonParseUtils.getElementFromJsonParse("testFile.json", "/post150"));
        Assert.assertEquals(jsonResponsePost150.getStatusCode(), StatusCode.CODE_404.count, "Status code is not correct.");
        Assert.assertTrue(jsonResponsePost150.getBody().getObject().isEmpty(), "Body is not empty.");
        JsonResponse jsonResponsePostMethodPost = (JsonResponse) ApiUtils.post(JsonParseUtils.getElementFromJsonParse("config.json", "/url")
                        + JsonParseUtils.getElementFromJsonParse("config.json", "/postsRoute"))
                .field("userId",JsonParseUtils.getElementFromJsonParse("testFile.json", "/postMethodUserId"))
                .field( "title",RandomUtils.getRandomTextForTitle()).field("body", RandomUtils.getRandomTextForBody()).asJson();
        Assert.assertEquals(jsonResponsePostMethodPost.getStatusCode(), StatusCode.CODE_201.count, "Status code is not correct.");
        Assert.assertEquals(jsonResponsePostMethodPost.getBody().getObject().get("userId"),
                JsonParseUtils.getElementFromJsonParse("testFile.json", "/postMethodUserId")
                , "User ids don't match.");
        Assert.assertEquals(jsonResponsePostMethodPost.getBody().getObject().get("title"), RandomUtils.getRandomTextTitle(),
                "Title and random text don't much.");
        Assert.assertEquals(jsonResponsePostMethodPost.getBody().getObject().get("body"), RandomUtils.getRandomTextBody(),
                "Body and random text don't much.");
        Assert.assertNotNull(jsonResponsePostMethodPost.getBody().getObject().get("id"), "Id is null.");
        JsonResponse jsonResponseUsers = ApiUtils.get(JsonParseUtils.getElementFromJsonParse("config.json", "/url")
                + JsonParseUtils.getElementFromJsonParse("config.json", "/usersRoute"));
        JSONArray jsonArrayUsers = jsonResponseUsers.getBody().getArray();
        List<User> users = GsonUtils.parseListUsers(jsonArrayUsers);
        Assert.assertEquals(jsonResponseUsers.getStatusCode(), StatusCode.CODE_200.count, "Status code is not correct.");
        Assert.assertEquals(users.get(Integer.parseInt(JsonParseUtils.getElementFromJsonParse("testFile.json", "/indexUser")))
                , GsonUtils.parseUserNew(), "Users don't much.");
        JsonResponse jsonResponseUser5 = ApiUtils.get(JsonParseUtils.getElementFromJsonParse("config.json", "/url")
                + JsonParseUtils.getElementFromJsonParse("config.json", "/usersRoute")
                + JsonParseUtils.getElementFromJsonParse("testFile.json", "/user5"));
        JSONObject jsonObjectUser = jsonResponseUser5.getBody().getObject();
        User newUser = GsonUtils.parseUser(jsonObjectUser);
        Assert.assertEquals(jsonResponseUser5.getStatusCode(), StatusCode.CODE_200.count, "Status code is not correct.");
        Assert.assertEquals(newUser, GsonUtils.parseUserNew(),
                "The data from the request /users/5 does not match the data from userIDFile.json.");
    }
}

