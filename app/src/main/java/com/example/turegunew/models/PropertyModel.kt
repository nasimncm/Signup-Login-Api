package com.example.turegunew.models

import com.google.gson.annotations.SerializedName

data class PropertyModel(
    @SerializedName("code") val code: Int,
    @SerializedName("data") val data: MainData,
    @SerializedName("message") val message: String
)

data class MainData(
    @SerializedName("bannersForCurrentPage") val bannersForCurrentPage: List<Any>? = null,
    @SerializedName("count") val count: Int? = null,
    @SerializedName("properties") val properties: List<ProductProperty>? = null,
)

data class ProductProperty(
    @SerializedName("_id") val _id: String,
    @SerializedName("active") val active: Boolean,
    @SerializedName("addedBy") val addedBy: String,
    @SerializedName("address") val address: PropertyAddress,
    @SerializedName("addressBody") val addressBody: String,
    @SerializedName("admin") val admin: PortalAdmin? = null,
    @SerializedName("age") val age: String,
    @SerializedName("agent") val agent: PropertyAgent,
    @SerializedName("area") val area: PropertyArea,
    @SerializedName("bathrooms") val bathrooms: String,
    @SerializedName("category") val category: String,
    @SerializedName("company") val company: PropertyCompany,
    @SerializedName("contractType") val contractType: String,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("currency") val currency: PropertyCurrency,
    @SerializedName("deedStatus") val deedStatus: String,
    @SerializedName("description") val description: List<PropertyDescription>? = null,
    @SerializedName("duration") val duration: String,
    @SerializedName("exteriorAmenities") val exteriorAmenities: List<String>,
    @SerializedName("exteriorAmenitiesArr") val exteriorAmenitiesArr: List<Any>,
    @SerializedName("featuredUntil") val featuredUntil: String,
    @SerializedName("floorLevel") val floorLevel: String,
    @SerializedName("furniture") val furniture: String,
    @SerializedName("garages") val garages: String,
    @SerializedName("interiorAmenities") val interiorAmenities: List<String>,
    @SerializedName("interiorAmenitiesArr") val interiorAmenitiesArr: List<Any>,
    @SerializedName("isFavourite") val isFavourite: Boolean,
    @SerializedName("isProject") val isProject: Boolean,
    @SerializedName("membershipStatus") val membershipStatus: Int,
    @SerializedName("name") val name: List<ProductName>,
    @SerializedName("nameStr") val nameStr: String,
    @SerializedName("openHouseTimestamp") val openHouseTimestamp: String,
    @SerializedName("orientation") val orientation: List<ProductOrientation>,
    @SerializedName("orientationArr") val orientationArr: List<String>,
    @SerializedName("photos") val photos: List<ProductPhoto>? = null,
    @SerializedName("plans") val plans: List<PropertyPlan>,
    @SerializedName("premiumUntil") val premiumUntil: String,
    @SerializedName("price") val price: Int,
    @SerializedName("propertyState") val propertyState: String,
    @SerializedName("rentDuration") val rentDuration: String,
    @SerializedName("rooms") val rooms: String,
    @SerializedName("status") val status: String,
    @SerializedName("title") val title: List<Any>,
    @SerializedName("tureguId") val tureguId: Int,
    @SerializedName("type") val type: String,
    @SerializedName("unitdescription") val unitdescription: List<Any>,
    @SerializedName("videoUrl") val videoUrl: String,
    @SerializedName("viewUrl") val viewUrl: String,
    @SerializedName("willShowOnHompage") val willShowOnHompage: Boolean
)

data class PropertyAddress(
    @SerializedName("body") val body: String,
    @SerializedName("latitude") val latitude: Double,
    @SerializedName("longitude") val longitude: Double
)

data class PortalAdmin(
    @SerializedName("firstName") val firstName: String? = null,
    @SerializedName("lastName") val lastName: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("profilePic") val profilePic: AdminProfilePic? = null,
    @SerializedName("regDate") val regDate: String? = null
)

data class AdminProfilePic(
    @SerializedName("_id") val _id: String,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("meta") val meta: String,
    @SerializedName("type") val type: String,
    @SerializedName("updatedAt") val updatedAt: String,
    @SerializedName("url") val url: String? = null
)


