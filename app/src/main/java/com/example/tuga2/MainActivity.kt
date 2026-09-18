package com.example.tuga2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tuga2.ui.theme.Tuga2Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tuga2Theme {
                MainScreen()
            }
        }
    }

    @Composable
    fun MainScreen() {
        val textInput = remember {
            mutableStateOf("")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Nama: Erlangga Tri Frasdianto"
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = "NIM: 245150400111023"
            )

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            OutlinedTextField(
                value = textInput.value,
                onValueChange = { newText ->
                    textInput.value = newText
                },
                label = {
                    Text("Masukkan teks")
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Button(
                onClick = {

                    val intent = Intent(
                        this@MainActivity,
                        SecondActivity::class.java
                    )

                    intent.putExtra(
                        "text_input",
                        textInput.value
                    )

                    startActivity(intent)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Kirim")
            }
        }
    }
}
