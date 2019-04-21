public class Driver{
	public static void main(String[] args){
		M m = new M();
		System.out.println("M set");
		countPokemons cP = new countPokemons();
		System.out.println("cP set");
		
		int pokedex = 807;
		int count =1;
		boolean same = true;
		while(count<=pokedex){
			String com = m.pD.pokemon.get(count);
			String com1 = cP.pokemon.get(count);
			boolean correct = com.equals(com1);
			if(correct == false)same=false;
			System.out.println(count + "\t" + com +"\t\t\t" +com1+"\t\t\t"+correct);
			count++;
		}
		
		System.out.println("Is this two method the same? :" + same);
		
	}
}
