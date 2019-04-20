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
		URL url;
		try{
			String a="https://pokeapi.co/api/v2/pokemon/24/";
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
            String outputLine="";
            /*try{
				while ((inputLine = br.readLine()) != null) {
					temp = inputLine.split(",");
					String temm = temp[13];
					System.out.println(temm.substring(0,18));
					System.out.println(temm.substring(0,18).equals("\"forms\":[{\"name\":\""));
					System.out.println(temp[13]);
					temp = temp[13].split(":");
					name = temp[2].substring(0,temp[2].length()-1);
					//System.out.println(name);
					name = name.substring(1);
					System.out.println(name);
				}
			}catch(Exception e){}
            */
            while((inputLine = br.readLine()) != null){
				outputLine = outputLine+inputLine;
			}
			//System.out.println(outputLine);
            br.close();
            JSONObject obj = new JSONObject(outputLine);
            JSONArray arr = obj.getJSONArray("forms");
           // for(int i = 0; arr.length()>0;i++){
				System.out.println(arr.getJSONObject(0).getString("name"));
			//}
            
            //System.out.println(pokeName);
		}catch (FileNotFoundException e){
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
/*
 * String url = "https://publicservice.com/feeds";
URL obj = new URL(url);

*/
