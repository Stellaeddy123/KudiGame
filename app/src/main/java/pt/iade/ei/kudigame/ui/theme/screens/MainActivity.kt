package pt.iade.ei.kudigame.ui.theme.screens

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                intent.putExtra("game", selectedGame)
                startActivity(intent)
            }
        }
    }
}

@Composable
fun MainScreen(games: List<Game>, onGameClick: (Game) -> Unit ){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        items(games) {game ->
            GameCard(game = game, onClick = { onGameClick(game) })
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MainScreen(games = SampleData.games, onGameClick = {})
}