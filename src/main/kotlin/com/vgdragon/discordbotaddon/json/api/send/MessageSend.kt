package com.vgdragon.discordbot.discord.json.api.send

import com.vgdragon.discordbot.discord.json.Embed

/**
 * The maximum request size when sending a message is 8MB.
 */
class MessageSend(
        /**
         * the text of the Message
         * (up to 2000 characters)
         */
        var content: String = "",
        /**
         * a nonce that can be used for optimistic message sending
         */
        var nonce: String = "",
        /**
         * true if this is a TTS(Text to speech) message
         */
        var tts: Boolean = false,
        /**
         * the contents of the file being sent
         */
        var file: String? = null,
        /**
         * Embedded rich content
         */
        var embed: Embed? = null,
        /**
         * url-encoded JSON body used in place of the embed field
         */
        var payload_json: String = ""
)
