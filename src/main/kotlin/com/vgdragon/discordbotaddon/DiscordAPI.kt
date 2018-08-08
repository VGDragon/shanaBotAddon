package com.vgdragon.discordbotaddon

import com.vgdragon.discordbot.discord.json.*
import com.vgdragon.discordbot.discord.json.api.receive.Ban
import com.vgdragon.discordbot.discord.json.api.receive.GuildMember
import com.vgdragon.discordbot.discord.json.api.receive.InviteObject
import com.vgdragon.discordbot.discord.json.api.receive.InviteObjectWithMetadata
import com.vgdragon.discordbot.discord.json.api.send.ChannelModify
import com.vgdragon.discordbot.discord.json.api.send.CreateChannelInvite
import com.vgdragon.discordbot.discord.json.api.send.CreateGuildRole
import com.vgdragon.discordbot.discord.json.api.send.MessageSend
import com.vgdragon.discordbot.discord.json.websocket.payloadJson.MessageReceive

interface DiscordAPI{

    fun sendMessage(text: String, channelId: String) :MessageReceive?
    fun sendMessage(messageSend: MessageSend, channelId: String) :MessageReceive?

    fun sendMessage(messageSend: MessageSend) :MessageReceive?
    fun sendMessage(text: String) :MessageReceive?

    fun sendDMMessage(messageSend: MessageSend) :MessageReceive?
    fun sendDMMessage(text: String) :MessageReceive?


    fun deleteChannel()
    fun deleteChannel(channelID: String = "")
    fun getMessagesHistory(): List<MessageReceive>?

    fun createReaction(messageID: String, emoji: String)
    fun deleteOwnReaction(messageID: String, emoji: String)
    fun deleteReactionFromUser(messageID: String, emoji: String, userID: String)
    fun getReactionUser(messageID: String, emoji: String, userID: String = ""): List<User>?
    fun editMessage(messageID: String, content: String = "", embed: Embed? = null): MessageReceive?
    fun deleteMessage(messageID: String)
    fun deleteMessage(messageIDList: List<String>)

    fun getChannelInvites(): List<InviteObjectWithMetadata>?
    fun createChannelInvites(createChannelInvite: CreateChannelInvite? = null): InviteObject?

    fun getInvite(createChannelInvite: CreateChannelInvite? = null): InviteObject?


    fun getChannel(): Channel?
    fun deleteChannelPermission(overrideID: String)
    fun triggerTypingIndicator()
    fun getPinnedMessages(): List<MessageReceive>?
    fun deletePinnedChannelMessage(messageID: String)

    fun getGuildEmojis(): List<Emoji>?

    fun getGuildEmoji(emojiID: String): Emoji?
    fun createGuildEmoji(emojiName: String, imageUrl: String, roleIdList: List<String>): Emoji?
    fun editGuildEmoji(emojiID: String, newName: String = "", newRoles: List<String> = listOf()): Emoji?
    fun deleteGuildEmoji(emojiID: String)

    fun getGuild(): Guild?
    fun createChannel(channelModify: ChannelModify): Channel?
    fun editChannelPosition(editPosition: EditPosition)
    fun editChannel(channelModify: ChannelModify): Channel?
    fun getGuildMember(): List<GuildMember>?
    fun editGuildMember(userID: String, nick: String = "", roles: List<String> = listOf(), mute: Boolean = false, deaf: Boolean = false, channelID: String = "")

    fun kickMember(userID: String)
    fun banMember(userID: String, deleteMassageDays: Int = -1, reason: String = "")
    fun deleteMemberBan(userID: String)
    fun getGuildBan(userID: String): Ban?
    fun getGuildBan(): List<Ban>?
    fun getGuildRoles(): List<Role>?
    fun deleteRole(roleId: String)
    fun createGuildRole(createGuildRole: CreateGuildRole = CreateGuildRole()): Role?
    fun editGuildRole(roleId: String, createGuildRole: CreateGuildRole): Role?
    fun editGuildRolePosition(editPosition: EditPosition): List<Role>?
    fun editGuildRolePosition(editPositionList: List<EditPosition>):List<Role>?

    fun addRoleToMember(userID: String, roleId: String)
    fun deleteRoleFromMember(userID: String, roleId: String)

    fun leaveGuild()
}