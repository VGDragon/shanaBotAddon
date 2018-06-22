package com.vgdragon.discordbot.discord.json.websocket

import com.github.salomonbrys.kotson.jsonObject
import com.google.gson.JsonObject

class HeatBeatClient(op: Int,d: Long){
    var op: Int = op
    var d: Long = d
    fun getJson(): JsonObject{
        return jsonObject(
                "op" to op,
                "d" to if (d > 0) d else "null"
        )
    }

}