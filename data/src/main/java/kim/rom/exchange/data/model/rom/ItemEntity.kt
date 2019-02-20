package kim.rom.exchange.data.model.rom

data class ItemEntity(

        val image: Any? = null,

        val name: String? = null,

        val global: GlobalEntity? = null,

        val type: Int? = null,

        val sea: SeaEntity? = null,

        val globalSeaDiff: Int? = null
)