package pt.iade.ei.kudigame.ui.theme.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.ei.kudigame.model.StoreItem

@Composable
fun StoreItemScreen(item: StoreItem) {
    StoreItemRow(item = item, onClick = {})
}

@Composable
fun StoreItemRow(item: StoreItem, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = item.name, style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = item.description)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Preço: $${"%.2f".format(item.price)}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewStoreItemRow() {
    StoreItemRow(
        item = StoreItem(
            id = "1",
            name = "Diablo®",
            description = "Participa na luta por Santuário",
            price = 13.99,
            iconResId = pt.iade.ei.kudigame.R.drawable.ic_launcher_foreground
        ),
        onClick = {}
    )
}
