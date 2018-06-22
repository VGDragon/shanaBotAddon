package com.vgdragon.discordbot.discord.json.websocket.payloadJson.events

import com.vgdragon.discordbot.discord.json.User

class GuildMemberUpdateObject(
        val guild_id: String,
        val roles: List<String>,
        val user: User,
        val nick: String
        )