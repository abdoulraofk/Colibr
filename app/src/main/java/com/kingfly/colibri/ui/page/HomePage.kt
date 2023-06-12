package com.kingfly.colibri.ui.page

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.ServiceInfo
import android.provider.Settings
import android.view.accessibility.AccessibilityManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kingfly.colibri.R
import com.kingfly.colibri.ui.theme.ColibriTheme
import com.kingfly.colibri.utils.USSDService


fun GetAccessibility(activity: Activity?) {
    val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    activity?.startActivity(intent)
}

fun isAccessibilityServiceEnabled(
    context: Context,
    service: Class<out AccessibilityService?>
): Boolean {
    val am: AccessibilityManager =
        context.getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager
    val enabledServices: List<AccessibilityServiceInfo> =
        am.getEnabledAccessibilityServiceList(AccessibilityServiceInfo.FEEDBACK_ALL_MASK)
    for (enabledService in enabledServices) {
        val enabledServiceInfo: ServiceInfo = enabledService.resolveInfo.serviceInfo
        if (enabledServiceInfo.packageName.equals(context.packageName) && enabledServiceInfo.name.equals(
                service.name
            )
        ) return true
    }
    return false
}

@Composable
fun HomePage(activity: Activity? = null, navController: NavHostController = rememberNavController()) {
    val messageActivationAccessibilite = "Pour un meilleur fonctionnement de l'application, veuillez activiter l'accessibilité dans windows accessibility"
    val isEnableAccessibility = activity?.let {
            isAccessibilityServiceEnabled(
                it.applicationContext, USSDService::class.java
            )
        }

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

        Button(
            modifier = Modifier.padding(vertical = 16.dp),
            onClick = {
                if(isAccessibilityServiceEnabled(activity!!.applicationContext, USSDService::class.java)) {
                    navController.navigate("listepaiementcontact")
                } else {
                    GetAccessibility(activity)
                }
            }
        ) {
            Text("Demarrer")
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