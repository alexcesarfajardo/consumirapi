package alex.cesar.fajardo.com.consumirpokeapi.pokeapi;

import alex.cesar.fajardo.com.consumirpokeapi.models.PokemonAnswer;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Alex1 on 06/03/2018.
 */

public interface PokeapiService {

    @GET("pokemon")
    Call<PokemonAnswer> takePokemonList();




}
