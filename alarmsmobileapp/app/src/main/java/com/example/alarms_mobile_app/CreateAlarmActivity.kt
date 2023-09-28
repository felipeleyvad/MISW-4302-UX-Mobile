package com.example.alarms_mobile_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.alarms_mobile_app.composables.NumberPicker
import com.example.alarms_mobile_app.models.Alarm
import com.example.alarms_mobile_app.models.AlarmList


class CreateAlarmActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val name = remember { mutableStateOf("") }
                val hour = remember { mutableStateOf(0) }
                val minute = remember { mutableStateOf(0) }

                TextField(
                    value = name.value,
                    onValueChange = { name.value = it },
                    label = { Text("Nombre de la Alarma") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
                )

                TimePicker(hour = hour, minute = minute, modifier = Modifier.padding(top = 16.dp))

                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = {
                    AlarmList.alarmList.add(Alarm(name.value, "${hour.value}:${minute.value}"))
                    finish()
                }, modifier = Modifier.align(Alignment.End)) {
                    Text("Guardar Alarma")
                }
            }

        }
    }
}

@Composable
fun TimePicker(hour: MutableState<Int>, minute: MutableState<Int>, modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        Text("Hora:")
        NumberPicker(value = hour, range = 0..23)
        Text("Minuto:")
        NumberPicker(value = minute, range = 0..59)
    }
}