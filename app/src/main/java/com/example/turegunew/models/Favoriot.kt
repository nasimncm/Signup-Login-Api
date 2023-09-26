package com.example.turegunew.models

import com.google.gson.annotations.SerializedName

data class Favoriot(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val data: FavData,
    @SerializedName("message")
    val message: String
)

data class FavData(
    @SerializedName("bannersForCurrentPage")
    val bannersForCurrentPage: List<Any>,
    @SerializedName("favourites")
    val favourites: List<Favourite>,
    @SerializedName("total_pages")
    val total_pages: Int
)

data class Favourite(
    @SerializedName("_id")
    val _id: String,
    @SerializedName("active")
    val active: Boolean,
    @SerializedName("addedBy")
    val addedBy: String,
    @SerializedName("address")
    val address: FavAddress,
    @SerializedName("addressBody")
    val addressBody: String,
    @SerializedName("age")
    val age: String,
    @SerializedName("area")
    val area: FavArea,
    @SerializedName("bathrooms")
    val bathrooms: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("company")
    val company: FavCompany,
    @SerializedName("contractType")
    val contractType: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("currency")
    val currency: FavCurrency,
    @SerializedName("deedStatus")
    val deedStatus: String,
    @SerializedName("description")
    val description: List<FavDescription>,
    @SerializedName("duration")
    val duration: String,
    @SerializedName("exteriorAmenities")
    val exteriorAmenities: List<Any>,
    @SerializedName("exteriorAmenitiesArr")
    val exteriorAmenitiesArr: List<Any>,
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
    val name: List<FavName>,
    @SerializedName("nameStr")
    val nameStr: String,
    @SerializedName("openHouseTimestamp")
    val openHouseTimestamp: String,
    @SerializedName("orientation")
    val orientation: List<FavOrientation>,
    @SerializedName("orientationArr")
    val orientationArr: List<String>,
    @SerializedName("photos")
    val photos: List<FavPhoto>,
    @SerializedName("plans")
    val plans: List<FavPlan>,
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

data class FavAddress(
    @SerializedName("body")
    val body: String,
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double
)

data class FavArea(
    @SerializedName("grossAreaFt")
    val grossAreaFt: Double,
    @SerializedName("grossAreaM2")
    val grossAreaM2: Int,
    @SerializedName("netAreaFt")
    val netAreaFt: Double,
    @SerializedName("netAreaM2")
    val netAreaM2: Int
)

data class FavCompany(
    @SerializedName("_id")
    val _id: String,
    @SerializedName("active")
    val active: Boolean,
    @SerializedName("addressBody")
    val addressBody: String,
    @SerializedName("company")
    val company: FaveeCompany,
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
    val phone: Any,
    @SerializedName("preferences")
    val preferences: FavPreferences,
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

data class FaveeCompany(
    @SerializedName("_id")
    val _id: String,
    @SerializedName("about")
    val about: List<String>,
    @SerializedName("address")
    val address: String,
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
    val logo: Any,
    @SerializedName("membership")
    val membership: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("points")
    val points: Int,
    @SerializedName("saleInfo")
    val saleInfo: favSaleInfo,
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

data class favSaleInfo(
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


data class FavPreferences(
    @SerializedName("pushNotifications")
    val pushNotifications: Boolean
)


data class FavCurrency(
    @SerializedName("_id")
    val _id: String,
    @SerializedName("code")
    val code: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("symbol")
    val symbol: String
)

data class FavDescription(
    @SerializedName("lang")
    val lang: FavLang,
    @SerializedName("text")
    val text: String
)

data class FavLang(
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


data class FavName(
    @SerializedName("lang")
    val lang: NameLang,
    @SerializedName("text")
    val text: String
)

data class NameLang(
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


data class FavOrientation(
    @SerializedName("label")
    val label: String,
    @SerializedName("value")
    val value: String
)

data class FavPhoto(
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

data class FavPlan(
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
