package com.vgdragon.discordBotPlugin

import com.vgdragon.discordbot.discord.json.api.send.MessageSend

interface DiscordAPI{

    fun sendMessage(text: String, channelId: String)
    fun sendMessage(messageSend: MessageSend, channelId: String)


}