package kim.rom.exchange.domain.model.rom


enum class Sort(val value: String) {
    CHANGE("change"),
    DIFF("diff")
}

enum class SortDir(val value: String) {
    ASC("asc"),
    DESC("desc")
}

enum class SortServer(val value: String) {
    ALL("all"),
    GLOBAL("global"),
    SEA("sea")
}

enum class SortRange(val value: String) {
    ALL("all"),
    MONTH("month"),
    WEEK("week")
}

enum class Type(val itemId: Int, val itemName: String) {
    Weapons(1, "Weapons"),
    OffHand(2, "OffHand"),
    Armors(3, "Armors"),
    Garments(4, "Garments"),
    FootGears(5, "Foot gears"),
    Accessory(6, "Accessory"),
    Blueprint(7, "Blueprint"),
    PotionEffect(8, "Potion / Effect"),
    Refine(9, "Refine"),
    ScrollAlbum(10, "Scroll / Album"),
    Material(11, "Material"),
    HolidayMaterial(12, "Holiday material"),
    PetMaterial(13, "Pet material"),
    Premium(14, "Premium"),
    Costume(15, "Costume"),
    Head(16, "Head"),
    Face(17, "Face"),
    Back(18, "Back"),
    Mouth(19, "Mouth"),
    Tail(20, "Tail"),
    WeaponCard(21, "Weapon card"),
    OffHandCard(22, "Off-hand card"),
    ArmorCard(23, "Armor card"),
    GarmentsCard(24, "Garments card"),
    ShoeCard(25, "Shoe card"),
    AccessoryCard(26, "Accessory card"),
    HeadWearCard(27, "Head wear card")
}

data class ROMExchangeRequest(
        val kw: String,
        val exact: Boolean,
        val type: Type,
        val sort: Sort,
        val sortDir: SortDir,
        val sortServer: SortServer,
        val sortRange: String,
        val page: Int
)