package md.automation.api.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import md.automation.api.logic.RestFullBookerLogic;

public class RestfullBookerSteps {

    private RestFullBookerLogic restFullBookerLogic;

    public RestfullBookerSteps() {
        restFullBookerLogic = new RestFullBookerLogic();
    }

    @Given("que eu tenho um endpoint para health check")
    public void que_eu_tenho_um_endpoint_para_health_check() {
        restFullBookerLogic.setParameterHealthCheck();

    }

    @When("envio uma requisicao GET para o endpoint")
    public void envio_uma_requisicao_get_para_o_endpoint() {
        restFullBookerLogic.sendGetRequestHealthCheck();
    }

    @Then("valido se o status code é {int}")
    public void valido_se_o_status_code_e(Integer statusCode) {
        restFullBookerLogic.validateStatusCode(statusCode);
    }

    @Given("que eu tenho um endpoint para get book id")
    public void queEuTenhoUmEndpointParaGetBookId() {
        restFullBookerLogic.setParameterBookingId();
    }

    @When("envio uma requisicao GET para o endpoint de booking")
    public void envioUmaRequisicaoGETParaOEndpointDeBooking() {
        restFullBookerLogic.sendGetRequestBookingId();
    }

    @Given("que eu tenho um endpoint para get Create Booking")
    public void queEuTenhoUmEndpointParaGetCreateBooking() {
        restFullBookerLogic.setParameterCreateBooking();
    }

    @When("envio uma requisicao GET para o endpoint de Create Booking")
    public void envioUmaRequisicaoGETParaOEndpointDeCreateBooking() {
        restFullBookerLogic.sendPostRequestCreateBooking();
    }
}
