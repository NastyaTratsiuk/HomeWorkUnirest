package utils;

import aquality.selenium.browser.AqualityServices;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;
import model.Post;
import model.User;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GsonUtils {

    private static List<Post> posts;
    private static List<User> users;
    private static User user;

    public static List<Post> parseListPosts(JSONArray jsonArray){
        Type listType =
                new TypeToken<ArrayList<Post>>(){}.getType();
         return new Gson().fromJson(String.valueOf(jsonArray), listType);
    }

    public static List<User> parseListUsers(JSONArray jsonArray)  {
        Type listType =
                new TypeToken<ArrayList<User>>(){}.getType();
        return new Gson().fromJson(String.valueOf(jsonArray), listType);
    }

    public static User parseUser(JSONObject jsonObject)  {
        Type listType =
                new TypeToken<User>(){}.getType();
        return new Gson().fromJson(String.valueOf(jsonObject), listType);
    }

    public static User parseUserNew()  {
        Type listType =
                new TypeToken<User>(){}.getType();
        Reader reader = null;
        try {
            reader = new FileReader("userID5.json");
        } catch (FileNotFoundException e) {
            AqualityServices.getLogger().debug(e.getMessage());
        }
        return new Gson().fromJson(reader, listType);
    }
}
