package initiation.module4.solcity.ui.screen

import android.graphics.Paint.Align
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.twotone.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import initiation.module4.solcity.data.Place
import initiation.module4.solcity.ui.theme.SolCityTheme
import initiation.module4.solcity.R
import initiation.module4.solcity.data.provider.Bars

@Composable
fun PlaceDetailImage(
    place: Place,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Image(
            painter = painterResource(place.imageRes),
            contentDescription = stringResource(R.string.accessibility_waiting_place_picture),
            modifier = modifier
                .padding(dimensionResource(R.dimen.padding_small))
                .clip(shape = CardDefaults.shape)
        )
    }
}

@Composable
fun PlaceTypeAndScore(
    place: Place,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(top = dimensionResource(R.dimen.padding_medium)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Card(
            modifier = modifier,
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.secondaryContainer)
            ) {
                Text(
                    text = place.type.toString(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.labelLarge,
                )
                Row(
                    modifier = Modifier
                        .padding(dimensionResource(R.dimen.padding_small))
                ) {
                    for(i in 1..5)
                        DrawScoreStars(
                            score = place.score.value,
                            starNumber = i
                        )
                }
            }
        }
    }
}

@Composable
private fun DrawScoreStars(
    score: Int,
    starNumber: Int
) {
    if (starNumber <= score) {
        Icon(
            imageVector = Icons.Filled.Star,
            contentDescription = String
                .format(stringResource(R.string.accessibility_score),
                    score),
            tint = MaterialTheme.colorScheme.onSecondaryContainer
        )
    } else {
        Icon(
            imageVector = Icons.TwoTone.Star,
            contentDescription = String
                .format(stringResource(R.string.accessibility_score),
                    score)
        )
    }

}

@Composable
fun PlaceDescription(
    place: Place,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults
            .cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp),
        modifier = modifier
            .padding(top = dimensionResource(R.dimen.padding_medium))
    ) {
        Text(
            text = stringResource(R.string.places_description),
            textAlign = TextAlign.Justify,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            modifier = Modifier
                .padding(dimensionResource(R.dimen.padding_large))

        )
    }

}

@Composable
fun PlaceContactInformations(
    place: Place,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp),
        modifier = modifier.padding(dimensionResource(R.dimen.padding_medium))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .padding(dimensionResource(R.dimen.padding_small))
        ) {
            Icon(
                imageVector = Icons.Filled.Email,
                contentDescription = stringResource(R.string.accessibility_contact),
                tint = MaterialTheme.colorScheme.onSecondary,
                modifier = Modifier
                    .padding(end = dimensionResource(R.dimen.padding_medium))
            )
            Text(
                text = place.contact,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }
    }
}

@Composable
fun PlaceDetailScreen(
    place: Place,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(dimensionResource(R.dimen.padding_large))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .verticalScroll(state = rememberScrollState())
        ) {
            PlaceDetailImage(
                place = place
            )
            PlaceTypeAndScore(
                place = place
            )
            PlaceDescription(
                place = place
            )
            PlaceContactInformations(
                place = place
            )
        }
    }
}

@Preview
@Composable
fun PlaceDetailScreenPreview() {
    SolCityTheme {
        PlaceDetailScreen(Bars.getAllBars().get(0))
    }
}