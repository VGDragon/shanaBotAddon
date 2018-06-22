package com.vgdragon.discordbot.discord.json.websocket.payloadJson.events

import com.vgdragon.discordbot.discord.json.Emoji

class MessageReactionObject(
        val user_id: String,
        val channel_id: String,
        val message_id: String,
        val emoji: Emoji
)