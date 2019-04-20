import java.io.*;
import java.util.*;


public class pokemonData{
	public HashMap<Integer,String> pokemon = new HashMap<Integer,String>();
	public int count = 0;
	public pokemonData(){
	
	}
	public void add(int no, String Name){
		pokemon.put(no,Name);
		count++;
		//System.out.println(no+"\t"+Name + "\t\t"+count);
	}
	public void print(){
		for(int i=1;i<808;i++){
			System.out.println(pokemon.get(i));
		}
	}
	public void number(){
		System.out.println(count);
	}
}
