package com.firelion.composeissue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.ui.unit.sp
import com.firelion.composeissue.jb.JbBox

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JbBox {
                Text(text = "Everything is ok", fontSize = 24.sp)
            }
        }
    }
}