data class PropertyAgent(
    @SerializedName("_id") val _id: String,
    @SerializedName("active") val active: Boolean,
    @SerializedName("addressBody") val addressBody: String,
    @SerializedName("agent") val agent: Agent,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("email") val email: String,
    @SerializedName("emailVerifiedAt") val emailVerifiedAt: String,
    @SerializedName("firstName") val firstName: String,
    @SerializedName("lastName") val lastName: String,
    @SerializedName("name") val name: String,
    @SerializedName("parent") val parent: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("preferences") val preferences: AgentPreferences,
    @SerializedName("profilePic") val profilePic: AgentProfilePic,
    @SerializedName("regDate") val regDate: String,
    @SerializedName("tureguId") val tureguId: Int,
    @SerializedName("type") val type: String,
    @SerializedName("username") val username: String,
    @SerializedName("willOccurInSearchUntil") val willOccurInSearchUntil: String
)

data class Agent(
    @SerializedName("about") val about: List<String>,
    @SerializedName("addressBody") val addressBody: String,
    @SerializedName("contactEmail") val contactEmail: String,
    @SerializedName("contactPhone") val contactPhone: String,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("languages") val languages: String,
    @SerializedName("position") val position: String,
    @SerializedName("saleInfo") val saleInfo: AgentSaleInfo,
    @SerializedName("serviceArea") val serviceArea: String,
    @SerializedName("updatedAt") val updatedAt: String
)

data class AgentSaleInfo(
    @SerializedName("eventsAdded") val eventsAdded: Int,
    @SerializedName("projectsAdded") val projectsAdded: Int,
    @SerializedName("propertiesForRent") val propertiesForRent: Int,
    @SerializedName("propertiesForSale") val propertiesForSale: Int
)


data class AgentPreferences(
    @SerializedName("pushNotifications") val pushNotifications: Boolean
)

data class AgentProfilePic(
    @SerializedName("_id") val _id: String,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("meta") val meta: String,
    @SerializedName("type") val type: String,
    @SerializedName("updatedAt") val updatedAt: String,
    @SerializedName("url") val url: String
)


data class PropertyArea(
    @SerializedName("grossAreaFt") val grossAreaFt: Double,
    @SerializedName("grossAreaM2") val grossAreaM2: Int,
    @SerializedName("netAreaFt") val netAreaFt: Double,
    @SerializedName("netAreaM2") val netAreaM2: Int
)

data class PropertyCompany(
    @SerializedName("_id") val _id: String,
    @SerializedName("active") val active: Boolean,
    @SerializedName("addressBody") val addressBody: String,
    @SerializedName("company") val company: DetailsCompany,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("email") val email: String,
    @SerializedName("emailVerifiedAt") val emailVerifiedAt: String,
    @SerializedName("firstName") val firstName: String? = null,
    @SerializedName("lastName") val lastName: String,
    @SerializedName("name") val name: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("preferences") val preferences: CompanyPreferences,
    @SerializedName("regDate") val regDate: String,
    @SerializedName("tureguId") val tureguId: Int,
    @SerializedName("type") val type: String,
    @SerializedName("username") val username: String,
    @SerializedName("willOccurInSearchUntil") val willOccurInSearchUntil: String
)

data class DetailsCompany(
    @SerializedName("_id") val _id: String,
    @SerializedName("about") val about: List<String>,
    @SerializedName("address") val address: String,
    @SerializedName("addressBody") val addressBody: String,
    @SerializedName("adsAdded") val adsAdded: Int? = null,
    @SerializedName("agents") val agents: List<String>,
    @SerializedName("contactEmail") val contactEmail: String,
    @SerializedName("contactPhone") val contactPhone: String,
    @SerializedName("logo") val logo: DetailsLogo,
    @SerializedName("membership") val membership: Membership,
    @SerializedName("name") val name: String,
    @SerializedName("points") val points: Int,
    @SerializedName("saleInfo") val saleInfo: CompanySaleInfo,
    @SerializedName("serviceArea") val serviceArea: String,
    @SerializedName("tureguId") val tureguId: Int,
    @SerializedName("type") val type: String,
    @SerializedName("user") val user: String,
    @SerializedName("website") val website: String,
    @SerializedName("whatsappPhone") val whatsappPhone: String
)

data class DetailsLogo(
    @SerializedName("_id") val _id: String,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("meta") val meta: String,
    @SerializedName("type") val type: String,
    @SerializedName("updatedAt") val updatedAt: String,
    @SerializedName("url") val url: String
)

