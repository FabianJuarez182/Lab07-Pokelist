package gt.uvg.pokelist.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import gt.uvg.pokelist.R
import gt.uvg.pokelist.model.Pokemon
import gt.uvg.pokelist.repository.PokemonRepository
import gt.uvg.pokelist.model.PokemonResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailFragment : Fragment() {
    private val args by navArgs<DetailFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imgFront : ImageView = view.findViewById(R.id.imageView2)
        val imgBack : ImageView = view.findViewById(R.id.imageView3)
        val imgFrontS : ImageView = view.findViewById(R.id.imageView4)
        val imgBackS : ImageView = view.findViewById(R.id.imageView5)
        PokemonRepository.api.getPokemonById(args.id).enqueue(object : Callback<PokemonResponse> {
            override fun onResponse(
                call: Call<PokemonResponse>,
                response: Response<PokemonResponse>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    Picasso.get().load(response.body()!!.sprinkles.front_default).into(imgFront)
                    Picasso.get().load(response.body()!!.sprinkles.back_default).into(imgBack)
                    Picasso.get().load(response.body()!!.sprinkles.front_shiny).into(imgFrontS)
                    Picasso.get().load(response.body()!!.sprinkles.back_shiny).into(imgBackS)
                }

            }

            override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                Log.i("RESPONSE FAILURE", t.message.toString())
            }
        })


    }
    override fun onDestroyView() {
        super.onDestroyView()
    }

}