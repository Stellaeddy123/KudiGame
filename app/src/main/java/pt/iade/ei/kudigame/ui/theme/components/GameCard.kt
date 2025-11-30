package pt.iade.ei.kudigame.ui.theme.components

import pt.iade.ei.kudigame.model.StoreItem

data class GameCard(
    val id: String,
    val title: String,
    val genre: String,
    val shortDescription: String,
    val imageResName: String,
    val storeItem: List<StoreItem> = emptyList()
)