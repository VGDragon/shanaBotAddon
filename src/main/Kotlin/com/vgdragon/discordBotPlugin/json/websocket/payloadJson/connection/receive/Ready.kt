package com.vgdragon.discordbot.discord.json.websocket.payloadJson.connection.receive

import com.vgdragon.discordbot.discord.json.Channel
import com.vgdragon.discordbot.discord.json.UnavailableGuild
import com.vgdragon.discordbot.discord.json.User

class Ready{
    val v: Int = 0
    val user: User = User()
    val private_channels: List<Channel> = mutableListOf()
    val guilds: List<UnavailableGuild> = mutableListOf()
    val session_id: String = ""
    val _trace: List<String> = mutableListOf()


}







