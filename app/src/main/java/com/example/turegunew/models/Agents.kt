package com.example.turegunew.models

import com.google.gson.annotations.SerializedName

data class Agents(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val data: AgentsData,
    @SerializedName("message")
    val message: String
)

data class AgentsData(
    @SerializedName("bannersForCurrentPage")
    val bannersForCurrentPage: List<Any>,
    @SerializedName("count")
    val count: Int,
    @SerializedName("users")
    val users: List<AgentsUser>
)

data class AgentsUser(
    @SerializedName("_id")
    val _id: String,
    @SerializedName("active")
    val active: Boolean,
    @SerializedName("addressBody")
    val addressBody: String,
    @SerializedName("agent")
    val agent: AgentsAgent,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("emailVerifiedAt")
    val emailVerifiedAt: String,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("parent")
    val parent: Parent,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("preferences")
    val preferences: AgntPreferences,
    @SerializedName("profilePic")
    val profilePic: ProfilePic,
    @SerializedName("regDate")
    val regDate: String,
    @SerializedName("tureguId")
    val tureguId: Int,
    @SerializedName("type")
    val type: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("willOccurInSearchUntil")
    val willOccurInSearchUntil: String
)

data class AgentsAgent(
    @SerializedName("about")
    val about: List<String>,
    @SerializedName("addressBody")
    val addressBody: String,
    @SerializedName("contactEmail")
    val contactEmail: String,
    @SerializedName("contactPhone")
    val contactPhone: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("languages")
    val languages: String,
    @SerializedName("position")
    val position: String,
    @SerializedName("saleInfo")
    val saleInfo: AgentsSaleInfo,
    @SerializedName("serviceArea")
    val serviceArea: String,
    @SerializedName("updatedAt")
    val updatedAt: String
)

data class AgentsSaleInfo(
    @SerializedName("eventsAdded")
    val eventsAdded: Int,
    @SerializedName("projectsAdded")
    val projectsAdded: Int,
    @SerializedName("propertiesForRent")
    val propertiesForRent: Int,
    @SerializedName("propertiesForSale")
    val propertiesForSale: Int
)


data class Parent(
    @SerializedName("_id")
    val _id: String,
    @SerializedName("active")
    val active: Boolean,
    @SerializedName("addressBody")
    val addressBody: String,
    @SerializedName("company")
    val company: AgentsCompany,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("emailVerifiedAt")
    val emailVerifiedAt: String,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("preferences")
    val preferences: AgtPreferences,
    @SerializedName("regDate")
    val regDate: String,
    @SerializedName("tureguId")
    val tureguId: Int,
    @SerializedName("type")
    val type: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("willOccurInSearchUntil")
    val willOccurInSearchUntil: String
)

data class AgentsCompany(
    @SerializedName("_id")
    val _id: String,
    @SerializedName("about")
    val about: List<String>,
    @SerializedName("address")
    val address: AgentsAddress,
    @SerializedName("addressBody")
    val addressBody: String,
    @SerializedName("adsAdded")
    val adsAdded: Int,
    @SerializedName("agents")
    val agents: List<String>,
    @SerializedName("contactEmail")
    val contactEmail: String,
    @SerializedName("contactPhone")
    val contactPhone: String,
    @SerializedName("logo")
    val logo: AgentsLogo,
    @SerializedName("membership")
    val membership: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("points")
    val points: Int,
    @SerializedName("saleInfo")
    val saleInfo: AgentssSaleInfo,
    @SerializedName("serviceArea")
    val serviceArea: String,
    @SerializedName("tureguId")
    val tureguId: Int,
    @SerializedName("type")
    val type: String,
    @SerializedName("user")
    val user: String,
    @SerializedName("website")
    val website: String,
    @SerializedName("whatsappPhone")
    val whatsappPhone: String
)

data class AgentsAddress(
    @SerializedName("body")
    val body: String,
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double
)

data class AgentsLogo(
    @SerializedName("_id")
    val _id: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("meta")
    val meta: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("url")
    val url: String
)

data class AgentssSaleInfo(
    @SerializedName("agentsAdded")
    val agentsAdded: Int,
    @SerializedName("eventsAdded")
    val eventsAdded: Int,
    @SerializedName("projectsAdded")
    val projectsAdded: Int,
    @SerializedName("propertiesForRent")
    val propertiesForRent: Int,
    @SerializedName("propertiesForSale")
    val propertiesForSale: Int
)


data class AgntPreferences(
    @SerializedName("pushNotifications")
    val pushNotifications: Boolean
)


data class AgtPreferences(
    @SerializedName("pushNotifications")
    val pushNotifications: Boolean
)

data class ProfilePic(
    @SerializedName("_id")
    val _id: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("meta")
    val meta: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("url")
    val url: String
)
