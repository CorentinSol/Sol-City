package initiation.module4.solcity.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import initiation.module4.solcity.R
import initiation.module4.solcity.data.Place
import initiation.module4.solcity.data.PlaceType
import initiation.module4.solcity.ui.utils.DrawScoreStars
import initiation.module4.solcity.ui.utils.PlaceTypeNavigationElements

@Composable
fun PlaceItemLabel(
    place: Place,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = stringResource(place.type.label),
            modifier = Modifier
                .padding(end = dimensionResource(R.dimen.padding_large))
        )
        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(20.dp)
        ) {
            for (i in 1..5) {
                DrawScoreStars(
                    score = place.score.value,
                    starNumber = i,
                    filledStarColor = MaterialTheme.colorScheme.onPrimary,
                )
            }
        }
    }
}

@Composable
fun PlaceItem(
    place: Place,
    isCurrentPlace: Boolean,
    needsSelectedCardColor: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val cardColor = if (isCurrentPlace) {
        CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer)
    } else {
        CardDefaults.cardColors(MaterialTheme.colorScheme.primary)
    }

    val textColor = if (isCurrentPlace) {
        MaterialTheme.colorScheme.onPrimaryContainer
    } else {
        MaterialTheme.colorScheme.onPrimary
    }

    Card(
        onClick = onClick,
        colors = if (needsSelectedCardColor) {
                cardColor
            } else {
                CardDefaults.cardColors(MaterialTheme.colorScheme.primary)
        },
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
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .weight(1F)
                    .padding(dimensionResource(R.dimen.padding_small))
                    .clip(CardDefaults.shape)
            )
            Column(
                modifier = Modifier
                    .weight(2F)
                    .padding(dimensionResource(R.dimen.padding_large))
            ){
                Text(
                    text = place.name,
                    color = if (needsSelectedCardColor) {
                        textColor
                    } else {
                        MaterialTheme.colorScheme.onPrimary
                    },
                    style = MaterialTheme.typography.titleLarge,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
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
fun BottomNavigationBarPlacesType(
    currentTab: PlaceType,
    navElements: List<PlaceTypeNavigationElements>,
    onClickOnPlaceTypeIcon: ((PlaceType) -> Unit),
    modifier: Modifier = Modifier
) {
    BottomAppBar(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.Bottom
        ) {
            for (navItem in navElements) {
                NavigationBarItem(
                    label = {
                        Text(
                            text = stringResource(navItem.placeType.category),
                            style = MaterialTheme.typography.labelSmall,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    selected = currentTab == navItem.placeType,
                    onClick = { onClickOnPlaceTypeIcon(navItem.placeType) },
                    icon = {
                        Icon(
                            painter = navItem.icon,
                            contentDescription = stringResource(navItem.placeType.label)
                        )
                    }
                )
            }
        }

    }
}

@Composable
fun PlaceListScreen(
    showBottomNavBar: Boolean,
    placeList: List<Place>,
    selectedPlace: Place,
    modifier: Modifier = Modifier,
    onClickOnPlaceCard: (Place) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        LazyColumn(
            contentPadding = PaddingValues(dimensionResource(R.dimen.padding_large)),
        ) {
            items(placeList) { item ->
                PlaceItem(
                    place = item,
                    needsSelectedCardColor = !showBottomNavBar, // Same screen size criteria
                    isCurrentPlace = item == selectedPlace,
                    onClick = { onClickOnPlaceCard(item) }
                )
            }
        }
    }
}

@Preview
@Composable
fun PlaceListScreenPreview() {
  //  PlaceListScreen(ConcertHalls.getAllConcertHalls(), onClick = { })
}