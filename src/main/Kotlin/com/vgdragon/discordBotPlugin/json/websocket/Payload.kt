package com.vgdragon.discordbot.discord.json.websocket

import com.github.salomonbrys.kotson.jsonObject
import com.google.gson.JsonObject

class Payload(public val obj: JsonObject){

    val op:Int = obj.get("op").asInt
    val d = if(obj.isJsonNull)obj.get("d").asJsonNull else obj.get("d").asJsonObject
    val s:Long = obj.get("s").asLong
    val t:String = obj.get("t").asString
}

class SendPayload(op: Int, d: JsonObject, s: Long, t: String){

    val op:Int = op
    val d : JsonObject = d
    val s:Long = s
    val t:String = t
    fun getJson(): JsonObject{
        val pairList: MutableList<Pair<String, Any>> = mutableListOf()
        pairList.add(Pair("op", op))
        pairList.add(Pair("d", if(d.toString().isBlank()) "null" else d.asJsonObject))
        pairList.add(Pair("s", s))
        pairList.add(Pair("t", if(t.isBlank()) "null" else t))
        return jsonObject(pairList)

    }
}


