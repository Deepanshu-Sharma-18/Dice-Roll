package com.example.dice

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@OptIn(DelicateCoroutinesApi::class)
@Composable
fun screen() {
    val image = remember {
        mutableStateOf(R.drawable.perspective_dice_six_faces_random)
    }
    Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFF0A0A0A)) {

        Card(
            modifier = Modifier
                .padding(horizontal = 40.dp, vertical = 100.dp)
                .fillMaxWidth(), shape = RoundedCornerShape(
                CornerSize(5.dp)
            ), elevation = 10.dp, backgroundColor = Color(0xFFF6F6FC)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){

                Spacer(modifier = Modifier.height(40.dp))
                Text(text = "DICE ROLL" , fontSize = 35.sp , fontWeight = FontWeight.Bold, fontFamily = FontFamily.Serif, color = Color.Black)
            }
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Card(
                modifier = Modifier
                    .padding(0.dp)
                    .height(200.dp), shape = RoundedCornerShape(
                    CornerSize(15.dp)
                ), elevation = 10.dp, backgroundColor = Color(0xFF0F37AD)
            ) {

                Image(painter = painterResource(id = image.value), contentDescription = "dice")
            }
            Spacer(
                modifier = Modifier.height(
                    200.dp
                )
            )
            Button(
                onClick = {
                    GlobalScope.launch {
                        random(image)
                    }
                },
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(corner = CornerSize(15.dp)))
                    .width(140.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Black
                )
            ) {
                Text(text = "ROLL", fontSize = 20.sp, color = Color.White)
            }
        }
    }
}

suspend fun random(image: MutableState<Int>) {
    val rand = (1..6).random()

    for (i in 1..30){
        if (i < 30){
            when(i%6){
                1 -> image.value = R.drawable.inverted_dice_1

                2 -> image.value = R.drawable.inverted_dice_2

                3 -> image.value = R.drawable.inverted_dice_3

                4 -> image.value = R.drawable.inverted_dice_4

                5 -> image.value = R.drawable.inverted_dice_5

                6 -> image.value = R.drawable.inverted_dice_6

            }
            delay(50L)
        }else{
            when(rand){
                1 -> image.value = R.drawable.inverted_dice_1

                2 -> image.value = R.drawable.inverted_dice_2

                3 -> image.value = R.drawable.inverted_dice_3

                4 -> image.value = R.drawable.inverted_dice_4

                5 -> image.value = R.drawable.inverted_dice_5

                6 -> image.value = R.drawable.inverted_dice_6

            }
        }

    }

}