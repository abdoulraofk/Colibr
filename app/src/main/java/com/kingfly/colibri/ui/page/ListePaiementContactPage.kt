package com.kingfly.colibri.ui.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListePaiementContact() {
    Column {
        PaiementContactItem()
        PaiementContactItem()
        PaiementContactItem()
    }
}

@Composable
fun PaiementContactItem() {
    Row(
        modifier = Modifier.padding(16.dp)
    ) {
        Box(modifier = Modifier
            .width(60.dp)
            .padding(4.dp)
            .aspectRatio(1f)
            .background(Color.Blue, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "K",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }

        Column(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Text(
                text = "KUELA ABDOUL RAOF",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 2.dp),
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = "12000 FCFA",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 2.dp),
                color = MaterialTheme.colorScheme.secondary
            )
            Text(
                text = "Pour ton anniversaire",
                modifier = Modifier.padding(vertical = 2.dp)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ListePaiementContactPreview() {
    ListePaiementContact()
}