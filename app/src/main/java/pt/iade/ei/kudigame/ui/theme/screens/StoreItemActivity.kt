package pt.iade.ei.kudigame.ui.theme.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import pt.iade.ei.kudigame.model.SampleData
import pt.iade.ei.kudigame.model.StoreItem
import pt.iade.ei.kudigame.ui.theme.components.StoreItemScreen

class StoreItemActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val itemId = intent.getStringExtra("itemId")
        val item = SampleData.games
            .flatMap { it.storeItems }
            .find { it.id == itemId }

        if (item == null) {
            finish()
            return
        }

        setContent {
            StoreItemScreen(item)
        }
    }
}
