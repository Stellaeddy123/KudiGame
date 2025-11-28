package pt.iade.ei.kudigame.model

import android.icu.text.CaseMap


data class Game(
    val id: String,
    val title: String,
    val genre: String,
    val shortDescription: String,
    val imageRestName: String? = null,
    val storeItem: List<StoreItem> = emptyList()
)