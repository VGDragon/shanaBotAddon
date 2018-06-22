package com.vgdragon.discordbot.discord.json.websocket.payloadJson.connection.receive

import com.google.gson.JsonArray
import com.google.gson.JsonObject

data class Hello(public val obj: JsonObject){
    val heartbeat_interval:Long = obj.get("heartbeat_interval").asLong
    val _trace:JsonArray = obj.get("_trace").asJsonArray
}