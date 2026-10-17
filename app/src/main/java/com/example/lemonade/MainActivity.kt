package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    Scaffold(
        topBar = {
            Text(
                text = stringResource(R.string.app_name),
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color(0xFFF9E44C))
                    .statusBarsPadding()
                    .padding(16.dp),
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
        }
    ) { innerPadding ->
        LemonadeWithButtonAndImage(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .wrapContentSize(Alignment.Center)
        )
    }
}
@Composable
fun LemonadeWithButtonAndImage(modifier: Modifier = Modifier) {
    var etapeActuelle by remember { mutableIntStateOf(1) }
    var nombrePression by remember { mutableIntStateOf(0) }
    var verre by remember { mutableIntStateOf(0) }
    val imageResource = when (etapeActuelle) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val textResource = when (etapeActuelle) {
        1 -> R.string.select_lemon
        2 -> R.string.squeeze_lemon
        3 -> R.string.drink_lemonade
        else -> R.string.restart_glass
    }

    val descriptionResource = when (etapeActuelle) {
        1 -> R.string.lemon_tree
        2 -> R.string.lemon
        3 -> R.string.glass_of_lemonade
        else -> R.string.empty_glass
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Button(
            onClick = {
                when (etapeActuelle) {
                    1 -> {
                        etapeActuelle = 2
                        nombrePression = (2..4).random()
                    }
                    2 -> {
                        nombrePression--
                        if (nombrePression == 0) {
                            etapeActuelle = 3
                            verre = (2..4).random()
                        }
                    }
                    3 -> {
                        verre--
                        if (verre == 0) {
                            nombrePression = 4
                        }
                    }
                    else -> nombrePression = 1
                }
            },
            shape = RoundedCornerShape(40.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFC3ECD2)
            )
        ) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = stringResource(descriptionResource),
                modifier = Modifier.padding(16.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(textResource),
            fontSize = 18.sp
        )
    }
}

