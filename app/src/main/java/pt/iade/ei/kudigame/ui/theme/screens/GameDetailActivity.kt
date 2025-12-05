package pt.iade.ei.kudigame.ui.theme.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
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
import pt.iade.ei.kudigame.R
import pt.iade.ei.kudigame.model.Game
import pt.iade.ei.kudigame.model.SampleData
import pt.iade.ei.kudigame.model.StoreItem

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
            GameDetailScreen(game)
        }
    }
}

@Composable
fun GameDetailScreen(game: Game) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6EDF7))
            .padding(16.dp)
    ) {

        item {

            // 🔹 TOP BAR
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier.size(28.dp)
                )

                Text(
                    text = game.title,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Favorite",
                    modifier = Modifier.size(28.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // 🔹 GAME IMAGE + DESCRIPTION (lado a lado)
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top
            ) {
                Image(
                    painter = painterResource(id = game.imageRestName),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(150.dp)
                        .background(Color(0xFFE0E0E0), MaterialTheme.shapes.medium)
                )

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = game.shortDescription,
                    fontSize = 16.sp,
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Purchasable Items",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 12.dp)
            )
        }

        // 🔹 LISTA DE ITENS
        items(game.storeItems) { item ->
            PurchasableItemCard(item)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun PurchasableItemCard(item: StoreItem) {


    val imageId = item.iconResId   // ⬅️ AQUI — direto do modelo

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, shape = MaterialTheme.shapes.medium)
            .padding(12.dp)
    ) {

        Image(
            painter = painterResource(id = imageId),
            contentDescription = item.name,
            modifier = Modifier
                .size(70.dp)
                .background(Color(0xFFE4E4E4), shape = MaterialTheme.shapes.small),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {

            Text(
                text = item.name,
                fontSize = 17.sp,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = item.description,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }

        Text(
            text = "$${"%.2f".format(item.price)}",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Top)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDetail() {
    GameDetailScreen(game = SampleData.games.first())
}
