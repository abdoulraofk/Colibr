package com.kingfly.colibri.ui.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kingfly.colibri.ui.theme.ColibriTheme

@Composable
fun DetailContactTransfertPage() {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        ListeTransaction()
        FaireTransfert()
    }
}

@Composable
fun TransactionItem() {
    Surface(
        modifier = Modifier.padding(16.dp),
        shape = RoundedCornerShape(33),
        color = MaterialTheme.colorScheme.secondary
    ) {
        Column(
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 29.dp)
        ) {
            Text(
                modifier = Modifier.padding(vertical = 9.dp),
                text = "12000 F - PP2200000000",
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.padding(vertical = 16.dp),
                text = "C'est les frais de transaction et les impayés. Merci de me comprendre."
            )
        }
    }
}

@Composable
fun ListeTransaction() {
    Column(
        modifier = Modifier
    ) {
        TransactionItem()
        TransactionItem()
        TransactionItem()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FaireTransfert() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        TextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Montant") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Message") },
            modifier = Modifier.fillMaxWidth()
        )
        Row(
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Button(
                onClick = {}
            ) {
                Text(text = "Vocal")
            }
            Button(
                onClick = {},
                modifier = Modifier.padding(horizontal = 8.dp)
            ) {
                Text(text = "Envoyer")
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailContactTransfertPagePreview() {
    ColibriTheme {
        DetailContactTransfertPage()
    }
}

@Preview(showBackground = true)
@Composable
fun ListeTransactionPreview() {
    ColibriTheme {
        ListeTransaction()
    }
}

@Preview(showBackground = true)
@Composable
fun FaireTransfertPreview() {
    ColibriTheme {
        FaireTransfert()
    }
}