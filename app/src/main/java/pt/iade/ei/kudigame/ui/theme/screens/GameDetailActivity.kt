package pt.iade.ei.kudigame.ui.theme.screens

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            GameDetailScreen(
                game = game,
                onBack = { finish() }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameDetailScreen(game: Game, onBack: () -> Unit = {}) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = game.title,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { onBack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.FavoriteBorder, contentDescription = "Favorite")
                    }
                }
            )
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF6EDF7))
                .padding(padding)
                .padding(16.dp)
        ) {

            item {

                Image(
                    painter = painterResource(id = game.imageRestName),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = game.shortDescription,
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = "Purchasable Items",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 12.dp)
                )
            }

            items(game.storeItems) { item ->

                val context = LocalContext.current

                PurchasableItemCard(
                    item = item,
                    onClick = {
                        val intent = Intent(context, StoreItemActivity::class.java)
                        intent.putExtra("itemId", item.id)
                        context.startActivity(intent)
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun PurchasableItemCard(item: StoreItem, onClick: () -> Unit) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(12.dp))
            .padding(12.dp)
            .clickable { onClick() }
    ) {

        Image(
            painter = painterResource(id = item.iconResId),
            contentDescription = item.name,
            modifier = Modifier
                .size(70.dp)
                .clip(RoundedCornerShape(10.dp)),
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
