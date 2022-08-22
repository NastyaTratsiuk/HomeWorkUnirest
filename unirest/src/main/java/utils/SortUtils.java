package utils;

import model.Post;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortUtils {

    public static List<Post> sortPostsById (List<Post> postList) {
        return   postList.stream()
                .sorted(Comparator.comparing(Post::getId))
                .collect(Collectors.toList());

    }
}