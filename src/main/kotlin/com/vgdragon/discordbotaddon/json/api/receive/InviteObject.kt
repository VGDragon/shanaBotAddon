package com.vgdragon.discordbot.discord.json.api.receive

import com.vgdragon.discordbot.discord.json.Channel
import com.vgdragon.discordbot.discord.json.Guild
import com.vgdragon.discordbot.discord.json.User
import java.util.*

class InviteObjectWithMetadata(

        /**
         * the invite code (unique ID)
         */
        val code : String,
        val guild : Guild,
        val channel : Channel,
        /**
         * 	approximate count of online members
         */
        val approximate_presence_count : Int,
        /**
         * 	approximate count of total members
         */
        val approximate_member_count : Int,
        /**
         * user who created the invite
         */
        val inviter :User,
        val uses :Int,
        val max_uses :Int,
        val max_age :Long,
        val temporary :Boolean,
        /**
         * ISO8601 timestamp
         */
        val created_at :Date,
        val revoked :Boolean
    )
class InviteObject(
        val code : String,
        val guild : Guild,
        val channel : Channel,
        val approximate_presence_count : Int,
        val approximate_member_count : Int
)