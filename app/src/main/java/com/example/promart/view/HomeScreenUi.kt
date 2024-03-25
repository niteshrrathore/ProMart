package com.example.promart.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.example.promart.components.TextBodyEllipsis
import com.example.promart.components.TextHeadingBold
import com.example.promart.components.TextSubtitle
import com.example.promart.utils.Constants
import com.example.promart.model.Item
import com.example.promart.model.Product
import com.example.promart.viewModel.ProductViewModel

@Composable
fun HomeScreen() {
    val viewModel: ProductViewModel = viewModel()
    val products: State<Product> = viewModel.products.collectAsState()
    val progress = remember {
        mutableStateOf(true)
    }

    if (progress.value){

    }
    ProductList(productList = products.value.products)

}

@Composable
fun ProductList(productList: List<Item>) {
    LazyColumn(
        modifier = Modifier.background(color = MaterialTheme.colors.primary)
    ) {
        itemsIndexed(items = productList) { index, item ->
            ProductItem(item = item)
        }
    }
}

@Composable
fun ProductItem(item: Item) {
        Card(
            modifier = Modifier
                .padding(8.dp, 4.dp)
                .fillMaxWidth()
                .height(130.dp), shape = RoundedCornerShape(6.dp), elevation = 4.dp
        ) {
            Surface() {
                Row(
                    Modifier.fillMaxSize()
                ) {
                    Image(
                        painter = rememberImagePainter(
                            data = item.thumbnail,
                        ),
                        contentDescription = item.description,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxHeight()
                            .clip(RoundedCornerShape(6.dp))
                            .weight(0.25f)
                    )

                    Column(
                        verticalArrangement = Arrangement.Top,
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(0.75f)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.End,
                            modifier = Modifier.fillMaxWidth()
                        ){
                            Text(
                                text = item.category,
                                style = MaterialTheme.typography.caption,
                                modifier = Modifier
                                    .background(Color.LightGray)
                                    .padding(6.dp, 2.dp, 6.dp, 2.dp)
                            )
                        }
                        Column(
                            verticalArrangement = Arrangement.Top,
                            modifier = Modifier
                                .padding(12.dp, 0.dp, 4.dp, 4.dp)
                                .fillMaxSize()
                        ){

                            TextSubtitle(txt = item.title)
                            TextHeadingBold(txt = Constants.CURRENCY.plus(item.price))
                            TextBodyEllipsis(txt = item.description)

                        }

                    }
                }
            }
        }
}