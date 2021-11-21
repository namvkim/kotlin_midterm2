package ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetnote.R
import com.example.jetnote.domain.model.ProductModel
import com.example.jetnote.routing.Screen
import com.example.jetnote.ui.components.TopAppBar
import com.example.jetnote.viewmodel.MainViewModel
import kotlinx.coroutines.launch
import ui.components.AppDrawer
import ui.components.Product
import ui.components.ProductRd
import ui.components.RunButton

@ExperimentalMaterialApi
@Composable
fun ProductsScreen(viewModel: MainViewModel) {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    var arr by remember {
        mutableStateOf(arrayOf(
            ProductModel(id = 0, title = "humberge", img = R.drawable.anh1),
            ProductModel(id = 1, title = "coca", img = R.drawable.anh2),
            ProductModel(id = 2, title = "7up", img = R.drawable.anh3),
            ProductModel(id = 3, title = "muiltea", img = R.drawable.anh4)
        ))
    }

    var random by remember {
        mutableStateOf(-1)
    }

    var s by remember {
        mutableStateOf("1")
    }

    var onClickDialog = remember { mutableStateOf(false)  }

    Scaffold(
        topBar = {
            TopAppBar(
                title = "Random",
                icon = Icons.Filled.List,
                onIconClick = {
                    coroutineScope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        scaffoldState = scaffoldState,
        drawerContent = {
            AppDrawer(currentScreen = Screen.Product,
                closeDrawerAction = {
                    coroutineScope.launch { scaffoldState.drawerState.close() }
                }
            )
        },
        content = {
            Column() {
                if(random==-1){
                    Text(
                        text = "Please! Click Run button ",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 36.sp
                        )
                    )
                }else{
                    Text(
                        text = "Lucky Product: "+(random+1).toString(),
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 36.sp,
                            color = Color.Red
                        )
                    )
                }
                RunButton{
                    random = -1
                    s.plus("sfsf")
                    while (random==-1 || arr[random].checked == false){
                        random=kotlin.random.Random.nextInt(0, arr.size-1)
                    }
                    onClickDialog.value = true
                }
                LazyColumn() {
                    items(count = arr.size) { index ->
                        val item = arr[index]
                        Product(product = item){
                            arr[index] = it
                        }
                    }
                }
                if (onClickDialog.value && random!=-1) {
                    AlertDialog(
                        onDismissRequest = {
                            onClickDialog.value = false
                        },
                        text = {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = "Product Random",
                                    style = TextStyle(
                                        fontSize = 28.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Red
                                    ),
                                    modifier = Modifier.padding(bottom = 32.dp)
                                )
                                ProductRd(
                                    title = arr[random].title,
                                    img = arr[random].img,
                                )

                            }
                        },
                        confirmButton = {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 16.dp)
                            ) {
                                Button(
                                    onClick = {
                                        onClickDialog.value = false
                                    }) {
                                    Text("Ok")
                                }
                            }
                        },
                    )
                }
            }
        }
    )
}
