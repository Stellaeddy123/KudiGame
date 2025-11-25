package pt.iade.ei.kudigame.model

import android.os.Parcelable
import kotlinx.Parcelize.Parcelize

@parcelize
data class StoreItem(
    val id: String,
    val name: String,
    val description: String,
    val price: Double,
    val imageRestName: String? = null
) : Parcelable