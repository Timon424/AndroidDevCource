package com.example.businesscard

import android.graphics.drawable.Icon
import android.os.Bundle
import android.webkit.WebSettings.TextSize
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .padding(bottom = 12.dp)
                    .width(100.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(color = Color.Blue),
                painter = painterResource(R.drawable.android_logo),
                contentDescription = null,
            )
            Text(
                text = stringResource(R.string.person_name),
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(bottom = 12.dp)
            )
            Text(
                text = stringResource(R.string.description),
                fontSize = 24.sp
            )
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            TextWithIcon(icon = painterResource(R.drawable.ic_launcher_foreground), text = stringResource(R.string.phone_number))
            TextWithIcon(icon = painterResource(R.drawable.ic_launcher_foreground), text = stringResource(R.string.e_mail))
            TextWithIcon(icon = painterResource(R.drawable.ic_launcher_foreground), text = stringResource(R.string.telegram))
        }
    }
}

@Composable
fun TextWithIcon(icon: Painter, text: String) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            modifier = Modifier.width(40.dp)
        )
        Text(
            text = text
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}