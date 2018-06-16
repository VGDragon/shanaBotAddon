package com.vgdragon.discordbot.discord.json.websocket.payloadJson.connection.send

import com.github.salomonbrys.kotson.jsonObject
import com.google.gson.JsonObject

class Reconnect(
        val token: String,
        val session_id: String,
        val seq: Long
){

    fun getJson(): JsonObject{
        return jsonObject(
                "token" to token,
                "session_id" to session_id,
                "seq" to seq
        )
    }

}