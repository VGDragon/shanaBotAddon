package com.vgdragon.discordbot.discord.json.websocket.payloadJson.events

class MessageDeleteBulkObject(
        val ids: List<String>,
        val channel_id: String
)