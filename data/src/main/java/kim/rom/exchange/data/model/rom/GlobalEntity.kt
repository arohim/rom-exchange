package kim.rom.exchange.data.model.rom

data class GlobalEntity(

        val all: AllEntity? = null,

        val week: WeekEntity? = null,

        val month: MonthEntity? = null,

        val latest: Int? = null
)