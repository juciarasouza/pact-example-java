package teste.pact.consumerID;


import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class FindPersonID {

    int port = 8120;


    FindPersonID() {

        System.out.println("custom port"+port);
    }

  FindPersonID(int port) {
        this.port = port;
        System.out.println("custom port"+port);
    }

    public Integer checkID(String name, String lastname) {
        try {
            String url = String.format("Http://localhost:%d/person/%s/%s", port, name, lastname);

            HttpResponse request = Request.Get(url).execute().returnResponse();

            String json = EntityUtils.toString(request.getEntity());

            JSONObject jsonObject = new JSONObject(json);

            String idPerson = jsonObject.get("id").toString();
            return new Integer(idPerson);

        } catch (Exception e) {
            System.out.println("Unable to get person ID, e=" + e);
            return null;
        }
    }

    public static void main (String[] args){

      //  Integer id = new FindPersonID().checkID("Juciara","Nepomuceno");
        Integer id = new FindPersonID().checkID("Juciara","Nepomuceno");

        System.out.print(id);

    }
}
