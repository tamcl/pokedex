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

public class checkPokemon implements Runnable{
	int PokemonName;
	pokemonData pD;
	public checkPokemon(int PokemonName, pokemonData pD){
		this.PokemonName = PokemonName;
		this.pD = pD;
	}
	
	public void run(){
		//System.out.println(PokemonName);
		check(PokemonName);
	}
	
	public void check(int pkName){
		URL url;
		boolean retry = true;
		String a="https://pokeapi.co/api/v2/pokemon/"+pkName+"/";
		while(retry){
			try{
				url = new URL(a);
				HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Content-Type", "application/json");
				conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
				// open the stream and put it into BufferedReader
				BufferedReader br = new BufferedReader(
								   new InputStreamReader(conn.getInputStream()));
				String inputLine;
				String[] temp;
				String name;
				String outputLine = "";
				try{
					while ((inputLine = br.readLine()) != null) {
						outputLine = outputLine + inputLine;
					}
				}catch(Exception e){e.printStackTrace();}
				br.close();
				
				JSONObject obj = new JSONObject(outputLine);
				JSONArray arr = obj.getJSONArray("forms");
				pD.add(PokemonName,arr.getJSONObject(0).getString("name"));
				retry = false;
			}catch (Exception e){
				retry = true;
			}
		}
	}
}
