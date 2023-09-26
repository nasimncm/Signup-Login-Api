package com.example.turegunew.models

import com.google.gson.annotations.SerializedName

data class ProfileModel(
    @SerializedName("code")
    val code: Int? = null,
    @SerializedName("data")
    val data: UserProfileData?=null,
    @SerializedName("message")
    val message: String?=null
)

data class UserProfileData(
    @SerializedName("agentEmailUnreadCount")
    val agentEmailUnreadCount: Int,
    @SerializedName("agentEnquiryUnreadCount")
    val agentEnquiryUnreadCount: Int,
    @SerializedName("bannersForCurrentPage")
    val bannersForCurrentPage: List<Any>,
    @SerializedName("companyEmailEnquiryUnreadCount")
    val companyEmailEnquiryUnreadCount: Int,
    @SerializedName("contactUnreadCount")
    val contactUnreadCount: Int,
    @SerializedName("newCompanyEnquiryUnreadCount")
    val newCompanyEnquiryUnreadCount: Int,
    @SerializedName("partnerEnquiryUnreadCount")
    val partnerEnquiryUnreadCount: Int,
    @SerializedName("profile")
    val profile: UserProfile,
    @SerializedName("propertyUnreadCount")
    val propertyUnreadCount: Int
)

data class UserProfile(
    @SerializedName("_id")
    val _id: String,
    @SerializedName("active")
    val active: Boolean,
    @SerializedName("addressBody")
    val addressBody: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("emailVerifiedAt")
    val emailVerifiedAt: String,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("followedAgents")
    val followedAgents: Int,
    @SerializedName("lang")
    val lang: ProfileLang,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("preferences")
    val preferences: ProfilePreferences,
    @SerializedName("regDate")
    val regDate: String,
    @SerializedName("tureguId")
    val tureguId: Int,
    @SerializedName("type")
    val type: String,
    @SerializedName("username")
    val username: String
)

data class ProfileLang(
    @SerializedName("_id")
    val _id: String,
    @SerializedName("active")
    val active: Boolean,
    @SerializedName("code")
    val code: String,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("name")
    val name: String
)

data class ProfilePreferences(
    @SerializedName("pushNotifications")
    val pushNotifications: Boolean
)
