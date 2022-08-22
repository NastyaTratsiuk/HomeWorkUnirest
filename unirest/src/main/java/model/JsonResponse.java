package model;


import kong.unirest.JsonNode;

public class JsonResponse {

    private int statusCode;
    private JsonNode body;

    public int getStatusCode() {
        return statusCode;
    }

    public JsonNode getBody() {
        return body;
    }

    public JsonResponse(int statusCode, JsonNode body) {
        this.statusCode = statusCode;
        this.body = body;
    }
}
