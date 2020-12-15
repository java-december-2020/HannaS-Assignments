public class PokemonTester{

    public static void main(String[] args){
        Pokedex pokedex = new Pokedex();
        Pokemon pikachu = new Pokemon("Pikachu", 95, "electric");
        Pokemon squirtle = new Pokemon("Squirtle", 98, "water"); 


        pikachu.attackPokemon(squirtle);
        System.out.println(squirtle.getHealth());
        System.out.println(Pokemon.count);
        System.out.println(pokedex.pokemonInfo(squirtle));

        

    }
}