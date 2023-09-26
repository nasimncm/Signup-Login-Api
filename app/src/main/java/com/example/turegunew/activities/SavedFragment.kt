package com.example.turegunew.activities

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.turegunew.R
import com.example.turegunew.adapter.SaveAdapter
import com.example.turegunew.api.ApiInterface
import com.example.turegunew.api.RetrofitClient
import com.example.turegunew.models.Favoriot
import com.example.turegunew.models.Favourite
import com.example.turegunew.models.PropertyModel
import com.example.turegunew.utils.TokenManager
import kotlinx.android.synthetic.main.fragment_saved.*
import kotlinx.android.synthetic.main.fragment_saved.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SavedFragment : Fragment() {

    lateinit var tokenManager: TokenManager
    lateinit var token: String
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var saveAdapter: SaveAdapter
    private lateinit var rvRecyclerView: RecyclerView
    private var propertyLists: MutableList<Favourite> = ArrayList()
    private lateinit var mProgress: ProgressDialog
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_saved, container, false)

        mProgress = ProgressDialog(context)
        mProgress.setTitle("Processing...")
        mProgress.setMessage("Please wait...")
        mProgress.setCancelable(false)
        mProgress.isIndeterminate

        token = TokenManager(requireContext()).getToken()!!
        tokenManager = TokenManager(requireContext())
        rvRecyclerView = view.findViewById(R.id.rv_save)
        propertyLists = ArrayList()
        saveAdapter = SaveAdapter(requireContext(), propertyLists)
        rvRecyclerView.adapter = saveAdapter
        linearLayoutManager = LinearLayoutManager(requireContext())
        view.rv_save.layoutManager = linearLayoutManager

        getData()


        return view
    }

    private fun getData() {
        mProgress.show()
        val propertyList = RetrofitClient.getInstance().create(ApiInterface::class.java)
        val retrofitData = propertyList.saveProducts(token)

        retrofitData.enqueue(object : Callback<Favoriot> {
            override fun onResponse(
                call: Call<Favoriot>?,
                response: Response<Favoriot>?
            ) {
                if (response!!.code() == 200) {
                    val registerResponse: Favoriot = response.body()!!
                    //  Log.d("onResponse: ", registerResponse.toString())
                    propertyLists.addAll(registerResponse.data.favourites)
                    rv_save.adapter = saveAdapter
                    saveAdapter = SaveAdapter(requireContext(), propertyLists)
                    saveAdapter.notifyDataSetChanged()
                    mProgress.dismiss()
                }

            }

            override fun onFailure(call: Call<Favoriot>?, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
                mProgress.dismiss()
            }
        })
    }
}