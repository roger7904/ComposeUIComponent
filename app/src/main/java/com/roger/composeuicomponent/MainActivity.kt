package com.roger.composeuicomponent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.roger.composeuicomponent.ui.UIApp
import com.roger.composeuicomponent.ui.theme.ComposeUIComponentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeUIComponentTheme {
                UIApp()
            }
        }
    }
}