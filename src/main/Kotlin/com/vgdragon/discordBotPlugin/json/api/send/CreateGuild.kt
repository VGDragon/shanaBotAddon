package com.vgdragon.discordbot.discord.json.api.send

import com.github.salomonbrys.kotson.jsonArray
import com.github.salomonbrys.kotson.jsonObject
import com.google.gson.JsonObject
import com.vgdragon.discordbot.discord.getImageStringURIFromURL


class CreateGuild(
        val name: String,
        val region: Int = -1,
        val iconUrl: String = "",
        val verificationLevel: Int = -1,
        val defaultMessageNotifications: Int = -1,
        val explicitContentFilter: Int = -1,
        val roles: List<CreateGuildRole> = listOf(),
        val channels: List<ChannelModify> = listOf()
){

    fun getJson(): JsonObject{
        val list: MutableList<Pair<String, Any>> = mutableListOf()
        list.add(Pair("name", name))
        if(region >= 0)
            list.add(Pair("region", region))
        if(iconUrl.isNotBlank())
            list.add(Pair("icon", getImageStringURIFromURL(iconUrl)))
        if(verificationLevel >= 0)
            list.add(Pair("verification_level", verificationLevel))
        if(defaultMessageNotifications >= 0)
            list.add(Pair("default_message_notifications", defaultMessageNotifications))
        if(explicitContentFilter >= 0)
            list.add(Pair("explicit_content_filter", explicitContentFilter))
        if(roles.isNotEmpty())
            list.add(Pair("roles", jsonArray(roles)))
        if(channels.isNotEmpty())
            list.add(Pair("channels", jsonArray(channels)))
        return jsonObject(list)
    }
}