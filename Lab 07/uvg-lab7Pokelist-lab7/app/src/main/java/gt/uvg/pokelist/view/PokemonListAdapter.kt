package gt.uvg.pokelist.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import gt.uvg.pokelist.databinding.ItemPokemonViewBinding
import gt.uvg.pokelist.model.Pokemon

class PokemonListAdapter(private val pokemonList: List<Pokemon>) : RecyclerView.Adapter<PokemonListAdapter.PokemonListHolder>() {

    inner class PokemonListHolder(val binding: ItemPokemonViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListHolder {
        val binding = ItemPokemonViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonListHolder(binding)
    }
//Este metodo asignara las propiedades al elemento seleccionado
    override fun onBindViewHolder(holder: PokemonListHolder, position: Int) {
        val pokemon = pokemonList[position]
        holder.binding.pokemonName.text =  pokemon.name
        Picasso.get().load(pokemon.imageUrlFront).into(holder.binding.pokemonPhoto)
        holder.itemView.setOnClickListener {
            val creacion = MainFragmentDirections.actionMainFragmentToDetailFragment(pokemonList.get(position).id)
            holder.binding.root.findNavController().navigate(creacion) // nose llevara al fragmento para ver los detalles
        }
    }

    override fun getItemCount(): Int { // Regresa el tamaño de la lista de pokemones
        return pokemonList.size
    }
}