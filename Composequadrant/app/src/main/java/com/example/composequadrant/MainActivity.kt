package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Quadrant(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ComposableText(title: String, content: String, color: Color, modifier: Modifier) {
    Box (
        modifier = modifier
            .fillMaxSize()
            .background(color)
    ){
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(color),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 16.dp)
            )
            Text(
                text = content,
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Composable
fun Quadrant(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        Row(
            modifier = Modifier.weight(1f)
        ){
            ComposableText(
                title = stringResource(R.string.text_composable_title),
                content = stringResource(R.string.text_composable_content),
                color = colorResource(R.color.text_composable_color),
                modifier = Modifier.weight(1f))

            ComposableText(
                title = stringResource(R.string.image_composable_title),
                content = stringResource(R.string.image_composable_content),
                color = colorResource(R.color.image_composable_color),
                modifier = Modifier.weight(1f))
        }

        Row(
            modifier = Modifier.weight(1f)
        ){
            ComposableText(
                title = stringResource(R.string.row_composable_title),
                content = stringResource(R.string.row_composable_content),
                color = colorResource(R.color.row_composable_color),
                modifier = Modifier.weight(1f))

            ComposableText(
                title = stringResource(R.string.column_composable_title),
                content = stringResource(R.string.column_composable_content),
                color = colorResource(R.color.column_composable_color),
                modifier = Modifier.weight(1f))
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Quadrant(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}