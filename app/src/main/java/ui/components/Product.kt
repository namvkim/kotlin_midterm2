package ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetnote.R
import com.example.jetnote.domain.model.NoteModel
import com.example.jetnote.domain.model.ProductModel


@ExperimentalMaterialApi
@Composable
fun Product(
    product: ProductModel,
    onProductClick: (ProductModel) ->Unit={},
){
    var productState by remember {
        mutableStateOf(product)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                productState = product.copy(checked = !productState.checked)
                onProductClick.invoke(productState)
            },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Checkbox(
            checked = productState.checked,
            onCheckedChange = {
                productState = product.copy(checked = it)
                onProductClick.invoke(productState)
            },
            modifier = Modifier
                .align(alignment = Alignment.CenterVertically)
                .padding(16.dp)
        )
        Image(
            painter = painterResource(id = product.img),
            contentDescription = "",
            modifier = Modifier
                .width(120.dp)
                .height(100.dp),
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = product.title,
                style = TextStyle( fontSize = 20.sp ),
            )
        }
    }
}
