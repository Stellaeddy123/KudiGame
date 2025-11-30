package pt.iade.ei.kudigame.model


data class StoreItem(
    val id: String,
    val name: String,
    val description: String,
    val price: Double,
    val iconRestName: Int,
)