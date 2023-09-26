package com.example.turegunew

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.turegunew.adapter.SearchAdapter
import com.example.turegunew.api.ApiInterface
import com.example.turegunew.api.RetrofitClient
import com.example.turegunew.models.ProductProperty
import com.example.turegunew.models.PropertyModel
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.fragment_search.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchFragment : Fragment() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var searchAdapter: SearchAdapter
    private lateinit var rvRecyclerView: RecyclerView
    private var propertyLists: MutableList<ProductProperty> = ArrayList()
    private lateinit var mProgress: ProgressDialog

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_search, container, false)
        mProgress = ProgressDialog(context)
        mProgress.setTitle("Processing...")
        mProgress.setMessage("Please wait...")
        mProgress.setCancelable(false)
        mProgress.isIndeterminate
        rvRecyclerView = view.findViewById(R.id.searchRecyclerView)
        propertyLists = ArrayList()
        searchAdapter = SearchAdapter(requireContext(), propertyLists)
        rvRecyclerView.adapter = searchAdapter
        linearLayoutManager = LinearLayoutManager(requireContext())
        view.searchRecyclerView.layoutManager = linearLayoutManager
        getData()
        return view
    }

    private fun getData() {
        mProgress.show()
        val propertyList = RetrofitClient.getInstance().create(ApiInterface::class.java)
        val retrofitData = propertyList.propertyList()

        retrofitData.enqueue(object : Callback<PropertyModel> {
            override fun onResponse(
                call: Call<PropertyModel>?,
                response: Response<PropertyModel>?
            ) {
                if (response!!.code() == 200) {
                    val registerResponse: PropertyModel = response.body()!!
                    //  Log.d("onResponse: ", registerResponse.toString())
                    propertyLists.addAll(registerResponse.data.properties!!)
                    searchRecyclerView.adapter = searchAdapter
                    searchAdapter = SearchAdapter(requireContext(), propertyLists)
                    mProgress.dismiss()
                    searchAdapter.notifyDataSetChanged()
                }

            }

            override fun onFailure(call: Call<PropertyModel>?, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
                mProgress.dismiss()
            }
        })
    }
}