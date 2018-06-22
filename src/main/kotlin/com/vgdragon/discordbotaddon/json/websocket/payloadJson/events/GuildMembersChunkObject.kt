package com.vgdragon.discordbot.discord.json.websocket.payloadJson.events

import com.vgdragon.discordbot.discord.json.api.receive.GuildMember

class GuildMembersChunkObject(
        val guild_id: String,
        val members: List<GuildMember>
)