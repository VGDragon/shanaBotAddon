package com.vgdragon.discordbot.discord.json.api.receive

import com.vgdragon.discordbot.discord.json.Channel
import com.vgdragon.discordbot.discord.json.Guild
import com.vgdragon.discordbot.discord.json.User
import java.util.*

class InviteObjectWithMetadata(
    val code	                      : String,
    val guild	                      : Guild,
    val channel	                      : Channel,
    val approximate_presence_count    : Int,
    val approximate_member_count      : Int,
    val inviter	        :User,
    val uses	        :Int,
    val max_uses	    :Int,
    val max_age	        :Long,
    val temporary	    :Boolean,
    val created_at	    :Date,
    val revoked	        :Boolean
    )
class InviteObject(
    val code	                      : String,
    val guild	                      : Guild,
    val channel	                      : Channel,
    val approximate_presence_count    : Int,
    val approximate_member_count      : Int
)