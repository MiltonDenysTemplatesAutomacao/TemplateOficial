package md.automation.api.logic;

import io.restassured.http.ContentType;
import md.automation.api.TokenRequest;
import md.automation.core.actions.rest.RestActions;
import md.automation.core.config.ApiUrls;
import md.automation.core.enums.MediaType;

public class RestFullBookerLogic {

    private RestActions restAction;
    private TokenRequest tokenRequest;

    public RestFullBookerLogic() {
        restAction = new RestActions();
        tokenRequest = new TokenRequest();
    }

    public void prepareHealthCheckRequest() {
        restAction.newRequest();
    }

    public void prepareBookingIdRequest() {
        restAction.newRequest();
    }

    public void prepareGetBookingsRequest() {
        restAction.newRequest();
    }

    public void prepareUpdateBookingRequest() {
        String token = tokenRequest.acessToken();
        restAction.newRequest();
        restAction.getRequest().
                accept(MediaType.JSON.value()).
                contentType(MediaType.JSON.value()).
                header("Cookie", "token=" + token).
                body("{\n" +
                        "    \"firstname\" : \"Milton\",\n" +
                        "    \"lastname\" : \"Silva\",\n" +
                        "    \"totalprice\" : 111,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2018-01-01\",\n" +
                        "        \"checkout\" : \"2019-01-01\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                        "}");

    }

    public void preparePartialUpdateBookingRequest() {
        String token = tokenRequest.acessToken();
        restAction.newRequest();
        restAction.getRequest().
                accept(MediaType.JSON.value()).
                contentType(MediaType.JSON.value()).
                header("Cookie", "token=" + token).
                body("{\n" +
                        "    \"firstname\" : \"Tamirez\",\n" +
                        "    \"lastname\" : \"Guedes\"\n" +

                        "}");    }

    public void prepareDeleteBookingRequest() {
        restAction.newRequest();
    }

    public void prepareCreateBookingRequest() {
        restAction.newRequest();
        restAction.getRequest().
                contentType(ContentType.JSON).
                body("{\n" +
                        "    \"firstname\" : \"Milton\",\n" +
                        "    \"lastname\" : \"Denys\",\n" +
                        "    \"totalprice\" : 111,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2018-01-01\",\n" +
                        "        \"checkout\" : \"2019-01-01\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                        "}");
    }

    public void sendPostRequestCreateBooking() {
        restAction.sendPost(ApiUrls.BASE_URL + ApiUrls.BOOKING);
        restAction.printResponse();

    }

    public void sendGetRequestGetBooking(String id) {
        restAction.sendGet(ApiUrls.BASE_URL + ApiUrls.BOOKING + id);
        restAction.printResponse();

    }

    public void sendPutRequestUpdateBooking(String id) {
        restAction.sendPut(ApiUrls.BASE_URL + ApiUrls.BOOKING + id);
        restAction.printResponse();

    }

    public void sendPatchRequestPartialUpdateBooking(String id) {
        restAction.sendPatch(ApiUrls.BASE_URL + ApiUrls.BOOKING + id);
        restAction.printResponse();

    }

    public void sendDeleteRequestDeleteBooking(String id) {
        restAction.sendDelete(ApiUrls.BASE_URL + ApiUrls.BOOKING + id);
        restAction.printResponse();

    }

    public void sendGetRequestBookingId() {
        restAction.sendGet(ApiUrls.BASE_URL + ApiUrls.BOOKING);
        restAction.printResponse();

    }

    public void sendGetRequestHealthCheck() {
        restAction.sendGet(ApiUrls.BASE_URL + ApiUrls.HEALTH_CHECK);
        restAction.printResponse();

    }

    public void validateStatusCode(Integer statusCode) {
        restAction.validateStatusCode(statusCode);
    }
}
