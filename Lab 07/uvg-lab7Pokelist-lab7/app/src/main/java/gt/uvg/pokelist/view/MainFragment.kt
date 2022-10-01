package gt.uvg.pokelist.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import gt.uvg.pokelist.R
import gt.uvg.pokelist.model.*
import gt.uvg.pokelist.repository.PokemonRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class MainFragment: Fragment(/*R.layout.fragment_main*/) {

    var bandera = false
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //api
        var pokemonList: List<Result>
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        PokemonRepository.api.getFirst100Pokemon().enqueue(object : Callback<Pokemon> {
            override fun onResponse(
                call: Call<Pokemon>,
                response: Response<Pokemon>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    pokemonList=response.body()!!.results
                    recyclerView.layoutManager = LinearLayoutManager(view.context);
                    recyclerView.adapter = PokemonListAdapter(pokemonList)
                    recyclerView.setHasFixedSize(true)
                }

            }

            override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                Log.i("RESPONSE FAILURE", t.message.toString())
            }
        })


    }
    override fun onDestroyView() {
        super.onDestroyView()
    }
}