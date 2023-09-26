package com.example.turegunew.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.turegunew.R
import kotlinx.android.synthetic.main.activity_search.*

class Search : AppCompatActivity() {

    private var bannerImage: String? = null
    private var profileImage: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val imageUrl = findViewById<ImageView>(R.id.ivDetailFirst)
        val profilePic = findViewById<ImageView>(R.id.img)
        val symbol = findViewById<TextView>(R.id.tvDetailSymbol)
        val price = findViewById<TextView>(R.id.tvDetailPrice)
        val code = findViewById<TextView>(R.id.tvDetailCurrency)
        val rentDuration = findViewById<TextView>(R.id.tvDetailRentDuration)
        val tvName = findViewById<TextView>(R.id.tvDetailTitle)
        val tvAddress = findViewById<TextView>(R.id.tvDetailAddress)
        val type = findViewById<TextView>(R.id.tvDetailType)
        val area = findViewById<TextView>(R.id.tvDetailArea)
        val rooms = findViewById<TextView>(R.id.tvDetailKitchen)
        val bathrooms = findViewById<TextView>(R.id.tvDetailBathtub)
        val tureguId = findViewById<TextView>(R.id.tv_reference_id)
        val uploadDate = findViewById<TextView>(R.id.tv_listingDate)
        val typeDetail = findViewById<TextView>(R.id.tv_Detail_type)
        val symbolDetail = findViewById<TextView>(R.id.tv_DetailSymbol)
        val priceDetail = findViewById<TextView>(R.id.tv_detailPrice)
        val rentDurationDetail = findViewById<TextView>(R.id.tv_rent_duration)
        val areaDetail = findViewById<TextView>(R.id.tv_area)
        val roomDetail = findViewById<TextView>(R.id.tv_rooms)
        val parking = findViewById<TextView>(R.id.tv_parking_space)
        val furniture = findViewById<TextView>(R.id.tv_furniture)
        val floorLevel = findViewById<TextView>(R.id.tv_floor_level)
        val age = findViewById<TextView>(R.id.tv_property_age)
        val status = findViewById<TextView>(R.id.tv_property_status)
        val deedStatus = findViewById<TextView>(R.id.tv_deed_status)
        val orientationArr = findViewById<TextView>(R.id.tv_property_orientation)
        val description = findViewById<TextView>(R.id.tv_description)
        val firstName = findViewById<TextView>(R.id.agent_first_name)
        val lastName = findViewById<TextView>(R.id.agent_last_name)


        bannerImage = intent.getStringExtra("imageUrl")
        Glide.with(this).load(bannerImage).into(imageUrl)
        profileImage = intent.getStringExtra("profilePic")
        Glide.with(this).load(profileImage).into(profilePic)
       // Log.d( "onCreate: ", imageUrl.toString())
        symbol.text = intent.getStringExtra("symbol")
        price.text = intent.getStringExtra("price")
        code.text = intent.getStringExtra("code")
        rentDuration.text = intent.getStringExtra("rentDuration")
        tvName.text = intent.getStringExtra("title")
        tvAddress.text = intent.getStringExtra("address")
        type.text = intent.getStringExtra("type")
        area.text = intent.getStringExtra("area")
        rooms.text = intent.getStringExtra("rooms")
        bathrooms.text = intent.getStringExtra("bathrooms")
        tureguId.text = intent.getStringExtra("tureguId")
        uploadDate.text = intent.getStringExtra("uploadDate")
        typeDetail.text = intent.getStringExtra("typeDetail")
        symbolDetail.text = intent.getStringExtra("symbol")
        priceDetail.text = intent.getStringExtra("price")
        rentDurationDetail.text = intent.getStringExtra("rentDuration")
        areaDetail.text = intent.getStringExtra("area")
        roomDetail.text = intent.getStringExtra("rooms")
        parking.text = intent.getStringExtra("null")
        furniture.text = intent.getStringExtra("furniture")
        floorLevel.text = intent.getStringExtra("floorLevel")
        age.text = intent.getStringExtra("age")
        status.text = intent.getStringExtra("status")
        deedStatus.text = intent.getStringExtra("deedStatus")
        orientationArr.text = intent.getStringExtra("orientationArr")
        description.text = intent.getStringExtra("description")
        firstName.text = intent.getStringExtra("firstName")
        lastName.text = intent.getStringExtra("lastName")

        market_trend.setOnClickListener {
            val intent = Intent(this, ViewSlider::class.java)
            startActivity(intent)
        }

        ivBack.setOnClickListener {
            onBackPressed()
        }

        ivShare.setOnClickListener {
            val shareBody = intent.getStringExtra("title")
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
            startActivity(shareIntent)
        }
    }

}