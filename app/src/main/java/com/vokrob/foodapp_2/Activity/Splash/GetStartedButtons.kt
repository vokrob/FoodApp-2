package com.vokrob.foodapp_2.Activity.Splash

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vokrob.foodapp_2.R

@Preview
@Composable
fun GetStartedButton(
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Row(
        modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Color.Transparent),
            shape = RoundedCornerShape(50.dp),
            modifier = modifier
                .padding(end = 16.dp)
                .fillMaxWidth(0.35f)
                .border(
                    width = 1.dp,
                    color = Color.White,
                    shape = RoundedCornerShape(50.dp)
                )
                .height(50.dp)
        ) {
            Text(
                text = "Sign Up",
                fontSize = 16.sp,
                color = Color.White
            )
        }

        Button(
            onClick = { onClick() },
            colors = ButtonDefaults.buttonColors(colorResource(R.color.orange)),
            shape = RoundedCornerShape(50.dp),
            modifier = modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(
                text = "Get Started",
                fontSize = 16.sp,
                color = Color.White
            )
        }
    }
}

























