package com.vgdragon.discordbot.discord.json.websocket.payloadJson

import com.github.salomonbrys.kotson.jsonArray
import com.github.salomonbrys.kotson.jsonObject
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.vgdragon.discordbot.discord.json.Assents
import com.vgdragon.discordbot.discord.json.Party

data class Identity(
        var token:String = "",
        var properties: Properties?,
        var compress: Boolean = false,
        var large_threshold: Int = 50,
        var shard: Shard,
        var presence: Presence? = null
){

    fun getJson(): JsonObject {
        val pairList: MutableList<Pair<String, Any>> = mutableListOf()
        pairList.add(Pair("token", token))
        pairList.add(Pair("properties", if(properties == null) "" else properties!!.getJson().asJsonObject))
        if(compress)
            pairList.add(Pair("compress", compress))
        if(large_threshold > 250 || large_threshold < 50)
            pairList.add(Pair("large_threshold", 50))
        else
            pairList.add(Pair("large_threshold", large_threshold))


        pairList.add(Pair("shard", shard.getJson().asJsonArray))

        if(presence != null)
            pairList.add(Pair("shard", presence!!.getJson().asJsonObject))


        return jsonObject(pairList)


    }

}

data class Properties(
        var os: String = "linux",
        var browser: String = "disco",
        var device: String = "disco"
){

    fun getJson(): JsonObject {

        return jsonObject(
                "\$os" to os,
                "\$browser" to browser,
                "\$device" to device
        )

    }
}

data class Shard(
    var ownShartNumer: Long = 0,
    var maximalSharNumber: Long = 1
){

    fun getJson(): JsonArray {
        return jsonArray(ownShartNumer, maximalSharNumber)
    }
}

data class Presence(
        var since :Long = 0L,
        var game : Game? = null,
        var status : Status = Status.ONLINE,
        var afk :Boolean = false
){
    fun getJson(): JsonObject {

        return jsonObject(
                "since" to since,
                "game" to if(game == null) "null" else game!!.getJson().asJsonObject,
                "status" to
                        when(status){
                            Status.ONLINE -> "online"
                            Status.DO_NOT_DISTURB -> "dnd"
                            Status.AFK -> "idle"
                            Status.INVISIBLE_AND_SHOWN_AS_OFFLINE -> "invisible"
                            Status.OFFLINE -> "offline"
                        },
                "afk" to afk
        )

    }

}
enum class Status{
    AFK, ONLINE, DO_NOT_DISTURB, INVISIBLE_AND_SHOWN_AS_OFFLINE, OFFLINE
}


data class Game(
        var name: String = "",
        var type: ActivityType = ActivityType.GAME,
        var url: String = "",
        var timestamps: Timestamps? = null,
        var application_id: String = "",
        var details: String = "",
        var state: String = "",
        var party: Party? = null,
        var assets: Assents? = null
){

    fun getJson(): JsonObject{
        val pairList: MutableList<Pair<String, Any>> = mutableListOf()
        pairList.add(Pair("name", name))
        when(type){
            ActivityType.GAME -> pairList.add(Pair("type", 0))
            ActivityType.STREAMING -> {pairList.add(Pair("type", 1)); if(url.isNotBlank()) pairList.add(Pair("url", url))}
            ActivityType.LISTENING -> pairList.add(Pair("type", 2))
        }
        if(timestamps != null)
            pairList.add(Pair("timestamps", timestamps!!.getJson().asJsonObject))
        if(application_id.isNotBlank())
            pairList.add(Pair("application_id", application_id))
        if(details.isNotBlank())
            pairList.add(Pair("details", details))
        if(state.isNotBlank())
            pairList.add(Pair("state", state))
        if(party != null)
            pairList.add(Pair("party", party!!.getJson().asJsonObject))
        if(assets != null)
            pairList.add(Pair("assets", assets!!.getJson().asJsonObject))

        return jsonObject(
                pairList
        )
    }

}
enum class ActivityType{
    GAME, STREAMING, LISTENING
}

data class Timestamps(
        var start: Long = 0,
        var end: Long = 0
){

    fun getJson(): JsonObject{
        val pairList: MutableList<Pair<String, Any>> = mutableListOf()
        if(start > 0)
            pairList.add(Pair("start", start))
        if(end > 0)
            pairList.add(Pair("end", end))
        if(pairList.size > 1)
            return jsonObject()

        return jsonObject(pairList)
    }
}



data class PartySize(
        var currentSize: Int = 1,
        var maximalSize: Int = 1
) {

    fun getJson(): JsonArray{
        return jsonArray(currentSize, maximalSize)
    }
}

