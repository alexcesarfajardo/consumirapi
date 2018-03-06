package alex.cesar.fajardo.com.consumirpokeapi.models;

import java.util.ArrayList;

/**
 * Created by Alex1 on 06/03/2018.
 */

public class PokemonAnswer {

    private ArrayList<Pokemon> results;

    public ArrayList<Pokemon> getResults() {
        return results;
    }

    public void setResults(ArrayList<Pokemon> results) {
        this.results = results;
    }
}
