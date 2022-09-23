package gt.uvg.pokelist.model

data class PokemonResponse (
    val count: Int,
    val results: MutableList<Pokemon>
        )