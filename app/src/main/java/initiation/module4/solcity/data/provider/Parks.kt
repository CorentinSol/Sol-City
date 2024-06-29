package initiation.module4.solcity.data.provider

import initiation.module4.solcity.R
import initiation.module4.solcity.data.Place
import initiation.module4.solcity.data.PlaceScore
import initiation.module4.solcity.data.PlaceType

object Parks {
    private val allParks : List<Place> = listOf(
        Place(
            name = "Space Between Park",
            type = PlaceType.PARK,
            description = R.string.places_description,
            score = PlaceScore.FIVE,
            contact = null,
            imageRes = R.drawable.waiting_for_place_image
        ),
        Place(
            name = "Park Blues",
            type = PlaceType.PARK,
            description = R.string.places_description,
            score = PlaceScore.FIVE,
            contact = null,
            imageRes = R.drawable.waiting_for_place_image
        ),
        Place(
            name = "Oriol Park",
            type = PlaceType.PARK,
            description = R.string.places_description,
            score = PlaceScore.FOUR,
            contact = null,
            imageRes = R.drawable.waiting_for_place_image
        ),
        Place(
            name = "Park'in'side by side",
            type = PlaceType.PARK,
            description = R.string.places_description,
            score = PlaceScore.THREE,
            contact = null,
            imageRes = R.drawable.waiting_for_place_image
        ),
        Place(
            name = "Another Park",
            type = PlaceType.PARK,
            description = R.string.places_description,
            score = PlaceScore.TWO,
            contact = null,
            imageRes = R.drawable.waiting_for_place_image
        ),
        Place(
            name = "Sol's Park",
            type = PlaceType.PARK,
            description = R.string.places_description,
            score = PlaceScore.ONE,
            contact = null,
            imageRes = R.drawable.waiting_for_place_image
        ),
        Place(
            name = "Cat's Park",
            type = PlaceType.PARK,
            description = R.string.places_description,
            score = PlaceScore.FOUR,
            contact = null,
            imageRes = R.drawable.waiting_for_place_image
        )
    )


    fun getAllParks() : List<Place> {
        return allParks
    }
}