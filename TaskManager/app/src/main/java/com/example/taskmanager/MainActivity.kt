package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskManagerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TaskCompletedInfo(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun TaskCompletedImg(modifier: Modifier = Modifier) {
    val img = painterResource(R.drawable.ic_task_completed)
    Image(
        painter = img,
        contentDescription = null,
        modifier = modifier
    )
}

@Composable
fun TaskCompletedInfo(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TaskCompletedImg()
        Text(
            text = stringResource(R.string.all_task_completed),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(0.dp, 24.dp, 0.dp, 8.dp)
        )
        Text(
            text = stringResource(R.string.nice_work),
            fontSize = 16.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TaskCompletedInfoPreview() {
    TaskManagerTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            TaskCompletedInfo(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}