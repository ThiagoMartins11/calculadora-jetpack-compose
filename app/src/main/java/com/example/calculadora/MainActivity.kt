package com.example.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculadora.ui.theme.*
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppScreen()
        }
    }
}

@Composable
fun MyAppScreen(){
    CalculadoraTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            VerticalGradient()
            CalculadoraLayout()
        }
    }
}

@Composable
fun VerticalGradient(){
    val gradient = Brush.verticalGradient(
        0.0f to roxo_escuro,
        1.0f to laranja_escuro,
        startY = 0.0f,
        endY = 1500.0f
    )
    Box(modifier = Modifier.background(gradient))
}

@Composable
fun CalculadoraLayout(){
    var value1 by remember { mutableStateOf("") }
    var value2 by remember { mutableStateOf("") }
    var operator by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(Modifier.padding(16.dp)) {
        TextField(
            value = value1,
            onValueChange = {value1 = it},
            textStyle = TextStyle(Color.White),
            label = {Text(text = "value 1", color = Color.White)},
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White,
                cursorColor = Color.White
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.DarkGray)
        )
        TextField(
            value = value2,
            onValueChange = {value2 = it},
            textStyle = TextStyle(Color.White),
            label = { Text(text = "value 2", color = Color.White)},
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White,
                cursorColor = Color.White
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.DarkGray)
        )
        
        Row(
            Modifier
                .padding(vertical = 16.dp)
                .align(CenterHorizontally)) {
            Button(onClick = {operator = "+"},
                Modifier
                    .padding(5.dp)
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(
                                vermelho,
                                azul_claro
                            )
                        ),
                        shape = button_shape.small
                    ),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent
                ),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 0.dp,
                    pressedElevation = 0.dp,
                    hoveredElevation = 0.dp,
                    focusedElevation = 0.dp
                )
            ) {
                Text("➕")
            }
            Button(onClick = {operator = "-"},
                Modifier
                    .padding(5.dp)
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(
                                verde,
                                azul
                            )
                        ),
                        shape = button_shape.small
                    ),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent
                ),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 0.dp,
                    pressedElevation = 0.dp,
                    hoveredElevation = 0.dp,
                    focusedElevation = 0.dp
                )
            ) {
                Text("➖")
            }
            Button(onClick = {operator = "*"},
                Modifier
                    .padding(5.dp)
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(
                                amarelo_canario,
                                verde_agua
                            )
                        ),
                        shape = button_shape.small
                    ),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent
                ),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 0.dp,
                    pressedElevation = 0.dp,
                    hoveredElevation = 0.dp,
                    focusedElevation = 0.dp
                )
            ) {
                Text("✖")
            }
            Button(onClick = {operator = "/"},
                Modifier
                    .padding(5.dp)
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(
                                azul_ciano,
                                purple
                            )
                        ),
                        shape = button_shape.small
                    ),
                colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Transparent
            ),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 0.dp,
                pressedElevation = 0.dp,
                hoveredElevation = 0.dp,
                focusedElevation = 0.dp
            )
            ) {
                Text("➗", color = Color.White)
            }
        }
        Row(
            Modifier
                .padding(vertical = 16.dp)
                .align(CenterHorizontally)){
            when (operator){
                "+" -> (Text("Operação Soma", color = Color.White))
                "-" -> (Text("Operação Subtração", color = Color.White))
                "*" -> (Text("Operação Multiplicação", color = Color.White))
                "/" -> (Text("Operação Divisão", color = Color.White))
            }
        }
        Row(
            Modifier
                .padding(vertical = 16.dp)
                .align(CenterHorizontally)){
            Button(colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Green
            ) ,onClick = {
                if(value1.isNotEmpty() && value2.isNotEmpty() && operator.isNotEmpty()){
                    result = when (operator) {
                        "+" -> (value1.toDouble() + value2.toDouble()).toString()
                        "-" -> (value1.toDouble() - value2.toDouble()).toString()
                        "*" -> (value1.toDouble() * value2.toDouble()).toString()
                        "/" -> (value1.toDouble() / value2.toDouble()).toString()

                        else -> ""
                    }
                }
            }) {
                Text("=")
            }

        }
        Row(
            Modifier
                .padding(vertical = 16.dp)
                .align(CenterHorizontally)){
            Button(colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Red
            ) ,onClick = {
                value1 = ""
                value2 = ""
                operator = ""
                result = ""
            }) {
                Text("Clear", color = Color.White)
            }
        }

        Row(
            Modifier
                .padding(vertical = 16.dp)
                .align(CenterHorizontally)){
            if(result.isNotEmpty()){

                Text("$value1" + " $operator" + " $value2" + " =" + " $result", color = Color.White)
            }
        }
    }
    
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CalculadoraTheme {
        MyAppScreen()
    }
}