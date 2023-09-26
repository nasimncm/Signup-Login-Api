package com.example.turegunew.activities

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.turegunew.R
import com.example.turegunew.SignIn
import com.example.turegunew.api.ApiInterface
import com.example.turegunew.api.RetrofitClient
import com.example.turegunew.models.ProfileModel
import com.example.turegunew.utils.SharedPref
import com.example.turegunew.utils.TokenManager
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileFragment : Fragment() {
    lateinit var tokenManager: TokenManager
    lateinit var token: String
    private lateinit var mProgress: ProgressDialog
    private lateinit var profileModel: ProfileModel;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        view.logout.setOnClickListener {
            tokenManager.clear()
            val intent = Intent(context, SignIn::class.java)
            startActivity(intent)
        }

        profileModel = ProfileModel()

        token = TokenManager(requireContext()).getToken()!!
        tokenManager = TokenManager(requireContext())
        mProgress = ProgressDialog(context)
        mProgress.setTitle("Processing...")
        mProgress.setMessage("Please wait...")
        mProgress.setCancelable(false)
        mProgress.isIndeterminate

        val savede = view.findViewById<TextView>(R.id.saved)

        savede.setOnClickListener {
            val savedFragment = SavedFragment()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.add(R.id.drawableLayout, savedFragment)
            transaction.addToBackStack(tag)
            transaction.commit()
        }

        val editProfile = view.findViewById<ImageView>(R.id.edit_profile)

        editProfile.setOnClickListener {
            val intent = Intent(requireContext(), EditProfile::class.java)
            startActivity(intent)
        }
        getData()
        return view
    }

    private fun getData() {
        mProgress.show()
        val propertyList = RetrofitClient.getInstance().create(ApiInterface::class.java)
        val retrofitData = propertyList.profile(token)

        retrofitData.enqueue(object : Callback<ProfileModel> {
            override fun onResponse(
                call: Call<ProfileModel>?,
                response: Response<ProfileModel>?
            ) {
                if (response!!.code() == 200) {
                    profileModel = ProfileModel()
                    profileModel = response.body()!!
                    user_first_name.text = profileModel.data?.profile?.firstName.toString()
                    user_last_name.text = profileModel.data?.profile?.lastName.toString()
                    tv_email.text = profileModel.data?.profile?.email.toString()
                    follower.text = profileModel.data?.profile?.followedAgents.toString()
                    tv_language.text = profileModel.data?.profile?.lang?.code.toString()
                    mProgress.dismiss()
                }
            }

            override fun onFailure(call: Call<ProfileModel>?, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
                mProgress.dismiss()
            }
        })
    }
}