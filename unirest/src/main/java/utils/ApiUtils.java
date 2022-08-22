package utils;

import kong.unirest.*;
import model.JsonResponse;

public class ApiUtils {

    public static JsonResponse get(String requestPath) {
        HttpResponse<JsonNode> response = null;
            response = Unirest.get(requestPath).asJson();
        return new JsonResponse(response.getStatus(), response.getBody());
    }

    public static HttpRequestWithBody post(String route) {
        return Unirest.post(route);
    }
}
