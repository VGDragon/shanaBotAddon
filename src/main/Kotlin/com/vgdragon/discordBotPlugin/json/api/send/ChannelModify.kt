package com.vgdragon.discordbot.discord.json.api.send

import com.github.salomonbrys.kotson.jsonArray
import com.github.salomonbrys.kotson.jsonObject
import com.google.gson.JsonObject
import com.vgdragon.discordbot.discord.json.Channel
import com.vgdragon.discordbot.discord.json.PermissionOverwrite

class ChannelModify {
    var name: String = ""
    var position: Int = -1
    var topic: String = ""
    var nsfw: Boolean = false
    var bitrate: Int = -1
    var user_limit: Int = -1
    var permission_overwrites: List<PermissionOverwrite> = mutableListOf()
    var parent_id: String = ""
    var type: Int = -1

    fun put(channel: Channel) {
        if (channel.name != null)
            name = channel.name
        if (channel.position != null)
            position = channel.position
        if (channel.topic != null)
            topic = channel.topic
        if (channel.nsfw != null)
            nsfw = channel.nsfw
        if (channel.bitrate != null)
            bitrate = channel.bitrate
        if (channel.user_limit != null)
            user_limit = channel.user_limit
        if (channel.permission_overwrites != null)
            permission_overwrites = channel.permission_overwrites
        if (channel.parent_id != null)
            parent_id = channel.parent_id
        if (channel.type != null)
            type = channel.type
    }

    fun getJson(): JsonObject {
        val list: MutableList<Pair<String, Any>> = mutableListOf()
        if (name.isNotBlank())
            list.add(Pair("name", name))
        if (position > -1)
            list.add(Pair("position", position))
        if (permission_overwrites.isNotEmpty()) {
            val permissionOverwriteJsonList: MutableList<JsonObject> = mutableListOf()
            for(po in  permission_overwrites)
                permissionOverwriteJsonList.add(po.getJson())
            list.add(Pair("permission_overwrites", jsonArray(permissionOverwriteJsonList)))
        }
        if (type < 0) {
            return jsonObject(list)
        }

        if (type == 0) {
            if (topic.isNotEmpty())
                list.add(Pair("topic", topic))
            list.add(Pair("nsfw", nsfw))
        }
        if (type == 2) {
            if (bitrate > -1)
                list.add(Pair("bitrate", bitrate))
            if (user_limit > -1)
                list.add(Pair("user_limit", user_limit))
        }
        if (type == 0 || type == 1) {
            if (parent_id.isNotEmpty())
                list.add(Pair("parent_id", parent_id))
        }
        return jsonObject(list)
    }


}