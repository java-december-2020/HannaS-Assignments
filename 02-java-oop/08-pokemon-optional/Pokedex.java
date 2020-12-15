public class Pokedex extends AbstractPokemon{

    public void listPokemon(){
        for (int i = 0; i < myPokemon.size(); i++){
            System.out.println(myPokemon.get(i).getName());
        }
    }

    public String pokemonInfo(Pokemon pokemon){
        return "Name: " + pokemon.getName() + ", Type: " + pokemon.getType() + ", Health: " + pokemon.getHealth();
    }

}