data class Membership(
    @SerializedName("company") val company: String,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("expiringAt") val expiringAt: String,
    @SerializedName("lastRenewedAt") val lastRenewedAt: String,
    @SerializedName("options") val options: Options,
    @SerializedName("startedAt") val startedAt: String
)

data class Options(
    @SerializedName("canCreateAgents") val canCreateAgents: Int,
    @SerializedName("canCreateListings") val canCreateListings: Int,
    @SerializedName("canListEvents") val canListEvents: Boolean,
    @SerializedName("canListProjects") val canListProjects: Boolean,
    @SerializedName("canListProperty") val canListProperty: Boolean,
    @SerializedName("canReceivePropertyRequests") val canReceivePropertyRequests: Int,
    @SerializedName("companyLogoInHomePage") val companyLogoInHomePage: Boolean,
    @SerializedName("cost") val cost: Cost,
    @SerializedName("currency") val currency: String,
    @SerializedName("listingDurationInMonths") val listingDurationInMonths: Int,
    @SerializedName("mailBox") val mailBox: Boolean,
    @SerializedName("name") val name: String,
    @SerializedName("pointsRequiredForfeaturedPerWeek") val pointsRequiredForfeaturedPerWeek: Int,
    @SerializedName("pointsRequiredForpremiumPerWeek") val pointsRequiredForpremiumPerWeek: Int,
    @SerializedName("willOccurInSearch") val willOccurInSearch: Boolean
)

data class Cost(
    @SerializedName("m12") val m12: Int,
    @SerializedName("m3") val m3: Int,
    @SerializedName("m6") val m6: Int,
    @SerializedName("perMonth") val perMonth: Int
)


data class CompanySaleInfo(
    @SerializedName("agentsAdded") val agentsAdded: Int,
    @SerializedName("eventsAdded") val eventsAdded: Int,
    @SerializedName("projectsAdded") val projectsAdded: Int,
    @SerializedName("propertiesForRent") val propertiesForRent: Int,
    @SerializedName("propertiesForSale") val propertiesForSale: Int
)


data class CompanyPreferences(
    @SerializedName("pushNotifications") val pushNotifications: Boolean
)


data class PropertyCurrency(
    @SerializedName("_id") val _id: String,
    @SerializedName("code") val code: String,
    @SerializedName("name") val name: String,
    @SerializedName("symbol") val symbol: String
)

data class PropertyDescription(
    @SerializedName("lang") val lang: DescriptionLang? = null,
    @SerializedName("text") val text: String? = null
)

data class DescriptionLang(
    @SerializedName("_id") val _id: String,
    @SerializedName("active") val active: Boolean,
    @SerializedName("code") val code: String,
    @SerializedName("icon") val icon: DescriptionIcon,
    @SerializedName("name") val name: String
)

data class DescriptionIcon(
    @SerializedName("_id") val _id: String,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("meta") val meta: String,
    @SerializedName("type") val type: String,
    @SerializedName("updatedAt") val updatedAt: String,
    @SerializedName("url") val url: String
)


data class ProductName(
    @SerializedName("lang") val lang: ProductLang, @SerializedName("text") val text: String
)

data class ProductLang(
    @SerializedName("_id") val _id: String,
    @SerializedName("active") val active: Boolean,
    @SerializedName("code") val code: String,
    @SerializedName("icon") val icon: Icon,
    @SerializedName("name") val name: String
)

data class Icon(
    @SerializedName("_id") val _id: String,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("meta") val meta: String,
    @SerializedName("type") val type: String,
    @SerializedName("updatedAt") val updatedAt: String,
    @SerializedName("url") val url: String
)


data class ProductOrientation(
    @SerializedName("label") val label: String, @SerializedName("value") val value: String
)

data class ProductPhoto(
    @SerializedName("_id") val _id: String,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("meta") val meta: String,
    @SerializedName("type") val type: String,
    @SerializedName("updatedAt") val updatedAt: String,
    @SerializedName("url") val url: String? = null
)

data class PropertyPlan(
    @SerializedName("_id") val _id: String,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("meta") val meta: String,
    @SerializedName("type") val type: String,
    @SerializedName("updatedAt") val updatedAt: String,
    @SerializedName("url") val url: String
)


