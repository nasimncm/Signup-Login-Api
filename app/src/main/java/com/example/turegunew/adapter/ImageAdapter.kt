package com.example.turegunew.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.example.turegunew.R
import com.example.turegunew.models.ProductPhoto
import java.util.*


class AdapterBannerSlider(context: Context, items: List<ProductPhoto>) : PagerAdapter() {

    var context: Context? = null
    var items: List<ProductPhoto>? = null

    init {
        this.context = context
        this.items = items
    }


    override fun getCount(): Int = items?.size!!


    fun setItem(items: List<ProductPhoto>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as CardView
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val binding = layoutInflater.inflate(
            R.layout.slider, container, false
        )
        val imageView = binding.findViewById<ImageView>(R.id.imageView)
       // Log.d( "instantiateItem: ",items?.get(position)?.url!!)
        Glide.with(context!!).load(items?.get(position)?.url).into(imageView)
        Objects.requireNonNull(container).addView(binding);
        return binding
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as CardView)
    }


}