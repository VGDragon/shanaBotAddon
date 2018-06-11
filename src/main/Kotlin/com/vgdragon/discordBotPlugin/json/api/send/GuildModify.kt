package com.vgdragon.discordbot.discord.json.api.send

import com.vgdragon.discordbot.discord.json.Guild

class GuildModify (
    var name: String = "",
    var region: String = "",
    var verification_level: Int = -1,
    var default_message_notifications: Int = -1,
    var explicit_content_filter: Int = -1,
    var embed_channel_id: String = "",
    var afk_timeout: Long = -1L,
    var icon: String = "",
    var owner_id: String = "",
    var splash: String = "",
    var system_channel_id: String = ""
) {

    fun put(guild: Guild) {
        if (guild.name != null)
            name = guild.name
        if (guild.region != null)
            region = guild.region
        if (guild.verification_level != null)
            verification_level = guild.verification_level
        if (guild.default_message_notifications != null)
            default_message_notifications = guild.default_message_notifications
        if (guild.explicit_content_filter != null)
            explicit_content_filter = guild.explicit_content_filter
        if (guild.embed_channel_id != null)
            embed_channel_id = guild.embed_channel_id
        if (guild.afk_timeout != null)
            afk_timeout = guild.afk_timeout
        if (guild.icon != null)
            icon = guild.icon
        if (guild.owner_id != null)
            owner_id = guild.owner_id
        if (guild.splash != null)
            splash = guild.splash
        if (guild.system_channel_id != null)
            system_channel_id = guild.system_channel_id
    }

}