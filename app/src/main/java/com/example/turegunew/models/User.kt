package com.example.turegunew.models

import com.google.gson.annotations.SerializedName

data class Register(
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String
)

data class UserLogin(
    val email: String,
    val password: String
)

data class ForgotPasswordReset(
    val email: String
)

data class ChangePasswordReset(
    val oldPassword: String,
    val newPassword: String
)

data class LoginResponse(
    @SerializedName("code")
    val code: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val data: LoginData? = null,

)

data class LoginData(
    @SerializedName("user")
    val user: LoginUser,
    @SerializedName("bannersForCurrentPage")
    val bannersForCurrentPage: List<Any>,
    @SerializedName("authToken")
    val authToken: String,
    @SerializedName("count")
    val count: Int,
    @SerializedName("properties")
    val properties: List<LoginProperty>
)

data class LoginUser(
    @SerializedName("email")
    val email: String,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("active")
    val active: Boolean,
    @SerializedName("username")
    val username: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("emailVerifiedAt")
    val emailVerifiedAt: Any,
    @SerializedName("followedAgents")
    val followedAgents: Int,
    @SerializedName("addressBody")
    val addressBody: String,
    @SerializedName("_id")
    val _id: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("tureguId")
    val tureguId: Int,
    @SerializedName("regDate")
    val regDate: String,
    @SerializedName("lang")
    val lang: String,
    @SerializedName("preferences")
    val preferences: LoginPreferences,

)

data class LoginPreferences(
    @SerializedName("pushNotifications")
    val pushNotifications: Boolean
)

data class LoginProperty(
    @SerializedName("_id")
    val _id: String ? = null,
    @SerializedName("active")
    val active: Boolean ? = null,
    @SerializedName("addedBy")
    val addedBy: String ? = null,
    @SerializedName("address")
    val address: Address ? = null,
    @SerializedName("addressBody")
    val addressBody: String ? = null,
    @SerializedName("admin")
    val admin: Admin ? = null,
    @SerializedName("age")
    val age: String ? = null,
    @SerializedName("area")
    val area: Area ? = null,
    @SerializedName("bathrooms")
    val bathrooms: String ? = null,
    @SerializedName("category")
    val category: String ? = null,
    @SerializedName("company")
    val company: Company ? = null,
    @SerializedName("contractType")
    val contractType: String ? = null,
    @SerializedName("createdAt")
    val createdAt: String ? = null,
    @SerializedName("currency")
    val currency: Currency ? = null,
    @SerializedName("deedStatus")
    val deedStatus: String ? = null,
    @SerializedName("description")
    val description: List<Description> ? = null,
    @SerializedName("duration")
    val duration: String ? = null,
    @SerializedName("exteriorAmenities")
    val exteriorAmenities: List<String> ? = null,
    @SerializedName("exteriorAmenitiesArr")
    val exteriorAmenitiesArr: List<Any> ? = null,
    @SerializedName("featuredUntil")
    val featuredUntil: String ? = null,
    @SerializedName("floorLevel")
    val floorLevel: String ? = null,
    @SerializedName("furniture")
    val furniture: String ? = null,
    @SerializedName("garages")
    val garages: String ? = null,
    @SerializedName("interiorAmenities")
    val interiorAmenities: List<String> ? = null,
    @SerializedName("interiorAmenitiesArr")
    val interiorAmenitiesArr: List<Any> ? = null,
    @SerializedName("isProject")
    val isProject: Boolean ? = null,
    @SerializedName("membershipStatus")
    val membershipStatus: Int ? = null,
    @SerializedName("name")
    val name: String ? = null,
    @SerializedName("nameStr")
    val nameStr: String ? = null,
    @SerializedName("openHouseTimestamp")
    val openHouseTimestamp: String ? = null,
    @SerializedName("orientation")
    val orientation: List<Orientation> ? = null,
    @SerializedName("orientationArr")
    val orientationArr: List<String> ? = null,
    @SerializedName("photos")
    val photos: List<Photo> ? = null,
    @SerializedName("plans")
    val plans: List<Plan> ? = null,
    @SerializedName("premiumUntil")
    val premiumUntil: String ? = null,
    @SerializedName("price")
    val price: Int ? = null,
    @SerializedName("propertyState")
    val propertyState: String ? = null,
    @SerializedName("rentDuration")
    val rentDuration: String ? = null,
    @SerializedName("rooms")
    val rooms: String ? = null,
    @SerializedName("status")
    val status: String ? = null,
    @SerializedName("title")
    val title: List<Any> ? = null,
    @SerializedName("tureguId")
    val tureguId: Int ? = null,
    @SerializedName("type")
    val type: String ? = null,
    @SerializedName("unitdescription")
    val unitdescription: List<Any> ? = null,
    @SerializedName("videoUrl")
    val videoUrl: String ? = null,
    @SerializedName("viewUrl")
    val viewUrl: String ? = null,
    @SerializedName("willShowOnHompage")
    val willShowOnHompage: Boolean ? = null
)

data class RegisterResponse(
    @SerializedName("code")
    val code: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val data: Data? = null,
)

data class Data(
    @SerializedName("user")
    val user: User,
    @SerializedName("bannersForCurrentPage")
    val bannersForCurrentPage: List<Any>,
    @SerializedName("authToken")
    val authToken: String,
    @SerializedName("count")
    val count: Int,
    @SerializedName("properties")
    val properties: List<PropertyModel>
)

