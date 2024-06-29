package initiation.module4.solcity.data.provider

import initiation.module4.solcity.R
import initiation.module4.solcity.data.Place
import initiation.module4.solcity.data.PlaceScore
import initiation.module4.solcity.data.PlaceType

object Others {

    private val allOthers : List<Place> = listOf(
        Place(
            name = "Another One (Another \"Another\")",
            type = PlaceType.OTHER,
            description = R.string.places_description,
            score = PlaceScore.FIVE,
            contact = null,
            imageRes = R.drawable.waiting_for_place_image
        ),
        Place(
            name = "Bird's University (aka Oriol)",
            type = PlaceType.OTHER,
            description = R.string.places_description,
            score = PlaceScore.FIVE,
            contact = "oriol@university.com",
            imageRes = R.drawable.waiting_for_place_image
        ),
        Place(
            name = "Jazz Other",
            type = PlaceType.OTHER,
            description = R.string.places_description,
            score = PlaceScore.FOUR,
            contact = "@jazzOther",
            imageRes = R.drawable.waiting_for_place_image
        ),
        Place(
            name = "Mosquito Pound",
            type = PlaceType.OTHER,
            description = R.string.places_description,
            score = PlaceScore.THREE,
            contact = null,
            imageRes = R.drawable.waiting_for_place_image
        ),
        Place(
            name = "Cat, her Pillar",
            type = PlaceType.OTHER,
            description = R.string.places_description,
            score = PlaceScore.TWO,
            contact = "+33622222222",
            imageRes = R.drawable.waiting_for_place_image
        ),
        Place(
            name = "The Tree of Books",
            type = PlaceType.OTHER,
            description = R.string.places_description,
            score = PlaceScore.ONE,
            contact = "+33611111111",
            imageRes = R.drawable.waiting_for_place_image
        ),
        Place(
            name = "Sunny Tree",
            type = PlaceType.OTHER,
            description = R.string.places_description,
            score = PlaceScore.FOUR,
            contact = "@sunnytree",
            imageRes = R.drawable.waiting_for_place_image
        )
    )

    fun getAllOthers() : List<Place> {
        return allOthers
    }
}