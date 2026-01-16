package md.automation.api.logic;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import md.automation.core.actions.rest.RestActions;

public class RestFullBookerLogic {

/// TODO implementar logica das apis


    private final String baseUrl = "https://restful-booker.herokuapp.com/ping";
    private RestActions restAction;

    public RestFullBookerLogic(){
        restAction= new RestActions();
    }

    public void setParameterHealthCheck(){
        restAction.newRequest();
        restAction.getRequest().
                contentType(ContentType.JSON);
    }
    public void sendGetRequestHealthCheck(){
        restAction.sendGet(baseUrl);
    }


}
