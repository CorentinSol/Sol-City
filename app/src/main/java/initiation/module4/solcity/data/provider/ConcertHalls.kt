package initiation.module4.solcity.data.provider

import initiation.module4.solcity.R
import initiation.module4.solcity.data.Place
import initiation.module4.solcity.data.PlaceScore
import initiation.module4.solcity.data.PlaceType

object ConcertHalls {
    private val allConcertHalls = listOf(
        Place(
            name = "A Place for Jazz",
            type = PlaceType.CONCERT_HALL,
            description = R.string.places_description,
            score = PlaceScore.FIVE,
            contact = "+33666666666",
            imageRes = R.drawable.waiting_for_place_image
        ),
        Place(
            name = "A Place for Drum n' Bass",
            type = PlaceType.CONCERT_HALL,
            description = R.string.places_description,
            score = PlaceScore.FIVE,
            contact = "dnb@contact.com",
            imageRes = R.drawable.waiting_for_place_image
        ),
        Place(
            name = "A Place for Improvised Music",
            type = PlaceType.CONCERT_HALL,
            description = R.string.places_description,
            score = PlaceScore.FOUR,
            contact = "improvised@contact.com",
            imageRes = R.drawable.waiting_for_place_image
        ),
        Place(
            name = "A Little Big Concert Hall",
            type = PlaceType.CONCERT_HALL,
            description = R.string.places_description,
            score = PlaceScore.THREE,
            contact = "@lilbighall",
            imageRes = R.drawable.waiting_for_place_image
        ),
        Place(
            name = "Havana Jazz",
            type = PlaceType.CONCERT_HALL,
            description = R.string.places_description,
            score = PlaceScore.TWO,
            contact = "@vanajazz",
            imageRes = R.drawable.waiting_for_place_image
        ),
        Place(
            name = "Jazz Everywhere All At Once",
            type = PlaceType.CONCERT_HALL,
            description = R.string.places_description,
            score = PlaceScore.ONE,
            contact = "+33622222222",
            imageRes = R.drawable.waiting_for_place_image
        ),
        Place(
            name = "Kingfisher Land",
            type = PlaceType.CONCERT_HALL,
            description = R.string.places_description,
            score = PlaceScore.FOUR,
            contact = "+33611111111",
            imageRes = R.drawable.waiting_for_place_image
        )
    )

    fun getAllConcertHalls(): List<Place> {
        return allConcertHalls
    }
}