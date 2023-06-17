package com.kingfly.colibri.ui.page

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kingfly.colibri.R
import com.kingfly.colibri.ui.theme.ColibriTheme
import com.kingfly.colibri.utils.AccessibilityService.Companion.GetAccessibility
import com.kingfly.colibri.utils.Lg

@Composable
fun HomePage(activity: Activity? = null, navController: NavHostController = rememberNavController()) {
    val messageActivationAccessibilite = "Pour un meilleur fonctionnement de l'application, veuillez activiter l'accessibilité dans windows accessibility"

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(250.dp),
            painter = painterResource(id = R.drawable.transfer_money),
            contentDescription = ""
        )
        Text(
            text = messageActivationAccessibilite,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(horizontal = 52.dp),
            textAlign = TextAlign.Center
        )
        Text(
            text = "Paramètre > Accesibilité",
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Row {
            Button(
                modifier = Modifier.padding(vertical = 16.dp),
                onClick = {
                    GetAccessibility(activity)
                }
            ) {
                Text("Accéder")
            }

            Button(
                modifier = Modifier.padding(16.dp),
                onClick = {
                    navController.navigate("recherchercontact")
                },
                colors = ButtonDefaults.buttonColors(Color.White)
            ) {
                Text("Continuer", color = MaterialTheme.colorScheme.primary)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePagePreview() {
    ColibriTheme() {
        HomePage()
    }
}