data class User(
    @SerializedName("email")
    val email: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("active")
    val active: Boolean,
    @SerializedName("username")
    val username: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("emailVerifiedAt")
    val emailVerifiedAt: Any,
    @SerializedName("followedAgents")
    val followedAgents: Int,
    @SerializedName("addressBody")
    val addressBody: String,
    @SerializedName("_id")
    val _id: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("tureguId")
    val tureguId: Int,
    @SerializedName("regDate")
    val regDate: String,
    @SerializedName("lang")
    val lang: Lang,
    @SerializedName("preferences")
    val preferences: Preferences
)
data class Lang(
    @SerializedName("name")
    val name: String,
    @SerializedName("code")
    val code: String,
    @SerializedName("active")
    val active: Boolean,
    @SerializedName("_id")
    val _id: String,
    @SerializedName("icon")
    val icon: Any, //in some item icon is String
)

data class Preferences(
    @SerializedName("pushNotifications")
    val pushNotifications: Boolean
)

data class Property(
    @SerializedName("_id")
    val _id: String,
    @SerializedName("active")
    val active: Boolean,
    @SerializedName("addedBy")
    val addedBy: String,
    @SerializedName("address")
    val address: Address,
    @SerializedName("addressBody")
    val addressBody: String,
    @SerializedName("admin")
    val admin: Admin,
    @SerializedName("age")
    val age: String,
    @SerializedName("area")
    val area: Area,
    @SerializedName("bathrooms")
    val bathrooms: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("company")
    val company: Company,
    @SerializedName("contractType")
    val contractType: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("currency")
    val currency: Currency,
    @SerializedName("deedStatus")
    val deedStatus: String,
    @SerializedName("description")
    val description: List<Description>,
    @SerializedName("duration")
    val duration: String,
    @SerializedName("exteriorAmenities")
    val exteriorAmenities: List<String>,
    @SerializedName("exteriorAmenitiesArr")
    val exteriorAmenitiesArr: List<Any>,
    @SerializedName("featuredUntil")
    val featuredUntil: String,
    @SerializedName("floorLevel")
    val floorLevel: String,
    @SerializedName("furniture")
    val furniture: String,
    @SerializedName("garages")
    val garages: String,
    @SerializedName("interiorAmenities")
    val interiorAmenities: List<String>,
    @SerializedName("interiorAmenitiesArr")
    val interiorAmenitiesArr: List<Any>,
    @SerializedName("isProject")
    val isProject: Boolean,
    @SerializedName("membershipStatus")
    val membershipStatus: Int,
    @SerializedName("name")
    val name: List<Name>,
    @SerializedName("nameStr")
    val nameStr: String,
    @SerializedName("openHouseTimestamp")
    val openHouseTimestamp: String,
    @SerializedName("orientation")
    val orientation: List<Orientation>,
    @SerializedName("orientationArr")
    val orientationArr: List<String>,
    @SerializedName("photos")
    val photos: List<Photo>,
    @SerializedName("plans")
    val plans: List<Plan>,
    @SerializedName("premiumUntil")
    val premiumUntil: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("propertyState")
    val propertyState: String,
    @SerializedName("rentDuration")
    val rentDuration: String,
    @SerializedName("rooms")
    val rooms: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("title")
    val title: List<Any>,
    @SerializedName("tureguId")
    val tureguId: Int,
    @SerializedName("type")
    val type: String,
    @SerializedName("unitdescription")
    val unitdescription: List<Any>,
    @SerializedName("videoUrl")
    val videoUrl: String,
    @SerializedName("viewUrl")
    val viewUrl: String,
    @SerializedName("willShowOnHompage")
    val willShowOnHompage: Boolean
)

data class Address(
    @SerializedName("body")
    val body: String,
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double
)

data class Admin(
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("regDate")
    val regDate: String
)

data class Area(
    @SerializedName("grossAreaFt")
    val grossAreaFt: Double,
    @SerializedName("grossAreaM2")
    val grossAreaM2: Int,
    @SerializedName("netAreaFt")
    val netAreaFt: Double,
    @SerializedName("netAreaM2")
    val netAreaM2: Int
)

data class Company(
    @SerializedName("_id")
    val _id: String,
    @SerializedName("active")
    val active: Boolean,
    @SerializedName("addressBody")
    val addressBody: String,
    @SerializedName("company")
    val company: Company,
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
    val preferences: Preferences,
    @SerializedName("regDate")
    val regDate: String,
    @SerializedName("tureguId")
    val tureguId: Int,
    @SerializedName("type")
    val type: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("about")
    val about: List<String>,
    @SerializedName("address")
    val address: String,
    @SerializedName("adsAdded")
    val adsAdded: Int,
    @SerializedName("agents")
    val agents: List<Any>,
    @SerializedName("contactEmail")
    val contactEmail: String,
    @SerializedName("contactPhone")
    val contactPhone: String,
    @SerializedName("logo")
    val logo: Logo,
    @SerializedName("membership")
    val membership: String,
    @SerializedName("points")
    val points: Int,
    @SerializedName("saleInfo")
    val saleInfo: SaleInfo,
    @SerializedName("serviceArea")
    val serviceArea: String,
    @SerializedName("user")
    val user: String,
    @SerializedName("website")
    val website: String,
    @SerializedName("whatsappPhone")
    val whatsappPhone: String
)

data class Logo(
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

data class SaleInfo(
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


data class Currency(
    @SerializedName("_id")
    val _id: String,
    @SerializedName("code")
    val code: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("symbol")
    val symbol: String
)

data class Description(
    @SerializedName("lang")
    val lang: Lang,
    @SerializedName("text")
    val text: String
)

data class Name(
    @SerializedName("lang")
    val lang: Lang,
    @SerializedName("text")
    val text: String
)
data class Orientation(
    @SerializedName("label")
    val label: String,
    @SerializedName("value")
    val value: String
)

data class Photo(
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

data class Plan(
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