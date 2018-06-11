package com.vgdragon.discordbot.discord.json.api.receive

import com.vgdragon.discordbot.discord.json.User
import java.util.*

class IntegrationObject(
        val id: String,
        val name: String,
        val type: String,
        val enabled: Boolean,
        val syncing: Boolean,
        val role_id: String,
        val expire_behavior: Int,
        val expire_grace_period: Int,
        val user: User,
        val account: AccountObject,
        val synced_at: Date
)

class AccountObject(
        val id: String,
        val name: String
)