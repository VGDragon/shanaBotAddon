package com.vgdragon.discordbot.discord.json.websocket.payloadJson.events

import java.util.*

class ChannelPinsUpdateObject(
        val channel_id: String,
        val last_pin_timestamp: Date
)