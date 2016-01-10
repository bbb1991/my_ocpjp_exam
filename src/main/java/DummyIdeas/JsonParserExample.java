package DummyIdeas;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

import org.json.*;


public class JsonParserExample {
    public static void main(String[] args) throws IOException, URISyntaxException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter address: ");

        String address = scanner.nextLine();
        address = address.replaceAll("\\s", "+");
        scanner.close();
        URL url = new URL("http://maps.googleapis.com/maps/api/geocode/json?sensor=false&address=" + address);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.connect();

        InputStream inputStream = urlConnection.getInputStream();
        StringBuilder stringBuilder = new StringBuilder();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line;

        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }

        reader.close();

        String result = stringBuilder.toString();

        JSONObject jsonObject = new JSONObject(result);
        JSONArray jsonArray = jsonObject.getJSONArray("results");

        System.out.println(jsonArray.getJSONObject(0).get("formatted_address"));
        Double lat = (Double) jsonArray.getJSONObject(0).getJSONObject("geometry").getJSONObject("location").get("lat");
        Double lng = (Double) jsonArray.getJSONObject(0).getJSONObject("geometry").getJSONObject("location").get("lng");
        System.out.println("Latitude: " + lat);
        System.out.println("Longditute: " + lng);

        Desktop.getDesktop().browse(new URI("https://www.google.com/maps?q=" + lat + "+" + lng));

    }
}
