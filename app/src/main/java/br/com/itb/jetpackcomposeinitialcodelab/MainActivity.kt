package br.com.itb.jetpackcomposeinitialcodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.itb.jetpackcomposeinitialcodelab.ui.theme.JetPackComposeInitialCodeLabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeInitialCodeLabTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting(Cliente("Adriano", "Domingues"))
                }
            }
        }
    }
}

data class Cliente(val nome: String, val sobrenome: String)

@Composable
fun Greeting(cliente: Cliente) {
    Row(modifier = Modifier.padding(all = 16.dp), verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start) {
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = "Foto do cliente",
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column(modifier = Modifier.padding(horizontal = 8.dp).border(1.0.dp, MaterialTheme.colors.primary, RectangleShape),
                verticalArrangement = Arrangement.SpaceAround,
            ) {
            Text(text = "Hello ${cliente.nome}!")
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Seu sobrenome é ${cliente.sobrenome}!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetPackComposeInitialCodeLabTheme {
        Greeting(Cliente("Adriano", "Domingues"))
    }
}