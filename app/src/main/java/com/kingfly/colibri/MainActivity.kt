package com.kingfly.colibri

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kingfly.colibri.ui.page.DetailContactTransfertPage
import com.kingfly.colibri.ui.page.HomePage
import com.kingfly.colibri.ui.page.ListePaiementContact
import com.kingfly.colibri.ui.page.RechercherContactPage
import com.kingfly.colibri.ui.theme.ColibriTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColibriTheme() {
                NavigationView(this@MainActivity)
            }
        }
    }
}

@Composable
fun NavigationView(activity: Activity) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "recherchercontact") {
        composable("home") {
            HomePage(activity, navController)
        }
        composable("recherchercontact") {
            RechercherContactPage(activity)
        }
        composable("listepaiementcontact") {
            ListePaiementContact()
        }
        composable("detailcontact") {
            DetailContactTransfertPage()
        }
    }
}