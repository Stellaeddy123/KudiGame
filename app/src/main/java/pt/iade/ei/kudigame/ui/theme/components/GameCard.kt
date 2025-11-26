package pt.iade.ei.kudigame.ui.theme.components

data class GameCard(
    val id: String,
    val title: String,
    val genre: String,
    val shortDescription: String,
    val imageResName: String? = null,
    val storeItem: List<StoreItem> = emptyList()
