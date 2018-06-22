package com.vgdragon.discordbot.discord.json.websocket.payloadJson.events

import com.vgdragon.discordbot.discord.json.Emoji

class GuildEmojisUpdateObject(
        val guild_id: String,
        val emojis: List<Emoji>
)