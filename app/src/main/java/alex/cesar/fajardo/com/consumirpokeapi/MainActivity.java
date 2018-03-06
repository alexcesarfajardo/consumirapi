package alex.cesar.fajardo.com.consumirpokeapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import alex.cesar.fajardo.com.consumirpokeapi.models.Pokemon;
import alex.cesar.fajardo.com.consumirpokeapi.models.PokemonAnswer;
import alex.cesar.fajardo.com.consumirpokeapi.pokeapi.PokeapiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Pokedex";

    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        takedata();

    }

    private void takedata() {

        PokeapiService service = retrofit.create(PokeapiService.class);
        Call<PokemonAnswer> pokemonAnswerCall = service.takePokemonList();

        pokemonAnswerCall.enqueue(new Callback<PokemonAnswer>() {
            @Override
            public void onResponse(Call<PokemonAnswer> call, Response<PokemonAnswer> response) {

                if(response.isSuccessful()) {

                    PokemonAnswer pokemonAnswer = response.body();
                    ArrayList<Pokemon> pokemonList = pokemonAnswer.getResults();

                    for (int i = 0; i < pokemonList.size(); i++){
                        Pokemon p = pokemonList.get(i);
                        Log.i(TAG, "Pokemon: " + p.getName());
                    }

                } else {
                    Log.e(TAG, "On response: " + response.errorBody());
                }

            }

            @Override
            public void onFailure(Call<PokemonAnswer> call, Throwable t) {

                Log.e(TAG, "On failure: " + t.getMessage());

            }
        });

    }
}
