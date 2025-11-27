package pt.iade.ei.kudigame.ui.theme.screens

import android.R
import android.content.ClipData
import android.content.Intent
import android.os.Bundle
import android.renderscript.Sampler
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.w3c.dom.Text
import pt.iade.ei.kudigame.model.StoreItem


// terminar depois de criar a função
/*
class GameDetailActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val game :
    }
}
*/
@Composable
fun GameDetailScreen(game : Game, onBuy: (StoreItem)-> Unit) {
    val sheetState =
    val scope = rememberCoroutineScope()
    var selectedItem by remember { mutableSetOf<StoreItem?>(null) }

    ModalBottomSheetLayout(
        sheetContent = {
            selectedItem? .let { item ->
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = item.name, R.style = MaterialTheme.typography.h6)
                Spacer(Modifier.height(8.dp))
                Text(text = game.shortDescription)
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    // ação de comprar
                    onBuy(item)
                    // fechar sheet
                    scope.launch { sheetState.hide() }
                }) {
                    Text("Comprar por $${"%.2f".format(item.price)}")
                }
            }
        } ?: Box(modifier = Modifier .height(1.dp))
      },
      sheetState = sheetState
    ) {
        Column (modifier = Modifier.fillMaxSize() .padding(16.dp))
        Text( text = game.title, style = MaterialTheme.typography .h4)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = game.shortDescription)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Itens disponiveis:", style = MaterialTheme.typography.h6)
        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {
            items (game.storeItems) {item ->
                StoreItemRow (item = item, onClick = {
                    selectedItem = item
                    scope.launch { SheetState.show() }
                })
                Divider()
            }
         }
        }
      }

    }

















                Text("Itens disponiveis:", style = MaterialTheme.typography)
                }
            ) { }



            }
        }
}