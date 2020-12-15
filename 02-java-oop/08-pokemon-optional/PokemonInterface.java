public interface PokemonInterface{

    public Pokemon createPokemon(String name, int health, String type);
    public String pokemonInfo(Pokemon pokemon);
    void listPokemon();
    

}