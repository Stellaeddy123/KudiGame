package pt.iade.ei.kudigame.model


data class Game(
    val id: String,
    val title: String,
    val genre: String,
    val shortDescription: String,
    val imageRestName: Int,
    val storeItems: List<StoreItem>
)