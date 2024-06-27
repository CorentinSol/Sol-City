package initiation.module4.solcity.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Place(
    val name: String,
    val type: PlaceType,
    @StringRes val description: Int,
    val score: PlaceScore,
    val contact: String,
    @DrawableRes val imageRes: Int
)