package md.automation.api.logic;
import io.restassured.http.ContentType;
import md.automation.api.TokenRequest;
import md.automation.core.actions.rest.RestActions;
import md.automation.core.config.ApiUrls;

public class RestFullBookerLogic {

    private RestActions restAction;
    private TokenRequest tokenRequest;
    public RestFullBookerLogic(){
        restAction= new RestActions();
        tokenRequest = new TokenRequest();
    }

    public void setParameterHealthCheck(){
        restAction.newRequest();
    }
    public void setParameterBookingId(){
        restAction.newRequest();
    }
    public void setParameterCreateBooking(){
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
    public void sendPostRequestCreateBooking(){
        restAction.sendPost(ApiUrls.BASE_URL +ApiUrls.BOOKING);
        restAction.printResponse();

    }
    public void sendGetRequestBookingId(){
        restAction.sendGet(ApiUrls.BASE_URL +ApiUrls.BOOKING);
        restAction.printResponse();

    }
    public void sendGetRequestHealthCheck(){
        restAction.sendGet(ApiUrls.BASE_URL +ApiUrls.HEALTH_CHECK);
        restAction.printResponse();

    }
    public void validateStatusCode(Integer statusCode){
        restAction.validateStatusCode(statusCode);
    }
}
