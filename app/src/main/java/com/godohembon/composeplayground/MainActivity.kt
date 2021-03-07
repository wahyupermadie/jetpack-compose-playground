package com.godohembon.composeplayground

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.godohembon.composeplayground.ui.theme.ComposePlaygroundTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlaygroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.onPrimary) {
                    Home()
                }
            }
        }
    }
}

@Composable
fun AppBar(
    title: String, 
    action: () -> Unit
) {
    TopAppBar(
        title = {
            Text(text = title)   
        },
        navigationIcon = {
            IconButton(onClick = action) {
                Icon(Icons.Filled.ArrowBack, "")
            }
        },
        backgroundColor = Color.Blue,
        contentColor = Color.White,
        elevation = 12.dp
    )
}

@Composable
fun Home() {
    val context = LocalContext.current
    Scaffold(topBar = {
        AppBar(
            title = "Home Actviity",
            action = {
                Toast.makeText(context, "Back Clicked", Toast.LENGTH_SHORT).show()
            }
        )
    }) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePlaygroundTheme {
        Home()
    }
}