package com.example.businesscard

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
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
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard(
                        name = "Frank Lin",
                        position = "Assistant Manager",
                        phoneNum = "+886 (02) 25552587",
                        share = "@pcpartner",
                        email = "franklin@pcpartner.com",
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun NameCard(name: String, position: String, modifier: Modifier = Modifier) {

    Column (
        modifier =  modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        AndroidLogo(
            modifier = Modifier
                .width(150.dp)
                .background(colorResource(R.color.android_logo_bg_color))
        )

        Text(
            text = name,
            textAlign = TextAlign.Center,
            fontSize = 44.sp)

        Text(
            text = position,
            textAlign = TextAlign.Center,
            color = colorResource(R.color.android_green_color),
            fontSize = 16.sp,

        )
    }
}


@Composable
fun AndroidLogo(modifier: Modifier = Modifier){
    val img = painterResource(R.drawable.android_logo)
    Image(
        painter = img,
        contentDescription = null,
        modifier = modifier
    )
}

@Composable
fun Info(icon: ImageVector, info: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Top) {
        Icon(
            icon,
            contentDescription = null,
            tint = colorResource(R.color.android_green_color))
        Spacer(Modifier.width(20.dp))
        Text(
            text = info,
        )
    }
}

@Composable
fun InfoCard(phoneNum: String, share: String,
             email: String, modifier: Modifier = Modifier) {

    val myAppIcons = Icons.Rounded
    val phoneIcon = myAppIcons.Phone;
    val shareIcon = myAppIcons.Share;
    val mailIcon = myAppIcons.Email;

    Column (
        modifier =  modifier
    ) {
        Info(phoneIcon,phoneNum)
        Spacer(Modifier.height(10.dp))
        Info(shareIcon,share)
        Spacer(Modifier.height(10.dp))
        Info(mailIcon,email)
    }
}

@Composable
fun BusinessCard(name: String, position: String, phoneNum: String,
                 share: String, email: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(1.dp))
        NameCard(name, position)
        InfoCard(phoneNum, share, email, modifier = Modifier.padding(bottom = 32.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            BusinessCard(
                name = "Frank Lin",
                position = "Assistant Manager",
                phoneNum = "+886 (02) 25552587",
                share = "@pcpartner",
                email = "franklin@pcpartner.com",
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            )
        }
    }
}