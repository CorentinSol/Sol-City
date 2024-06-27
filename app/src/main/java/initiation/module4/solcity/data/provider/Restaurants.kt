package initiation.module4.solcity.data.provider

import initiation.module4.solcity.R
import initiation.module4.solcity.data.Place
import initiation.module4.solcity.data.PlaceScore
import initiation.module4.solcity.data.PlaceType

object Restaurants {
    private val allRestaurants = listOf(
        Place(
            name = "First Restaurant",
            type = PlaceType.RESTAURANT,
            description = R.string.places_description,
            score = PlaceScore.FIVE,
            contact = "@firstrestaurant",
            imageRes = R.drawable.waiting_for_place_image
        ),
        Place(
            name = "Eat It",
            type = PlaceType.RESTAURANT,
            description = R.string.places_description,
            score = PlaceScore.FIVE,
            contact = "eatit@contact.com",
            imageRes = R.drawable.waiting_for_place_image
        ),
        Place(
            name = "It Eats ",
            type = PlaceType.RESTAURANT,
            description = R.string.places_description,
            score = PlaceScore.FOUR,
            contact = "iteats@contact.com",
            imageRes = R.drawable.waiting_for_place_image
        ),
        Place(
            name = "It Eats Telefon Maison",
            type = PlaceType.RESTAURANT,
            description = R.string.places_description,
            score = PlaceScore.THREE,
            contact = "+33611111111",
            imageRes = R.drawable.waiting_for_place_image
        ),
        Place(
            name = "Sol's Restaurant",
            type = PlaceType.RESTAURANT,
            description = R.string.places_description,
            score = PlaceScore.TWO,
            contact = "+33622222222",
            imageRes = R.drawable.waiting_for_place_image
        ),
        Place(
            name = "Another Restaurant",
            type = PlaceType.RESTAURANT,
            description = R.string.places_description,
            score = PlaceScore.ONE,
            contact = "+33666666666",
            imageRes = R.drawable.waiting_for_place_image
        ),
        Place(
            name = "Last Restaurant",
            type = PlaceType.RESTAURANT,
            description = R.string.places_description,
            score = PlaceScore.FOUR,
            contact = "@lastrestaurant",
            imageRes = R.drawable.waiting_for_place_image
        )
    )

    fun getAllRestaurants(): List<Place> {
        return allRestaurants
    }
}