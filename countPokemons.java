import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.*;
import javax.net.ssl.HttpsURLConnection;
import org.json.*;

public class countPokemons{
	public static void main(String[] args){
		for(int i=1;i<=807;i++){
			print(i);
		}
	}
	public static void print(int pokedexNo){
		URL url;
		try{
			String a="https://pokeapi.co/api/v2/pokemon/"+Integer.toString(pokedexNo);
			url = new URL(a);
			
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
            BufferedReader br = new BufferedReader(
                               new InputStreamReader(conn.getInputStream()));

            String inputLine;
            String[] temp;
            String name;
            String outputLine="";
            while((inputLine = br.readLine()) != null){
				outputLine = outputLine+inputLine;
			}
            br.close();
            JSONObject obj = new JSONObject(outputLine);
            JSONArray arr = obj.getJSONArray("forms");
			System.out.println(arr.getJSONObject(0).getString("name"));
		}catch (FileNotFoundException e){
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}

