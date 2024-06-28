package initiation.module4.solcity.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.twotone.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import initiation.module4.solcity.R
import initiation.module4.solcity.data.Place
import initiation.module4.solcity.data.provider.Bars
import initiation.module4.solcity.ui.utils.DrawScoreStars


@Composable
fun PlaceItemLabel(
    place: Place,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
    ) {
        Text(
            text = place.type.toString(),
            modifier = Modifier
                .padding(end = dimensionResource(R.dimen.padding_large))
        )
        for (i in 1..5) {
            DrawScoreStars(
                score = place.score.value,
                starNumber = i,
                filledStarColor = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@Composable
fun PlaceItem(
    place: Place,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary),
        elevation = CardDefaults.elevatedCardElevation(4.dp),
        modifier = modifier
            .padding(vertical = dimensionResource(R.dimen.padding_small))
            .height(100.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = dimensionResource(R.dimen.padding_medium))
        ) {
            Image(
                painter = painterResource(place.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .weight(1F)
                    .clip(CardDefaults.shape)
            )
            Column(
                modifier = Modifier
                    .weight(2F)
                    .padding(dimensionResource(R.dimen.padding_large))
            ){
                Text(
                    text = place.name,
                    style = MaterialTheme.typography.titleLarge,
                    maxLines = 1
                )
                PlaceItemLabel(
                    place = place,
                    modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
                )
            }
        }
    }
}

@Composable
fun PlaceListScreen(
    placeList: List<Place>,
    modifier: Modifier = Modifier,
    onClick: (Place) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(dimensionResource(R.dimen.padding_large)),
        modifier = modifier
            .fillMaxWidth()
    ) {
        items(placeList) { item ->
            PlaceItem(
                place = item,
                onClick = { onClick(item) }
            )
        }

    }
}

@Preview
@Composable
fun PlaceListScreenPreview() {
    PlaceListScreen(Bars.getAllBars(), onClick = { })
}