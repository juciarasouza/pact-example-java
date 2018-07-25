import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import org.junit.runner.RunWith;
import au.com.dius.pact.provider.junit.PactRunner;


@RunWith(PactRunner.class)
@Provider("ProviderPersonID")
@PactFolder("../pacts")
public class PersonIDContractTest {

    @State("There is a person: name Juciara - lastname: Teste")
    public void juciaraTest(){
        System.out.println("There is a person with wthi name Juciara and lastname Teste");
    }

    @TestTarget
    public final Target target = new HttpTarget(8120);

}
