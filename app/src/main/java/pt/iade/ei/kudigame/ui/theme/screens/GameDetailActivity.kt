package pt.iade.ei.kudigame.ui.theme.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.ei.kudigame.model.Game
import pt.iade.ei.kudigame.model.SampleData

class GameDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val gameId = intent.getStringExtra("gameId")

        val game = SampleData.games.find { it.id == gameId }

        if (game == null) {
            finish()
            return
        }


        setContent {
            if (game != null) {
                GameDetailScreen(game)
            } else {
                Text("Erro: Jogo não encontrado")
            }
        }
    }
}

@Composable
fun GameDetailScreen(game: Game) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = game.title, style = MaterialTheme.typography.headlineLarge)

        Spacer(modifier = Modifier.height(20.dp))

        Image(
            painter = painterResource(id = game.imageRestName),
            contentDescription = game.title,
            modifier = Modifier.size(200.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Género: ${game.genre}", style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = game.shortDescription, style = MaterialTheme.typography.bodyMedium)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDetail() {
    GameDetailScreen(game = SampleData.games.first())
}
