package initiation.module4.solcity.data.provider

import initiation.module4.solcity.R
import initiation.module4.solcity.data.Place
import initiation.module4.solcity.data.PlaceScore
import initiation.module4.solcity.data.PlaceType

object DefaultPlace {
    fun getDefaultPlace() : Place {
        return Place(
            name = "Working on",
            type = PlaceType.WORKING_ON,
            description = R.string.in_construction,
            score = PlaceScore.ONE,
            contact = R.string.default_contact.toString(),
            imageRes = R.drawable.waiting_for_place_image
        )
    }

    fun getDefaultPlaceList() : List<Place> {
        // FIXME Add each category
        return Bars.getAllBars() +
            ConcertHalls.getAllConcertHalls() +
            Restaurants.getAllRestaurants() +
            Others.getAllOthers()
    }
}