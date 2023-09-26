package com.example.turegunew.activities

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.turegunew.R
import com.example.turegunew.ResetPassword
import com.example.turegunew.api.ApiInterface
import com.example.turegunew.api.RetrofitClient
import com.example.turegunew.models.ProfileModel
import com.example.turegunew.utils.TokenManager
import kotlinx.android.synthetic.main.activity_edit_profile.*
import kotlinx.android.synthetic.main.fragment_profile.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditProfile : AppCompatActivity() {
    lateinit var tokenManager: TokenManager
    lateinit var token: String
    private lateinit var mProgress: ProgressDialog
    private lateinit var profileModel: ProfileModel;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        etChangePassword.setOnClickListener {
            val intent = Intent(this, ResetPassword::class.java)
            startActivity(intent)
        }

        ivBack.setOnClickListener {
            onBackPressed()
        }

        profileModel = ProfileModel()

        token = TokenManager(this).getToken()!!
        tokenManager = TokenManager(this)
        mProgress = ProgressDialog(this)
        mProgress.setTitle("Processing...")
        mProgress.setMessage("Please wait...")
        mProgress.setCancelable(false)
        mProgress.isIndeterminate

        val firstName = findViewById<EditText>(R.id.etName)
        getData()

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
                    etName.setText(profileModel.data?.profile?.firstName)
                    etLoginEmail.setText( profileModel.data?.profile?.email.toString())
                    etContact.setText(profileModel.data?.profile?.phone.toString())
                    mProgress.dismiss()
                }
            }

            override fun onFailure(call: Call<ProfileModel>?, t: Throwable) {
                Toast.makeText(this@EditProfile, t.message, Toast.LENGTH_SHORT).show()
                mProgress.dismiss()
            }
        })
    }
}