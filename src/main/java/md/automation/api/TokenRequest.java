package md.automation.api;

import io.restassured.http.ContentType;
import md.automation.core.actions.rest.RestActions;
import md.automation.core.config.ApiUrls;

public class TokenRequest {

    private RestActions restAction;

    public TokenRequest(){
        restAction= new RestActions();
    }
    public String acessToken() {
        String token = null;
        restAction.newRequest();
        restAction.getRequest()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                        .body("{\n" +
                                "    \"username\" : \"admin\",\n" +
                                "    \"password\" : \"password123\"\n" +
                                "}");
        restAction.sendPost(ApiUrls.BASE_URL + ApiUrls.AUTH);
        token =restAction.getResponseValue("token");

        return token;
    }
}
