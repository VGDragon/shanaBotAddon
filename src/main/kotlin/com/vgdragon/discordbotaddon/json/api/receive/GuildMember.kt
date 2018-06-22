package com.vgdragon.discordbot.discord.json.api.receive

import com.vgdragon.discordbot.discord.json.User
import java.util.*

class GuildMember(
        val user: User,
        val nick: String,
        val roles: List<String>,
        val joined_at: Date,
        val deaf: Boolean,
        val mute: Boolean
        )