package feature.steps;

import static org.hamcrest.Matchers.equalTo;

import driver.DriverTestInstance;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class SimuladorInvestPoupAPI extends DriverTestInstance {
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	
	@Given("cliente faz GET da URL {string}")
	public void clienteFazGetUrl(String url) throws Throwable {
		request = RestAssured.given();
		response = request.when().get(url);
	}

	@Then("o codigo de status da resposta deve ser {int}")
	public void verificarCodigoRespostaOk(Integer statusCode) throws Throwable {
		json = response.then().statusCode(statusCode);
	}

	@Then("a resposta deve conter no body o JSON")
	public void respostaContemJsonEsperado(String docJson) throws Throwable {
		JsonPath jsonEsperado = new JsonPath(docJson);
		json.assertThat().body("id", equalTo(jsonEsperado.getInt("id")));
		json.assertThat().body("meses", equalTo(jsonEsperado.getList("meses")));
		json.assertThat().body("valor", equalTo(jsonEsperado.getList("valor")));
	}
	
	@After
	public void aposExecucao() {
		driver.quit();
	}

}
