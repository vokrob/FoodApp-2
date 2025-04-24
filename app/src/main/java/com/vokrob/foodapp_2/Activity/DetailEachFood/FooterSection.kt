package com.vokrob.foodapp_2.Activity.DetailEachFood

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.vokrob.foodapp_2.R
import java.text.DecimalFormat

@Composable
fun FooterSection(
    onAddToCartClick: () -> Unit,
    totalPrice: Double,
    modifier: Modifier = Modifier
) {
    ConstraintLayout(
        modifier
            .height(75.dp)
            .fillMaxWidth()
            .background(colorResource(R.color.grey))
            .padding(horizontal = 16.dp)
    ) {
        val (orderBtn, price) = createRefs()

        Button(
            onClick = onAddToCartClick,
            shape = RoundedCornerShape(100.dp),
            colors = ButtonDefaults.buttonColors(colorResource(R.color.orange)),
            modifier = Modifier
                .width(140.dp)
                .height(50.dp)
                .constrainAs(orderBtn) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                }
        ) {
            Icon(
                painter = painterResource(R.drawable.cart),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )

            Spacer(Modifier.width(16.dp))

            Text(
                text = "Order",
                fontSize = 20.sp,
                color = Color.White
            )
        }

        Column(
            modifier = Modifier
                .width(140.dp)
                .height(50.dp)
                .constrainAs(price) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                }
        ) {
            Text(
                text = "Total Price",
                fontSize = 18.sp,
                color = colorResource(R.color.darkPurple)
            )

            val decimalFormat = DecimalFormat("#.00")

            Text(
                text = "$${decimalFormat.format(totalPrice)}",
                fontSize = 18.sp,
                modifier = Modifier.padding(top = 8.dp),
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.darkPurple)
            )
        }
    }
}
























