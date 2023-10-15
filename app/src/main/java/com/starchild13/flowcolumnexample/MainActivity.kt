package com.starchild13.flowcolumnexample

import android.os.Bundle
import androidx.compose.foundation.background
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlowColumnExample()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFlowColumn() {
    FlowColumnExample()
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun FlowColumnExample() {
    val textChipRememberOneState = remember { mutableStateOf("") }
    FlowColumn(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        listOf("Ronnie", "Harun", "Allela", "Tabby", "Jemimah", "Jessica", "Brayan", "Theo",
            "Frank", "Juma", "David", "Hannah", "Nathan", "Auwal", "Aniedi", "Sodiq")
            .forEach { name -> ChipItem(name, textChipRememberOneState) }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChipItem(text: String, selected: MutableState<String>) {
    val isSelected = selected.value == text
    val backgroundColor = if (isSelected) Color(0xFFADD8E6) else Color.White
    val contentColor = if (isSelected) Color.Blue else Color.Black

    FilterChip(
        modifier = Modifier
            .padding(8.dp)
            .background(color = backgroundColor), // Setting background color using modifier
        selected = isSelected,
        onClick = {
            if (isSelected) selected.value = ""
            else selected.value = text
        },
        label = { Text(text, color = contentColor) }
    )
}








