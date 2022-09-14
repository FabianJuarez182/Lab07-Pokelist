package gt.uvg.pokelist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import gt.uvg.pokelist.databinding.FragmentDetailBinding
import gt.uvg.pokelist.databinding.FragmentMainBinding
import gt.uvg.pokelist.model.Pokemon
import gt.uvg.pokelist.repository.PokemonRepository

class DetailFragment : Fragment() {
    private val arg: DetailFragmentArgs by navArgs()
    private var Detailbinding: FragmentDetailBinding? = null
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Detailbinding = FragmentDetailBinding.inflate(inflater,container,false) //inflara el fragmento para mostrarlo
        return Detailbinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val InfoPokemon = Pokemon(arg.pokemonId, "") //obtendra el pokemon que se enviara por medio de argumentos
        Picasso.get().load(InfoPokemon.imageUrlFront).into(Detailbinding!!.imageView2)
        Picasso.get().load(InfoPokemon.imageUrlBack).into(Detailbinding!!.imageView3)
        Picasso.get().load(InfoPokemon.imageUrlShinnyFront).into(Detailbinding!!.imageView4)
        Picasso.get().load(InfoPokemon.imageUrlShinnyBack).into(Detailbinding!!.imageView5)

    }
}