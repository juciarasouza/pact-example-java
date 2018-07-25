package teste.pact.providerNumber;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class IdController {

    @RequestMapping("/person/{name}/{surname}")
    public PersonInfo personId (@PathVariable String name, @PathVariable String surname){
        int idPerson = getIdRelatedToPerson();

        PersonInfo returInfo = new PersonInfo(name,surname,idPerson);
        return returInfo;
    }

    private int getIdRelatedToPerson(){
        Random randonId = new Random();

        return randonId.nextInt(19999-9999 + 1)+ 9999;
    }

}
