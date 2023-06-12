package com.kingfly.colibri.ui.page

import android.Manifest
import android.R
import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.provider.ContactsContract
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.core.content.ContextCompat
import com.kingfly.colibri.data.Contact
import com.kingfly.colibri.ui.theme.ColibriTheme
import com.kingfly.colibri.utils.ContactService
import com.kingfly.colibri.utils.Lg


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RechercherContactPage(activity: Activity? = null) {
    ContactService.requestContactPermission(activity!!)
    val contacts: List<Contact> = ContactService.GetContactListe(activity!!)
    Lg.d("contacts liste" + contacts)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = "",
            onValueChange = {},
            placeholder = { Text("Rechercher contact") },
            leadingIcon = { Icon(
                Icons.Default.Search,
                contentDescription = null
            ) }
        )

        Column {
            ContactItem()
            ContactItem()
            ContactItem()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RechercherContactPreview() {
    ColibriTheme {
        RechercherContactPage()
    }
}

@Composable
fun ContactItem() {
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
                text = "07070707",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 2.dp),
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}

@Composable
fun ContactListe() {

}

@Preview(showBackground = true)
@Composable
fun ContactItemPreview() {
    ColibriTheme {
        ContactItem()
    }
}