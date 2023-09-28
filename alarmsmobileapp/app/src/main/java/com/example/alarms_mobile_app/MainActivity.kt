package com.example.alarms_mobile_app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.alarms_mobile_app.models.AlarmList
import com.example.alarms_mobile_app.models.TagList
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                topBar = {
                    TopAppBar(
                        backgroundColor = Color(0xFF12355B),
                        contentColor = Color.White,
                        title = { Text("No me olvides App") },
                        actions = {
                            IconButton(onClick = {
                                startActivity(Intent(this@MainActivity, CreateAlarmActivity::class.java))
                            }) {
                                Icon(Icons.Default.Add, contentDescription = "Crear Alarma")
                            }
                        }
                    )
                }
            ) {
                MainContent()
            }
        }
    }
}

@Composable
fun MainContent() {
    val selectedTab = remember { mutableStateOf(0) }
    val tabBackgroundColor = Color(0xFF12355B)
    val textColor = Color(0xFFFFFFFF)
    Column {
        TabRow(selectedTabIndex = selectedTab.value, backgroundColor = tabBackgroundColor) {
            Tab(selected = selectedTab.value == 0, onClick = { selectedTab.value = 0 }) {
                Box(modifier = Modifier.background(tabBackgroundColor)) {
                    Text("Alarmas", color = textColor)
                }
            }
            Tab(selected = selectedTab.value == 1, onClick = { selectedTab.value = 1 }) {
                Box(modifier = Modifier.background(tabBackgroundColor)) {
                    Text("Tags", color = textColor)
                }
            }
        }
        when (selectedTab.value) {
            0 -> AlarmListContent()
            1 -> TagListContent()
        }
    }
}

@Composable
fun TagListContent() {
    LazyColumn {
        items(TagList.tagList) { tag ->
            Text(tag.name)
        }
    }
}

@Composable
fun AlarmListContent() {
    LazyColumn {
        items(AlarmList.alarmList) { alarm ->
            Text("${alarm.name} - ${alarm.time}")
        }
    }
}


