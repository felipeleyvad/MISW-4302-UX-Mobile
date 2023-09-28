package com.example.alarms_mobile_app.models

import androidx.compose.runtime.mutableStateListOf

object AlarmList {
    val alarmList = mutableListOf(
        Alarm("Despertar", "07:00"),
        Alarm("Reunión", "09:00")
    )
}