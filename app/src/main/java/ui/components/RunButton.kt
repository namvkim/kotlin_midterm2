package ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@ExperimentalMaterialApi
@Composable
fun RunButton(onActiveClick:()->Unit){
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)
    ) {
        Button(
            onClick = {
                onActiveClick.invoke()
            },
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = Color.DarkGray,
            ),
        ) {
            Text(
                text = "Run",
                style = TextStyle(color = Color.LightGray)
            )
        }
    }
}

@Composable
fun Random(){

}

@ExperimentalMaterialApi
@Preview
@Composable
fun RunButtonPrivew(){
//    RunButton();
}