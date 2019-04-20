import java.lang.*;
import java.util.*;

public class M{
	public static ArrayList<Thread> ListOfThread = new ArrayList<Thread>();
	public static pokemonData pD = new pokemonData();
public static void main(String[] args){
	String[] letter = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x" ,"y", "z", " ", "-", "'"};
	int lettersize = letter.length;
	int longestName = 11, shortestName = 3;
	int currentlength = shortestName;
	int[] namestructure = new int[longestName];
	
	
	for(int i=0;i<longestName;i++){
		namestructure[i]=lettersize;
	}
	for(int i=0;i<shortestName;i++){
		namestructure[i]=0;
	}
	namestructure[0]=12;
	
	while(longestName>=currentlength){
		String currentString = "";
		for(int i=0;i<currentlength;i++){
			currentString = currentString + letter[namestructure[i]];
		}
		//System.out.println(currentString);
		setThread(currentString);
		namestructure[currentlength-1]++;
		for(int i=currentlength-1;i>=0;i--){
			if(namestructure[i]>=lettersize&&i!=0){
				namestructure[i]=0;
				namestructure[i-1]++;
			}
		}
		if(namestructure[0]>=lettersize){
			currentlength++;
			for(int i=0;i<currentlength;i++){
				namestructure[i]=0;
			}
		}
		if(ListOfThread.size()>=300){
			joinThread();
		}
		
	}
}

	public static void setThread(String name){
		checkPokemon temp = new checkPokemon(name, pD);
		Thread t = new Thread(temp);
		t.start();
		ListOfThread.add(t);
	
	}
	
	public static void joinThread(){
		for(Thread temp: ListOfThread){
			try{
				temp.join();
			}catch(Exception e){}
		}
	}
	
	public void clear(){
		ListOfThread = new ArrayList<Thread>();
	}
}