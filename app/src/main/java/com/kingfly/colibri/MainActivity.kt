package com.kingfly.colibri

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
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

    NavHost(navController = navController, startDestination = "home") {
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