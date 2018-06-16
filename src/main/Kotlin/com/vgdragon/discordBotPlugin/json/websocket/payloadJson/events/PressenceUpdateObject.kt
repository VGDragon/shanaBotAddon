package com.vgdragon.discordbot.discord.json.websocket.payloadJson.events

import com.vgdragon.discordbot.discord.json.Activity
import com.vgdragon.discordbot.discord.json.Role
import com.vgdragon.discordbot.discord.json.User

class PressenceUpdateObject(
        val user: User,
        val roles: List<Role>,
        val game: Activity,
        val guild_id: String,
        val status: String
)