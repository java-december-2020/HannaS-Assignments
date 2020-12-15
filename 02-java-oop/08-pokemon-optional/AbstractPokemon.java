import java.util.ArrayList;
public abstract class AbstractPokemon implements PokemonInterface{

    ArrayList<Pokemon> myPokemon = new ArrayList<Pokemon>();

    public Pokemon createPokemon(String name, int health, String type){
        System.out.println("New Pokemon!");
        Pokemon newPoke = new Pokemon(name, health, type);
        this.myPokemon.add(newPoke);
        return newPoke; 
    }
    public abstract String pokemonInfo(Pokemon pokemon);
}