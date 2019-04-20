import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.*;
import javax.net.ssl.HttpsURLConnection;

public class checkPokemon implements Runnable{
	String PokemonName;
	pokemonData pD;
	public checkPokemon(String PokemonName, pokemonData pD){
		this.PokemonName = PokemonName;
		this.pD = pD;
	}
	
	public void run(){
		check(PokemonName);
	}
	
	public void check(String pkName){
		URL url;
		try{
			String a="https://pokeapi.co/api/v2/pokemon/"+pkName+"/";
			url = new URL(a);
			
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
            // open the stream and put it into BufferedReader
            BufferedReader br = new BufferedReader(
                               new InputStreamReader(conn.getInputStream()));
            br.close();
            pD.add(pkName);
		}catch (Exception e){

		}
	}
}
