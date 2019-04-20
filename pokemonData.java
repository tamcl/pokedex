import java.io.*;
import java.util.*;


public class pokemonData{
	private ArrayList<String> pokemon = new ArrayList<String>();
	public pokemonData(){
	
	}
	public void add(String Name){
		pokemon.add(Name);
		System.out.println(Name);
	}
	public void print(){
		for(String a:pokemon){
		System.out.print(a+", ");
		}
	}
}
