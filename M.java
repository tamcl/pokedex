import java.lang.*;
import java.util.*;

public class M{
	public static ArrayList<Thread> ListOfThread = new ArrayList<Thread>();
	public static pokemonData pD = new pokemonData();
public M(){
	int longestName = 11, shortestName = 3;
	int currentlength = 4;
	int[] namestructure = new int[longestName];
	boolean go = true;
	int pokedexNo = 1;
	int maxpokemon = 807;
	int maxThread = 100;
	while(true){
		if(go==true){
			setThread(pokedexNo);
			pokedexNo++;
		}
		if(pokedexNo>=maxpokemon+1){
			break;
		}
		if(ListOfThread.size()>=maxThread&&go ==true){
			go=false;
		}
		if(go==false){
			boolean canGoAgain = true;
			for(Thread t:ListOfThread){
				if(t.isAlive()==true){
					canGoAgain = false;
					break;
				}
			}
			if(canGoAgain==true){
				go=true;
				clear();
			}
		}
		
	}
	joinThread();
	//start();
	//pD.print();
	//pD.number();
//	setThread(1);
}

	public static void setThread(int name){
		checkPokemon temp = new checkPokemon(name, pD);
		Thread t = new Thread(temp);
		t.start();
		ListOfThread.add(t);
	
	}
	
	public static void start(){
		for(Thread t:ListOfThread){
			t.start();
		}
	}
	
	public static void joinThread(){
		for(Thread temp: ListOfThread){
			try{
				temp.join();
			}catch(Exception e){}
		}
	}
	
	public static void clear(){
		ListOfThread = new ArrayList<Thread>();
	}
}
