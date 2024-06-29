package initiation.module4.solcity.data

import androidx.annotation.StringRes
import initiation.module4.solcity.R

enum class PlaceType(
    @StringRes val label: Int
) {
    ALL(label = R.string.label_all),
    BAR(label = R.string.label_bar),
    CONCERT_HALL(label = R.string.label_concert_hall),
    RESTAURANT(label = R.string.label_restaurant),
    PARK(label = R.string.label_park),
    OTHER(label = R.string.label_other),
    WORKING_ON(label = R.string.label_working_on);

    fun getMainCategories() : List <PlaceType> {
        return listOf(
            ALL, BAR, CONCERT_HALL, RESTAURANT, PARK, OTHER
        )
    }
}