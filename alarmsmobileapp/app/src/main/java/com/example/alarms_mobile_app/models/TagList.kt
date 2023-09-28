package com.example.alarms_mobile_app.models

import androidx.compose.runtime.mutableStateListOf

object TagList {
    val tagList = mutableListOf(
        Tag("Personal", description = "Todos los días"),
        Tag("Trabajo", description = "Tareas laborales")
    )
}

