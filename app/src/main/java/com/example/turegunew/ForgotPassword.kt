package com.example.turegunew

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.turegunew.api.ApiInterface
import com.example.turegunew.api.RetrofitClient
import com.example.turegunew.models.ForgotPasswordReset
import com.example.turegunew.models.RegisterResponse
import kotlinx.android.synthetic.main.activity_forgot_password.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForgotPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        goBack.setOnClickListener {
            onBackPressed()
        }

        emailSubmitBtn.setOnClickListener {

            val email = etForgotEmail.text.toString().trim()

            if (email.isEmpty()){
                tvEmailError.text = getString(R.string.email_error)
            }

            forgotPasswordImpl(email)
        }
    }

    private fun forgotPasswordImpl(email: String) {

        val resInt = RetrofitClient.getInstance().create(ApiInterface::class.java)
        val forgotPasswordInfo = ForgotPasswordReset(email)

        resInt.forgotPassword(forgotPasswordInfo).enqueue(object : Callback<RegisterResponse>{
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                if (response.code() == 200){
                    val registerResponse: RegisterResponse = response.body()!!
                    if (registerResponse.code == 0){
                        Toast.makeText(applicationContext, registerResponse.message, Toast.LENGTH_LONG).show()
                    }else{
                        startActivity(Intent(this@ForgotPassword, SignIn::class.java))
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