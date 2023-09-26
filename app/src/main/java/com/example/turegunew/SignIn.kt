package com.example.turegunew

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.turegunew.api.ApiInterface
import com.example.turegunew.api.RetrofitClient
import com.example.turegunew.models.LoginResponse
import com.example.turegunew.models.RegisterResponse
import com.example.turegunew.models.UserLogin
import com.example.turegunew.utils.TokenManager
import kotlinx.android.synthetic.main.activity_signin.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class SignIn : AppCompatActivity() {
    @Inject
    lateinit var tokenManager: TokenManager
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    private lateinit var  mProgress: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        mProgress = ProgressDialog(this)
        mProgress.setTitle("Processing...")
        mProgress.setMessage("Please wait...")
        mProgress.setCancelable(false)
        mProgress.isIndeterminate

        tokenManager = TokenManager(this)
        forgotPassword.setOnClickListener {
            val intent = Intent(this, ForgotPassword::class.java)
            startActivity(intent)
        }

        loginBtn.setOnClickListener {
            /*val homepage = Intent(this, MainActivity::class.java)
            startActivity(homepage)*/

            val email = etLoginEmail.text.toString().trim()
            val password = etLoginPassword.text.toString().trim()

            if (email.isEmpty() && email.matches(emailPattern.toRegex())) {
                tvEmailError.text = getString(R.string.email_error)
            }

            if (password.isEmpty()) {
                tvPasswordError.text = getString(R.string.password_error)
            }
            login(email, password)
        }

        signup.setOnClickListener {
            val intent = Intent(this, Signup::class.java)
            startActivity(intent)
        }
    }

    private fun login(email: String, password: String) {
        mProgress.show()

        val retIn = RetrofitClient.getInstance().create(ApiInterface::class.java)
        val signInInfo = UserLogin(email, password)

        retIn.loginUser(signInInfo).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(
                call: Call<LoginResponse>, response: Response<LoginResponse>
            ) {
                if (response.code() == 200) {
                    val registerResponse: LoginResponse = response.body()!!
                    if (registerResponse.code == 0) {
                        Toast.makeText(
                            applicationContext, registerResponse.message, Toast.LENGTH_LONG
                        ).show()
                        mProgress.dismiss()
                    } else {
                        tokenManager.saveToken(registerResponse.data!!.authToken)
                        startActivity(Intent(this@SignIn, MainActivity::class.java))
                        Toast.makeText(applicationContext, "Login success!", Toast.LENGTH_SHORT)
                            .show()
                    }
                } else {
                    Toast.makeText(applicationContext, "Login failed!", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
                mProgress.dismiss()
            }
        })

    }
}