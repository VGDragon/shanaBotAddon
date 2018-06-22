package com.vgdragon.discordbot.discord.json.api.send

class CreateChannelInvite(
        val max_age : Long = 86400,
        val max_uses	 : Int = 0,
        val temporary	 : Boolean = false,
        val unique	 : Boolean = false
)