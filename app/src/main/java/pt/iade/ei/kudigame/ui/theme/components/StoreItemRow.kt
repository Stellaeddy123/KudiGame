package pt.iade.ei.kudigame.ui.theme.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.ei.kudigame.model.StoreItem


@Composable
fun StoreItemRow(item: StoreItem, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {onClick() }
            .padding(4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = item.name)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = item.description)
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
