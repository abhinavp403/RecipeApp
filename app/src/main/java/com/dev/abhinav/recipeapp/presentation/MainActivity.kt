package com.dev.abhinav.recipeapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dev.abhinav.recipeapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



//        setContent {
//            ScrollableColumn(modifier = Modifier
//                .fillMaxWidth()
//                .fillMaxHeight()
//                .background(color = Color(0xFFF2F2F2))
//            ) {
//                Image(
//                    bitmap = imageFromResource(res = resources, resId = R.drawable.happy_meal_small),
//                    modifier = Modifier.height(300.dp),
//                    contentScale = ContentScale.Crop,
//                    contentDescription = "Small Happy Meal"
//                )
//                Column(
//                        modifier = Modifier.padding(16.dp)
//                ) {
//                    Row(
//                            modifier = Modifier.fillMaxWidth(),
//                            horizontalArrangement = Arrangement.SpaceBetween
//                    ) {
//                        Text(
//                                text = "Happy Meal",
//                                style = TextStyle(
//                                        fontSize = TextUnit.Companion.Sp(26)
//                                )
//                        )
//                        Text(
//                                text = "$5.99",
//                                style = TextStyle(
//                                        color = Color(0xFF85bb65),
//                                        fontSize = TextUnit.Companion.Sp(17)
//                                ),
//                                modifier = Modifier.align(Alignment.CenterVertically)
//                        )
//                    }
//                    Spacer(modifier = Modifier.padding(top = 10.dp))
//                    Text(
//                            text = "800 calories",
//                            style = TextStyle(
//                                    fontSize = TextUnit.Companion.Sp(17)
//                            )
//                    )
//                    Spacer(modifier = Modifier.padding(top = 10.dp))
//                    Button(
//                            onClick = {},
//                            modifier = Modifier.align(Alignment.CenterHorizontally)
//                    ) {
//                        Text(text = "ORDER NOW")
//                    }
//                }
//            }
//        }
    }
}
