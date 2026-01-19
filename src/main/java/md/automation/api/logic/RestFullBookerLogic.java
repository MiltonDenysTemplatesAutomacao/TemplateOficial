package md.automation.api.logic;

import io.restassured.http.ContentType;
import lombok.extern.log4j.Log4j2;
import md.automation.api.TokenRequest;
import md.automation.core.actions.rest.RestActions;
import md.automation.core.config.ApiUrls;
import md.automation.core.enums.MediaType;
import md.automation.core.utils.ExtentScenarioContext;
import org.junit.Assert;

import java.util.Map;

@Log4j2
public class RestFullBookerLogic {

    private RestActions restAction;
    private TokenRequest tokenRequest;

    public RestFullBookerLogic() {
        restAction = new RestActions();
        tokenRequest = new TokenRequest();
    }

    public void prepareHealthCheckRequest() {
        ExtentScenarioContext.get().info("Preparing Health Check request");
        restAction.newRequest();
    }

    public void prepareBookingIdRequest() {
        ExtentScenarioContext.get().info("Preparing Get Booking IDs request");
        restAction.newRequest();
    }

    public void prepareGetBookingsRequest() {
        ExtentScenarioContext.get().info("Preparing Get Bookings request");
        restAction.newRequest();
    }

    public void prepareUpdateBookingRequest() {
        ExtentScenarioContext.get().info("Preparing Update Booking request");

        String token = tokenRequest.acessToken();
        restAction.newRequest();
        restAction.getRequest()
                .accept(MediaType.JSON.value())
                .contentType(MediaType.JSON.value())
                .header("Cookie", "token=" + token)
                .body(restAction.getJsonFromData("updateBooking.json"));
    }

    public void preparePartialUpdateBookingRequest() {
        ExtentScenarioContext.get().info("Preparing Partial Update Booking request");

        String token = tokenRequest.acessToken();
        restAction.newRequest();
        restAction.getRequest()
                .accept(MediaType.JSON.value())
                .contentType(MediaType.JSON.value())
                .header("Cookie", "token=" + token)
                .body(restAction.getJsonFromData("partialUpdateBooking.json"));
    }

    public void prepareDeleteBookingRequest() {
        ExtentScenarioContext.get().info("Preparing Delete Booking request");

        String token = tokenRequest.acessToken();
        restAction.newRequest();
        restAction.getRequest()
                .contentType(MediaType.JSON.value())
                .header("Cookie", "token=" + token);
    }

    public void prepareCreateBookingRequest() {
        ExtentScenarioContext.get().info("Preparing Create Booking request");

        restAction.newRequest();
        restAction.getRequest()
                .contentType(ContentType.JSON)
                .body(restAction.getJsonFromData("createBooking.json"));
    }

    public void sendPostRequestCreateBooking() {
        ExtentScenarioContext.get().info("Sending POST request to /booking");

        restAction.sendPost(ApiUrls.BASE_URL + ApiUrls.BOOKING);
        restAction.printResponse();

        ExtentScenarioContext.get()
                .info("Response status code: " + restAction.getResponse().getStatusCode());
    }

    public void sendGetRequestGetBooking(String id) {
        ExtentScenarioContext.get().info("Sending GET request to /booking/" + id);

        restAction.sendGet(ApiUrls.BASE_URL + ApiUrls.BOOKING + "/" + id);
        restAction.printResponse();
    }

    public void sendPutRequestUpdateBooking(String id) {
        ExtentScenarioContext.get().info("Sending PUT request to /booking/" + id);

        restAction.sendPut(ApiUrls.BASE_URL + ApiUrls.BOOKING + "/" + id);
        restAction.printResponse();
    }

    public void sendPatchRequestPartialUpdateBooking(String id) {
        ExtentScenarioContext.get().info("Sending PATCH request to /booking/" + id);

        restAction.sendPatch(ApiUrls.BASE_URL + ApiUrls.BOOKING + "/" + id);
        restAction.printResponse();
    }

    public void sendDeleteRequestDeleteBooking(String id) {
        ExtentScenarioContext.get().info("Sending DELETE request to /booking/" + id);

        restAction.sendDelete(ApiUrls.BASE_URL + ApiUrls.BOOKING + "/" + id);
        restAction.printResponse();
    }

    public void sendGetRequestBookingId() {
        ExtentScenarioContext.get().info("Sending GET request to /booking");

        restAction.sendGet(ApiUrls.BASE_URL + ApiUrls.BOOKING);
        restAction.printResponse();
    }

    public void sendGetRequestHealthCheck() {
        ExtentScenarioContext.get().info("Sending GET request to /health");

        restAction.sendGet(ApiUrls.BASE_URL + ApiUrls.HEALTH_CHECK);
        restAction.printResponse();
    }

    public void validateStatusCode(Integer statusCode) {
        ExtentScenarioContext.get()
                .info("Validating status code: " + statusCode);

        restAction.validateStatusCode(statusCode);

        ExtentScenarioContext.get()
                .pass("Status code validated successfully");
    }

    public void validateFieldsFromResponseJson(Map<String, String> fields) {
        log.info("Validating response body fields");
        ExtentScenarioContext.get().info("Validating response body fields");

        fields.forEach((key, expected) -> {
            String actual = restAction.getResponse()
                    .getBody()
                    .jsonPath()
                    .getString(key);

            Assert.assertNotNull("Field not found: " + key, actual);
            Assert.assertEquals(
                    "Incorrect value for field: " + key,
                    expected.trim(),
                    actual.trim()
            );

            ExtentScenarioContext.get()
                    .info("OK -> " + key + " = " + actual);
        });

        ExtentScenarioContext.get()
                .pass("All response fields validated successfully");
    }
}
