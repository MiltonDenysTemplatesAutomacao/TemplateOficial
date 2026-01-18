package md.automation.api.logic;
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
