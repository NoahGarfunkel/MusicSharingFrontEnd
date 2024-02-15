//package com.example.musicsharing.ui.theme
//
//import android.graphics.drawable.shapes.Shape
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.wrapContentSize
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.style.LineHeightStyle
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//
//class Shapes {
//
//    @Composable
//    fun RoundedCornerShapeDemo(){
//        RectangleButton(shape = RoundedCornerShape(10.dp))
//    }
//    @Composable
//    fun RectangleButton(shape: Shape){
//        Column(modifier = Modifier.fillMaxWidth().wrapContentSize(LineHeightStyle.Alignment.Center)) {
//            Box(
//                modifier = Modifier.size(100.dp).clip(shape).background(Color.Red)
//            )
//        }
//    }
//
//}