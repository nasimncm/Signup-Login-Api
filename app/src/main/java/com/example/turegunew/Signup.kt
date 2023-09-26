package com.example.turegunew

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.turegunew.activities.ProfileFragment
import com.example.turegunew.api.ApiInterface
import com.example.turegunew.api.RetrofitClient
import com.example.turegunew.models.ProfileModel
import com.example.turegunew.models.Register
import com.example.turegunew.models.RegisterResponse
import com.example.turegunew.models.UserProfileData
import com.example.turegunew.utils.TokenManager
import kotlinx.android.synthetic.main.activity_signup.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Signup : AppCompatActivity() {

    private lateinit var mProgress: ProgressDialog
    private lateinit var profileModel: UserProfileData

    @Inject
    lateinit var tokenManager: TokenManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        mProgress = ProgressDialog(this)
        mProgress.setTitle("Processing...")
        mProgress.setMessage("Please wait...")
        mProgress.setCancelable(false)
        mProgress.isIndeterminate

        tokenManager = TokenManager(this)
        signin.setOnClickListener {
            val intent = Intent(this, SignIn::class.java)
            startActivity(intent)
        }

        btnSignUp.setOnClickListener {

            val firstName = etFirstName.text.toString().trim()
            val lastName = etLastName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            /*val mFragment = ProfileFragment()
            val mBundle = Bundle()
            mBundle.putString("firstName", etFirstName.text.toString())
            mFragment.arguments = mBundle*/

            if (firstName.isEmpty()) {
                tvNameErrorSignUp.text = getString(R.string.firstName_error)
            }
            if (lastName.isEmpty()) {
                tvLastErrorSignUp.text = getString(R.string.lastName_error)
            }

            if (email.isEmpty()) {
                tvEmailErrorSignUp.text = getString(R.string.email_error)
            }

            if (password.isEmpty()) {
                tvPasswordErrorSignUp.text = getString(R.string.password_error)
            }

            register(firstName, lastName, email, password)
        }
    }

    private fun register(firstName: String, lastName: String, email: String, password: String) {
        mProgress.show()
        val retIn = RetrofitClient.getInstance().create(ApiInterface::class.java)
        val registerInfo = Register(firstName, lastName, email, password)

        retIn.createUser(registerInfo).enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                if (response.code() == 200) {
                    val registerResponse: RegisterResponse = response.body()!!
                    if (registerResponse.code == 0) {
                        Toast.makeText(
                            applicationContext, registerResponse.message, Toast.LENGTH_LONG
                        ).show()
                        mProgress.dismiss()
                    } else {
                        tokenManager.saveToken(registerResponse.data!!.authToken)
                        startActivity(Intent(this@Signup, SignIn::class.java))
                        Toast.makeText(
                            applicationContext,
                            "Registration success!",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                } else {
                    Toast.makeText(applicationContext, "Registration failed!", Toast.LENGTH_SHORT)
                        .show()
                    mProgress.dismiss()
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
                mProgress.dismiss()
            }
        })
    }
}