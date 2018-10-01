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

    /**
     * For sending messages to a given Discord Channel. It is for simple text sending.
     *
     * @param text the Text that will be send (maximal 2000 characters).
     * @param channelId the ID of the channel that should send to.
     */
    fun sendMessage(text: String, channelId: String)
    /**
     * For sending messages to a given Discord Channel. In the MessageSend you have diffed settings.
     * You can add a picture, link, Fields (with Title) and more.
     *
     * @param messageSend the MessageSend class with more setting for the message.
     * @param channelId the ID of the channel that should send to.
     */
    fun sendMessage(messageSend: MessageSend, channelId: String)
    /**
     * For sending messages to the same channel you got one. In the MessageSend you have diffed settings.
     * You can add a picture, link, Fields (with Title) and more.
     *
     * @param messageSend the MessageSend class with more setting for the message.
     */
    fun sendMessage(messageSend: MessageSend)
    /**
     * For sending messages to the same channel you got one. It is for simple text sending.
     *
     * @param text the Text that will be send (maximal 2000 characters).
     */
    fun sendMessage(text: String)
    /**
     * For sending Direct Message messages to the User you got one. It is for simple text sending to only the user.
     *
     * @param messageSend the MessageSend class with more setting for the message.
     */
    fun sendDMMessage(messageSend: MessageSend)
    /**
     * For sending Direct Message messages to the User you got one. It is for simple text sending to only the user.
     *
     * @param text the Text that will be send (maximal 2000 characters).
     */
    fun sendDMMessage(text: String)

    /**
     * To delete the channel the command is used into.
     */
    fun deleteChannel()
    /**
     * To delete the channel of the given channelID. Only work in the Discord server the command is used.
     *
     * @param channelID the channel ID
     */
    fun deleteChannel(channelID: String = "")

    /**
     * Give you the last 50 messages of the channel the command is used into.
     *
     * @return a list of the MessageReceive class sorted with newer first.
     */
    fun getMessagesHistory(): List<MessageReceive>?

    /**
     * For adding a Reaction to a Message.
     *
     * @param messageID ID of the message.
     * @param emoji for the basic emoji it is a symbol like ❌. For the custom one, you need the name of the emoji.
     */
    fun createReaction(messageID: String, emoji: String)
    /**
     * For deleting your own reaction from a Message.
     *
     * @param messageID ID of the message.
     * @param emoji for the basic emoji it is a symbol like ❌. For the custom one, you need the name of the emoji.
     */
    fun deleteOwnReaction(messageID: String, emoji: String)
    /**
     * For deleting a reaction from a user, from a Message.
     *
     * @param messageID ID of the message.
     * @param emoji for the basic emoji it is a symbol like ❌. For the custom one, you need the name of the emoji.
     * @param userID the ID from the user you want to remove the emoji.
     */
    fun deleteReactionFromUser(messageID: String, emoji: String, userID: String)
    /**
     * To get the User who used the given emoji. It the userID is not empty, you will get a List of Reaction User,
     * who added the reaction after the given userId
     *
     * @param messageID ID of the message.
     * @param emoji for the basic emoji it is a symbol like ❌. For the custom one, you need the name of the emoji.
     * @param userID give you a List of User, started after the given user.
     */
    fun getReactionUser(messageID: String, emoji: String, userID: String = ""): List<User>?

    /**
     * To edit a message.
     *
     * @param messageID the ID of the Message you want to edit.
     * @param content the new text of the Message
     * @param embed the new Embed as Embed Class.
     */
    fun editMessage(messageID: String, content: String = "", embed: Embed? = null): MessageReceive?

    /**
     * for deleting a Message.
     *
     * @param messageID the Id of the Message you want to delete.
     */
    fun deleteMessage(messageID: String)

    /**
     * To delete more as one Message.
     *
     * @param messageIDList a List of ID of the Messages you want to delete.
     */
    fun deleteMessage(messageIDList: List<String>)

    /**
     * To get all invites to the server.
     *
     * @return the List of InviteObjectWithMetadata Class of the Server.
     */
    fun getChannelInvites(): List<InviteObjectWithMetadata>?

    /**
     * To create a invite to a Channel.
     *
     * @param createChannelInvite the createChannelInvite Class (invite with settings).
     * @return the created Invite
     */
    fun createChannelInvites(createChannelInvite: CreateChannelInvite? = null): InviteObject?


    /*
    * Old
    */
    fun getInvite(createChannelInvite: CreateChannelInvite? = null): InviteObject?

    /**
     * To create a invite to a Channel.
     *
     * @param inviteCode Example: https://discord.gg/F9FKU9
     *                             inviteCode = F9FKU9
     * @return the asked Invite Class
     */
    fun getInvite(inviteCode: String, withCounts: Boolean = false): InviteObject?

    /**
     * To get the channel Class of the channel the command is used into.
     *
     * @return Channel Class
     */
    fun getChannel(): Channel?

    /**
     * To delete a permission in the channel the command is used into.
     *
     * @param overrideID UserId or RoleID
     */
    fun deleteChannelPermission(overrideID: String)

    /**
     * To show tipping.
     */
    fun triggerTypingIndicator()
    /**
     * To get a List of Pinned Messages of the channel the command is used into.
     *
     * @return List of MessageReceive Class that are pinned.
     */
    fun getPinnedMessages(): List<MessageReceive>?
    /**
     * To remove a Message as pinned in channel the command is used into.
     *
     * @param messageID of the message you want to remove from pinned.
     */
    fun deletePinnedChannelMessage(messageID: String)

    /**
     * To get a List of Emoji from the Server the command is used into.
     *
     * @return List of the Emoji Class
     */
    fun getGuildEmojis(): List<Emoji>?

    /**
     * To get the Emoji Class from a given Emoji.
     *
     * @param emojiID normally a big number.
     *
     * @return Emoji Class
     */
    fun getGuildEmoji(emojiID: String): Emoji?

    /**
     * With that function, you can make a new Emoji. Discord want the base64 image data
     * and a maximum file size of 256kb.
     * For that reason Bot take the picture, change the size(if to big) and encode it for you.
     *
     * @param emojiName the Name of the new Emoji.
     * @param imageUrl the url to the pic you want to use.
     * @param roleIdList roles for which this Emoji will be whitelisted.
     *
     * @return Emoji Class of the new created Emoji
     */
    fun createGuildEmoji(emojiName: String, imageUrl: String, roleIdList: List<String>): Emoji?

    /**
     * To can change the name and whitelisted Roles of an Emoji(only from the Server the command is used into).
     *
     * @param emojiID normally a big number.
     * @param newName new Name of the Emoji.
     * @param newRoles roles for which this Emoji will be whitelisted. The old list will be replaced.
     *
     * @return new Emoji Class of the edited Emoji
     */
    fun editGuildEmoji(emojiID: String, newName: String = "", newRoles: List<String> = listOf()): Emoji?

    /**
     * To delete an Emoji.
     *
     * @param emojiID normally a big number.
     */
    fun deleteGuildEmoji(emojiID: String)

    /**
     * To get the Guild Class of Server the command is used into.
     *
     * @return Gild Class
     */
    fun getGuild(): Guild?

    /**
     * To create a new Channel on the Server the command is used into.
     *
     *  @param channelModify the ChannelModify Class with the settings of the new Channel.
     *
     *  @return Channel Class of the new created Channel.
     */
    fun createChannel(channelModify: ChannelModify): Channel?
    /**
     * To move a Channel on the Server the command is used into.
     *
     *  @param editPosition the EditPosition Class with the settings of the Channel Position.
     */
    fun editChannelPosition(editPosition: EditPosition)

    /**
     * To edit Channel on the Server the command is used into.
     *
     *  @param channelModify the ChannelModify Class with the new settings of the Channel.
     *
     *  @return Channel Class of the edited Channel.
     */
    fun editChannel(channelModify: ChannelModify): Channel?

    /**
     * To edit Channel on the Server the command is used into.
     *
     *  @return List of Users Class of the Server the command is used into.
     */
    fun getGuildMember(): List<GuildMember>?

    /**
     * To edit a User of the Server the command is used into.
     *
     * @param userID the ID of the User you want to edit.
     * @param nick change the nike Name of the given User.
     * @param roles the new List of Roles (ID) of the User.
     * @param mute if the User is muted (Voice Channel)
     * @param deaf if the User can hear (Voice Channel)
     * @param channelID to move User to a Channel.
     */
    fun editGuildMember(userID: String, nick: String = "", roles: List<String> = listOf(), mute: Boolean = false, deaf: Boolean = false, channelID: String = "")

    /**
     * To kick member from the Server the command is used into.
     *
     * @param userID the ID if the User.
     */
    fun kickMember(userID: String)

    /**
     * To ban User from the Server the command is used into.
     *
     * @param userID the ID of the User.
     * @param deleteMassageDays the message range you want to delete from the given User. (-1 = nothing will deleted)
     * @param reason the Reason of the ban.
     */
    fun banMember(userID: String, deleteMassageDays: Int = -1, reason: String = "")

    /**
     * To remove the ban from a User from the Server the command is used into.
     *
     * @param userID the ID of the User.
     */
    fun deleteMemberBan(userID: String)

    /**
     * To get the ban Class from a User from the Server the command is used into.
     *
     * @param userID the ID of the User.
     *
     * @return the Ban Class
     */
    fun getGuildBan(userID: String): Ban?

    /**
     * To get a List of ban Class from the Server the command is used into.
     *
     * @return List of Ban Class
     */
    fun getGuildBan(): List<Ban>?

    /**
     * To get a List of Roles from the Server the command is used into.
     *
     * @return List of Roles Class
     */
    fun getGuildRoles(): List<Role>?

    /**
     * To delete a Roles from the Server the command is used into.
     *
     * @param roleId the ID of the Role.
     */
    fun deleteRole(roleId: String)

    /**
     * To create a Role on the Server the command is used into.
     *
     * @param createGuildRole the settings of the Role you want to create.
     *
     * @return new created Role Class
     */
    fun createGuildRole(createGuildRole: CreateGuildRole = CreateGuildRole()): Role?

    /**
     * To edit a Role on the Server the command is used into.
     *
     * @param roleId the ID of the Role
     * @param createGuildRole the new settings of the Role.
     *
     * @return edited Role Class
     */
    fun editGuildRole(roleId: String, createGuildRole: CreateGuildRole): Role?

    /**
     * To move the position of a Role on the Server the command is used into.
     *
     * @param editPosition the EditPosition Class with the settings of the Role position.
     *
     * @return List of Roles with changed position
     */
    fun editGuildRolePosition(editPosition: EditPosition): List<Role>?

    /**
     * To move the position of a List of Roles on the Server the command is used into.
     *
     * @param editPositionList the List of EditPosition Class with the settings of the Role position.
     *
     * @return List of Roles with changed position
     */
    fun editGuildRolePosition(editPositionList: List<EditPosition>):List<Role>?

    /**
     * To give a Role to a User on the Server the command is used into.
     *
     * @param userID the ID of the User you want to give the Role
     * @param roleId the ID of the Role you want to give the User
     */
    fun addRoleToMember(userID: String, roleId: String)

    /**
     * To remove a Role from a User.
     *
     * @param userID the ID of the User you want to remove the Role
     * @param roleId the ID of the Role you want to remove from the User
     */
    fun deleteRoleFromMember(userID: String, roleId: String)

    /**
     * To leave the Server the command is used into.
     */
    fun leaveGuild()
}