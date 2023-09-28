package com.example.alarms_mobile_app.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NumberPicker(value: MutableState<Int>, range: IntRange) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Button(onClick = { if (value.value > range.first) value.value-- }) {
            Text("-")
        }
        Text(value.value.toString(), Modifier.size(48.dp))
        Button(onClick = { if (value.value < range.last) value.value++ }) {
            Text("+")
        }
    }
}
