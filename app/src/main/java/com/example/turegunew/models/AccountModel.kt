package com.example.turegunew.models

data class AccountModel(
    val code: Int,
    val `data`: Data,
    val message: String
) {
    data class Data(
        val agentEmailUnreadCount: Int,
        val agentEnquiryUnreadCount: Int,
        val bannersForCurrentPage: List<Any>,
        val companyEmailEnquiryUnreadCount: Int,
        val contactUnreadCount: Int,
        val newCompanyEnquiryUnreadCount: Int,
        val partnerEnquiryUnreadCount: Int,
        val profile: Profile,
        val propertyUnreadCount: Int
    ) {
        data class Profile(
            val _id: String,
            val active: Boolean,
            val addressBody: String,
            val createdAt: String,
            val email: String,
            val emailVerifiedAt: String,
            val firstName: String,
            val followedAgents: Int,
            val lang: Lang,
            val lastName: String?= null,
            val name: String,
            val phone: String,
            val preferences: Preferences,
            val regDate: String,
            val tureguId: Int,
            val type: String,
            val username: String
        ) {
            data class Lang(
                val _id: String,
                val active: Boolean,
                val code: String,
                val icon: String,
                val name: String
            )

            data class Preferences(
                val pushNotifications: Boolean
            )
        }
    }
}