package com.example.promart.presentation.screens

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.promart.presentation.components.TextBodyEllipsis
import com.example.promart.presentation.components.TextHeadingBold
import com.example.promart.presentation.components.TextSubtitle
import com.example.promart.core.utils.Constants
import com.example.promart.presentation.viewModel.ProductViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.promart.domain.model.Product
import com.example.promart.presentation.components.ProgressIndicator

@Composable
fun HomeScreen(navHostController: NavHostController, viewModel: ProductViewModel = hiltViewModel()) {
    val result = viewModel.productListStateHolder.value

    if (result.isLoading){
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center){
            ProgressIndicator()
        }
    }

    if (result.error.isNotBlank()){
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center){
            Text(text = result.error)
        }
    }

    if (result.data!=null) {
        ProductList(productList = result.data.products)
    }

}

@Composable
fun ProductList(productList: List<Product>) {
    LazyColumn(
        modifier = Modifier.background(color = MaterialTheme.colors.primary)
    ) {
        itemsIndexed(items = productList) { index, item ->
            ProductItem(item = item)
        }
    }
}

@Composable
fun ProductItem(item: Product) {
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