package teste.pact.consumerID;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonArray;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import org.junit.Rule;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class FindPersonIDTest {

    //decribe the rule
    @Rule
    public PactProviderRuleMk2 provider = new PactProviderRuleMk2("ProviderPersonID", "localhost", 8112, this);

    @Pact(consumer = "PersonIDConsumer")
    public RequestResponsePact createPact (PactDslWithProvider buider){
        Map<String,String> headers = new HashMap<String, String>();
        headers.put("Content-Type","application/json");

        DslPart idResults = new PactDslJsonBody()
                .stringType("name", "Juciara")
                .stringType("lastname", "Teste")
                .integerType("id",19999)
                .asBody();

        return buider
                .given("There is a person: name Juciara - lastname: Teste")
                .uponReceiving("Upon receive a request for id")
                .path("/person/Juciara/tests")
                .method("GET")
                .willRespondWith()
                .status(200)
                .headers(headers)
                .body(idResults).toPact();

    }
    @Test
    @PactVerification()
    public void doTest() {
        System.setProperty("pact.rootDir","../pacts");  // Change output dir for generated pact-files
        Integer id = new FindPersonID(provider.getPort()).checkID("Juciara", "tests");
        assertTrue(id >= 0);
    }
}
