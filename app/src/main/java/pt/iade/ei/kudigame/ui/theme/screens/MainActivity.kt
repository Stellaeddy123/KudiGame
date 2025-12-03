package pt.iade.ei.kudigame.ui.theme.screens

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.ei.kudigame.model.Game
import pt.iade.ei.kudigame.model.SampleData
import pt.iade.ei.kudigame.ui.theme.components.GameCard


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val games = SampleData.games

        setContent {
            MainScreen(games) { selectedGame ->
                val intent = Intent(this, GameDetailActivity::class.java)
                intent.putExtra("gameId", selectedGame.id)
                startActivity(intent)
            }
        }
    }
}

@Composable
fun MainScreen (games: List<Game>, onGameClick: (Game) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6EDF7)) //
            .padding(16.dp)

    ) {
        //
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Gudi Game",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Row {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = null,
                    modifier = Modifier.padding(horizontal = 12.dp)
                )
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = null
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        //
        LazyColumn {
            items(games) { game ->
                GameCard(
                    game = game,
                    onClick = { onGameClick(game) }
                )
                Spacer(modifier = Modifier.height(16.dp))

            }
        }
    }
}

@Composable
fun GameCard(game: Game, onGameClick: (Game) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(2.dp)
    ) {

        //
        Image(
            painter = painterResource(id = game.imageRestName),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        //
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            contentAlignment = Alignment.BottomStart
        ) {
            Text(
                text = game.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MainScreen(games = SampleData.games, onGameClick = { })
}