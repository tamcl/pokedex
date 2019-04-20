import java.io.*;
import java.util.*;


public class pokemonData{
	public ArrayList<String> pokemon = new ArrayList<String>();
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
	public void number(){
		System.out.println(pokemon.size());
	}
}
