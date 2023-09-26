package com.example.turegunew.adapter

import android.content.Context
import android.content.Intent
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.turegunew.R
import com.example.turegunew.activities.Search
import com.example.turegunew.models.ProductPhoto
import com.example.turegunew.models.ProductProperty
import kotlinx.android.synthetic.main.product_item.view.*


class SearchAdapter(
    val context: Context, val propertyList: List<ProductProperty>
) : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false)
        return SearchViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val data = propertyList[position]
        holder.searchBind(data, position)
        data.photos?.let { holder.setBannerSlider(it, context) }

        holder.itemView.ivBookmark.setOnClickListener {
            data._id
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(context, Search::class.java)
            intent.putExtra("imageUrl", data.photos?.get(0)?.url.toString())
            intent.putExtra("symbol", data.currency.symbol)
            intent.putExtra("price", data.price.toDouble().toString())
            intent.putExtra("code", data.currency.code)
            intent.putExtra("rentDuration", data.rentDuration)
            intent.putExtra("title", data.nameStr)
            intent.putExtra("address", data.addressBody)
            intent.putExtra("type", data.type)
            intent.putExtra("area", data.area.netAreaM2.toString())
            intent.putExtra("rooms", data.rooms)
            intent.putExtra("bathrooms", data.bathrooms)
            intent.putExtra("tureguId", data.tureguId.toString())
            intent.putExtra("typeDetail", data.type)
            intent.putExtra("uploadDate", data.createdAt)
            intent.putExtra("_id", data._id)
            intent.putExtra("furniture", data.furniture)
            intent.putExtra("floorLevel", data.floorLevel)
            intent.putExtra("age", data.age)
            intent.putExtra("status", data.status)
            intent.putExtra("deedStatus", data.deedStatus)
            intent.putExtra("orientationArr", data.orientationArr.toString())
            intent.putExtra("description", data.description?.get(0)?.text)
            intent.putExtra("firstName", data.admin?.firstName)
            intent.putExtra("lastName", data.admin?.lastName)
            intent.putExtra("profilePic", data.admin?.profilePic?.url)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return propertyList.size
    }

    class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val vpBanner = itemView.findViewById<ViewPager>(R.id.vp_banner)
        val llDots = itemView.findViewById<LinearLayout>(R.id.ll_dots)
        val price = itemView.findViewById<TextView>(R.id.tvPrice)
        val tvSymbol = itemView.findViewById<TextView>(R.id.tvSymbol)
        val currency = itemView.findViewById<TextView>(R.id.tvCurrency)
        val tvRentDuration = itemView.findViewById<TextView>(R.id.tvRentDuration)
        val tvName = itemView.findViewById<TextView>(R.id.tvNameTitle)
        val tvAddress = itemView.findViewById<TextView>(R.id.tvAddress)
        val tvType = itemView.findViewById<TextView>(R.id.tvType)
        val tvArea = itemView.findViewById<TextView>(R.id.tvArea)
        val tvDoor = itemView.findViewById<TextView>(R.id.tvKitchen)
        val tvBathtub = itemView.findViewById<TextView>(R.id.tvBathtub)
        private var runnable: Runnable? = null
        private var handler = Handler()
        fun searchBind(model: ProductProperty, position: Int) {
            tvName.text = model.nameStr
            tvAddress.text = model.addressBody
            price.text = model.price.toDouble().toString()
            currency.text = model.currency.code
            tvSymbol.text = model.currency.symbol
            tvRentDuration.text = model.rentDuration
            tvType.text = model.type
            tvArea.text = model.area.netAreaM2.toString()
            tvDoor.text = model.rooms
            tvBathtub.text = model.bathrooms
        }

        fun setBannerSlider(list: List<ProductPhoto>, context: Context) {
            var adapterBannerSlider = AdapterBannerSlider(context, list)

            adapterBannerSlider.setItem(list)

            addBottomDots(llDots, adapterBannerSlider.count, 0, context)
            vpBanner.apply {
                adapter = adapterBannerSlider
                currentItem = 0
            }

            vpBanner.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {

                }

                override fun onPageSelected(position: Int) {
                    addBottomDots(llDots, adapterBannerSlider.count, position, context)
                }

                override fun onPageScrollStateChanged(state: Int) {
                }

            })
        }

        private fun addBottomDots(llDots: LinearLayout, size: Int, current: Int, context: Context) {
            var dots: Array<ImageView?> = arrayOfNulls(size)
            llDots.removeAllViews()
            for (i in dots.indices) {
                dots[i] = ImageView(context)
                val width_height = 20
                val params =
                    LinearLayout.LayoutParams(ViewGroup.LayoutParams(width_height, width_height))
                params.setMargins(10, 10, 10, 10)
                dots[i]!!.layoutParams = params
                dots[i]!!.setImageResource(R.drawable.shape_circle_outline)
                llDots.addView(dots[i])
            }

            if (dots.size > 0) {
                dots[current]!!.setImageResource(R.drawable.shape_circle)
            }
        }

        private fun startAutoSlider(count: Int) {
            runnable = Runnable {
                var pos: Int = vpBanner.currentItem
                pos += 1
                if (pos >= count) pos = 0
                vpBanner.currentItem = pos
                handler.postDelayed(runnable!!, 3000)
            }
            handler.postDelayed(runnable!!, 3000)
        }
    }
}