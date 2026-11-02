package com.starchild13.flowcolumnexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.starchild13.flowcolumnexample.ui.theme.FlowColumnExampleTheme

/**
 * Main entry point for the application.
 * Displays a FlowColumn layout demonstrating multi-column chip selection.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlowColumnExampleTheme {
                FlowColumnExample()
            }
        }
    }
}

/**
 * Preview composable for Android Studio layout design tools.
 */
@Preview(showBackground = true)
@Composable
fun PreviewFlowColumn() {
    FlowColumnExampleTheme {
        FlowColumnExample()
    }
}

/**
 * Demonstrates the use of [FlowColumn] to display a list of items that flow vertically
 * and automatically wrap into subsequent columns as needed.
 */
@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun FlowColumnExample() {
    // Tracks the currently selected chip name; empty string indicates no selection.
    var selectedName by remember { mutableStateOf("") }

    val names = listOf(
        "Ronnie", "Harun", "Allela", "Tabby", "Jemimah", "Jessica", "Brayan", "Theo",
        "Frank", "Juma", "David", "Hannah", "Nathan", "Auwal", "Aniedi", "Sodiq"
    )

    FlowColumn(
        modifier = Modifier.padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        names.forEach { name ->
            ChipItem(
                text = name,
                isSelected = selectedName == name,
                onSelectedChange = { isSelected ->
                    // Toggle selection state: clear if already selected, otherwise select new name.
                    selectedName = if (isSelected) name else ""
                }
            )
        }
    }
}

/**
 * A reusable FilterChip composable item.
 *
 * @param text Display text for the chip.
 * @param isSelected Whether the chip is currently selected.
 * @param onSelectedChange Callback triggered when the chip selection state changes.
 */
@Composable
fun ChipItem(
    text: String,
    isSelected: Boolean,
    onSelectedChange: (Boolean) -> Unit
) {
    // Determine visual colors based on selection state.
    val backgroundColor = if (isSelected) Color(0xFFADD8E6) else Color.White
    val contentColor = if (isSelected) Color.Blue else Color.Black

    FilterChip(
        modifier = Modifier
            .padding(8.dp)
            .background(color = backgroundColor),
        selected = isSelected,
        onClick = {
            onSelectedChange(!isSelected)
        },
        label = { Text(text, color = contentColor) }
    )
}