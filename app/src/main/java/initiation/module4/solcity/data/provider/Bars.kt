package initiation.module4.solcity.data.provider

import initiation.module4.solcity.R
import initiation.module4.solcity.data.Place
import initiation.module4.solcity.data.PlaceScore
import initiation.module4.solcity.data.PlaceType

object Bars {
    private val allBars = listOf (
        Place(
            name = "Jazz'One",
            type = PlaceType.BAR,
            description = R.string.places_description,
            score = PlaceScore.THREE,
            contact = "+33666666666",
            imageRes = R.drawable.waiting_for_place_image
        ),
        Place(
            name = "Jam'Z",
            type = PlaceType.BAR,
            description = R.string.places_description,
            score = PlaceScore.FIVE,
            contact = "jamz@contact.com",
            imageRes = R.drawable.waiting_for_place_image
        ),
        Place(
            name = "Coltrane Land",
            type = PlaceType.BAR,
            description = R.string.places_description,
            score = PlaceScore.FOUR,
            contact = "@coltranesland",
            imageRes = R.drawable.waiting_for_place_image
        ),
        Place(
            name = "Bar'd Games",
            type = PlaceType.BAR,
            description = R.string.places_description,
            score = PlaceScore.THREE,
            contact = "@boardbardgamesbar",
            imageRes = R.drawable.waiting_for_place_image
        ),
        Place(
            name = "It's Raining Drinks and Dogs",
            type = PlaceType.BAR,
            description = R.string.places_description,
            score = PlaceScore.TWO,
            contact = "rainingdrinksdogs@contact.com",
            imageRes = R.drawable.waiting_for_place_image
        ),
        Place(
            name = "A Bubble Picture",
            type = PlaceType.BAR,
            description = R.string.places_description,
            score = PlaceScore.ONE,
            contact = "@bubblepicturebar",
            imageRes = R.drawable.waiting_for_place_image
        ),
        Place(
            name = "Another One (A - O.P.)",
            type = PlaceType.BAR,
            description = R.string.places_description,
            score = PlaceScore.FOUR,
            contact = "+33611111111",
            imageRes = R.drawable.waiting_for_place_image
        ),
    )

    fun getAllBars(): List<Place> {
        return allBars
    }
}