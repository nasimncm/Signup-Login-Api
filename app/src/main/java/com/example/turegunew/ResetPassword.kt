package com.example.turegunew

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.turegunew.activities.EditProfile
import com.example.turegunew.api.ApiInterface
import com.example.turegunew.api.RetrofitClient
import com.example.turegunew.models.*
import com.example.turegunew.utils.TokenManager
import kotlinx.android.synthetic.main.activity_forgot_password.*
import kotlinx.android.synthetic.main.activity_forgot_password.tvEmailError
import kotlinx.android.synthetic.main.activity_reset_password.*
import kotlinx.android.synthetic.main.activity_signin.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ResetPassword : AppCompatActivity() {
    @Inject
    lateinit var tokenManager: TokenManager
    private lateinit var  mProgress: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        mProgress = ProgressDialog(this)
        mProgress.setTitle("Processing...")
        mProgress.setMessage("Please wait...")
        mProgress.setCancelable(false)
        mProgress.isIndeterminate

        tokenManager = TokenManager(this)
        resetPasswordBtn.setOnClickListener {
            val oldPassword = etOldPassword.text.toString().trim()
            val newPassword = etNewPassword.text.toString().trim()

            if (oldPassword.isEmpty()) {
                tvOldError.text = getString(R.string.old_error)
            }

            if (newPassword.isEmpty()) {
                tvNewError.text = getString(R.string.new_error)
            }
            changePass(oldPassword, newPassword)
        }

        resetGoBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun changePass(oldPassword: String, newPassword: String) {

        val resInt = RetrofitClient.getInstance().create(ApiInterface::class.java)
        val changePass = ChangePasswordReset(oldPassword, newPassword)

        resInt.changePassword(changePass).enqueue(object : Callback<RegisterResponse>{
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                if (response.code() == 200){
                    val registerResponse: RegisterResponse = response.body()!!
                    if (registerResponse.code == 0){
                        Toast.makeText(applicationContext, registerResponse.message, Toast.LENGTH_LONG).show()
                    }else{
                        startActivity(Intent(this@ResetPassword, SignIn::class.java))
                        Toast.makeText(applicationContext, "Password reset & sent to your given email id", Toast.LENGTH_LONG).show()
                    }
                }else{
                    Toast.makeText(applicationContext, "Password reset failed!!", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }
        })

    }
}