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
            imageRes = R.drawable.concerthall_1
        ),
        Place(
            name = "A Place for Drum n' Bass",
            type = PlaceType.CONCERT_HALL,
            description = R.string.places_description,
            score = PlaceScore.FIVE,
            contact = "dnb@contact.com",
            imageRes = R.drawable.concerthall_2
        ),
        Place(
            name = "A Place for Improvised Music",
            type = PlaceType.CONCERT_HALL,
            description = R.string.places_description,
            score = PlaceScore.FOUR,
            contact = "improvised@contact.com",
            imageRes = R.drawable.concerthall_3
        ),
        Place(
            name = "A Little Big Concert Hall",
            type = PlaceType.CONCERT_HALL,
            description = R.string.places_description,
            score = PlaceScore.THREE,
            contact = "@lilbighall",
            imageRes = R.drawable.concerthall_4
        ),
        Place(
            name = "Havana Jazz",
            type = PlaceType.CONCERT_HALL,
            description = R.string.places_description,
            score = PlaceScore.TWO,
            contact = "@vanajazz",
            imageRes = R.drawable.concerthall_5
        ),
        Place(
            name = "Jazz Everywhere All At Once",
            type = PlaceType.CONCERT_HALL,
            description = R.string.places_description,
            score = PlaceScore.ONE,
            contact = "+33622222222",
            imageRes = R.drawable.concerthall_6
        ),
        Place(
            name = "Kingfisher Land",
            type = PlaceType.CONCERT_HALL,
            description = R.string.places_description,
            score = PlaceScore.FOUR,
            contact = "+33611111111",
            imageRes = R.drawable.concerthall_7
        )
    )

    fun getAllConcertHalls(): List<Place> {
        return allConcertHalls
    }
}