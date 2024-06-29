package initiation.module4.solcity.data

import androidx.annotation.StringRes
import initiation.module4.solcity.R

enum class PlaceType(
    @StringRes val label: Int,
    @StringRes val category: Int
) {
    ALL(label = R.string.label_all, category = R.string.label_all),
    BAR(label = R.string.label_bar, category = R.string.category_bars),
    CONCERT_HALL(label = R.string.label_concert_hall, category = R.string.category_concert_halls),
    RESTAURANT(label = R.string.label_restaurant, category = R.string.category_restaurants),
    PARK(label = R.string.label_park, category = R.string.category_parks),
    OTHER(label = R.string.label_other, category = R.string.category_others),
    WORKING_ON(label = R.string.label_working_on, category = R.string.label_working_on);

    fun getMainCategories() : List <PlaceType> {
        return listOf(
            ALL, BAR, CONCERT_HALL, RESTAURANT, PARK, OTHER
        )
    }
}