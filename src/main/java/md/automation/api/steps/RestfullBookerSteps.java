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
        restFullBookerLogic.prepareHealthCheckRequest();

    }

    @When("envio uma requisicao GET para o endpoint")
    public void envio_uma_requisicao_get_para_o_endpoint() {
        restFullBookerLogic.sendGetRequestHealthCheck();
    }

    @Then("valido se o status code e {int}")
    public void valido_se_o_status_code_e(Integer statusCode) {
        restFullBookerLogic.validateStatusCode(statusCode);
    }

    @Given("que eu tenho um endpoint para get book id")
    public void queEuTenhoUmEndpointParaGetBookId() {
        restFullBookerLogic.prepareBookingIdRequest();
    }

    @When("envio uma requisicao GET para o endpoint de booking")
    public void envioUmaRequisicaoGETParaOEndpointDeBooking() {
        restFullBookerLogic.sendGetRequestBookingId();
    }

    @Given("que eu tenho um endpoint para get Create Booking")
    public void queEuTenhoUmEndpointParaGetCreateBooking() {
        restFullBookerLogic.prepareCreateBookingRequest();
    }

    @When("envio uma requisicao POST para o endpoint de Create Booking")
    public void envioUmaRequisicaoPostParaOEndpointDeCreateBooking() {
        restFullBookerLogic.sendPostRequestCreateBooking();
    }

    @Given("que eu tenho um endpoint com um id para Get Booking")
    public void queEuTenhoUmEndpointComUmIdParaGetBooking() {
        restFullBookerLogic.prepareGetBookingsRequest();
    }

    @When("envio uma requisicao GET para o endpoint de Get Booking com o id {string}")
    public void envioUmaRequisicaoGETParaOEndpointDeGetBooking(String id) {
        restFullBookerLogic.sendGetRequestGetBooking(id);
    }

    @Given("que eu tenho um endpoint com um id para Update Booking")
    public void queEuTenhoUmEndpointComUmIdParaUpdateBooking() {
        restFullBookerLogic.prepareUpdateBookingRequest();
    }

    @Given("que eu tenho um endpoint com um id para Partial Update Booking")
    public void queEuTenhoUmEndpointComUmIdParaPartialUpdateBooking() {
        restFullBookerLogic.preparePartialUpdateBookingRequest();

    }

    @Given("que eu tenho um endpoint com um id para Delete Booking")
    public void queEuTenhoUmEndpointComUmIdParaDeleteBooking() {
        restFullBookerLogic.prepareDeleteBookingRequest();

    }

    @When("envio uma requisicao PUT para o endpoint de Booking com o id {string}")
    public void envioUmaRequisicaoPUTParaOEndpointDeBookingComOId(String id) {
        restFullBookerLogic.sendPutRequestUpdateBooking(id);
    }

    @When("envio uma requisicao PATCH para o endpoint de Booking com o id {string}")
    public void envioUmaRequisicaoPATCHParaOEndpointDeBookingComOId(String id) {
        restFullBookerLogic.sendPatchRequestPartialUpdateBooking(id);

    }

    @When("envio uma requisicao DELETE para o endpoint de Booking com o id {string}")
    public void envioUmaRequisicaoDELETEParaOEndpointDeBookingComOId(String id) {
        restFullBookerLogic.sendDeleteRequestDeleteBooking(id);

    }
}
