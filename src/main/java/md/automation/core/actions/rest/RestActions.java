package md.automation.core.actions.rest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestActions {

    private RequestSpecification request;
    private Response response;


    // Cria request SEM baseUri
    public void newRequest() {
        request = RestAssured.given();
    }

    public RequestSpecification getRequest() {
        if (request == null) {
            throw new IllegalStateException(
                    "Request não inicializada. Chame newRequest() antes."
            );
        }
        return request;
    }

    public void sendPost(String endpoint) {
        response = request.post(endpoint);
    }
    public void sendGet(String endpoint) {
        response = request.get(endpoint);
    }
    public void sendPatch(String endpoint) {
        response = request.patch(endpoint);
    }
    public void sendPut(String endpoint) {
        response = request.put(endpoint);
    }
    public void sendDelete(String endpoint) {
        response = request.delete(endpoint);
    }
    public String getResponseValue(String jsonPath) {
        return response
                .then()
                .extract()
                .path(jsonPath);
    }

    public Response getResponse() {
        return response;
    }
    public void printResponse() {
        getResponse().then().log().all();
    }
    public void validateStatusCode(int expectedStatusCode) {
        getResponse().then().statusCode(expectedStatusCode);
    }
    public int getStatusCode() {
        return getResponse().getStatusCode();
    }



}


