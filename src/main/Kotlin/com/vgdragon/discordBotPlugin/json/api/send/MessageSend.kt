package com.vgdragon.discordbot.discord.json.api.send

import com.vgdragon.discordbot.discord.json.Embed

class MessageSend(
        var content: String = "",
        var nonce: String = "",
        var tts: Boolean = false,
        var file: String? = null,
        var embed: Embed? = null,
        var payload_json: String = ""
)
