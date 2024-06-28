package initiation.module4.solcity.ui.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.twotone.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import initiation.module4.solcity.R


@Composable
fun DrawScoreStars(
    score: Int,
    starNumber: Int,
    filledStarColor: Color,
    modifier: Modifier = Modifier
) {
    if (starNumber <= score) {
        Icon(
            imageVector = Icons.Filled.Star,
            contentDescription = String
                .format(
                    stringResource(R.string.accessibility_score),
                    score),
            tint = filledStarColor,
            modifier = modifier
        )
    } else {
        Icon(
            imageVector = Icons.TwoTone.Star,
            contentDescription = String
                .format(
                    stringResource(R.string.accessibility_score),
                    score),
            modifier = modifier
        )
    }
}
