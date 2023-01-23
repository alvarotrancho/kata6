package kata6;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.BufferedReader;
import java.io.IOException;
import static java.util.stream.Collectors.joining;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;



public class Kata6 {

    
    public static void main(String[] args) throws MalformedURLException, IOException, JAXBException {

        URL url = new URL("https://dummyjson.com/quotes");
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(read(url), JsonObject.class)
                .get("quotes").getAsJsonArray()
                //* Se va deserializando el elemento que necesita *//
                .get(5).getAsJsonObject(); 

        Quotes quote = gson.fromJson(jsonObject, Quotes.class);
        System.out.println(quote.toString());

        JAXBContext context = JAXBContext.newInstance(Quotes.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(quote, System.out);

        
    }

    private static String read(URL url) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return reader.lines().collect(joining());
        }           
    }
    
}
