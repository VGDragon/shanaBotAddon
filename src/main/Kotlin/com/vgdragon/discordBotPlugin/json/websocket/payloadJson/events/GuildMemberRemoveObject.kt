package com.vgdragon.discordbot.discord.json.websocket.payloadJson.events

import com.vgdragon.discordbot.discord.json.User

class GuildMemberRemoveObject (
        val guild_id: String,
        val user: User
)