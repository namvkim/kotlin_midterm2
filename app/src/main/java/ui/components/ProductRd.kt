package ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetnote.R

@ExperimentalMaterialApi
@Composable
fun ProductRd(
    title: String,
    img: Int
){
    Column() {
        Image(
            painter = painterResource(id = img),
            contentDescription = "",
            modifier = Modifier.width(120.dp).height(100.dp),
        )
        Text(
            text = title,
            style = TextStyle( fontSize = 20.sp ),
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun ProductRdPrivew(){
    ProductRd("Hamberge",R.drawable.anh1);
}