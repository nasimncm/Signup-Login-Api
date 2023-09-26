package com.example.turegunew

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.turegunew.activities.ProfileFragment
import com.example.turegunew.activities.PropertyDetails
import com.example.turegunew.activities.SavedFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var bottomNav : BottomNavigationView
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpView()

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.search ->{
                    loadFragment(SearchFragment())
                    true
                }
                R.id.saved ->{
                    loadFragment(SavedFragment())
                    true
                }
                R.id.agents ->{
                    loadFragment(AgentFragment())
                    true
                }
                R.id.notification ->{
                    loadFragment(NotificationFragment())
                    true
                }
                R.id.account ->{
                    loadFragment(ProfileFragment())
                    true
                }
                else -> {
                    false
                }
            }
        }

    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_layout,fragment)
            commit()
        }
    }

    private fun setUpView() {
        setUpDrawerLayout()
        loadFragment(SearchFragment())
    }

    private fun setUpDrawerLayout() {
        setSupportActionBar(topAppBar)
        toggle = ActionBarDrawerToggle(this, drawableLayout, R.string.nav_open, R.string.nav_close)
        toggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item))
            return true
        return super.onOptionsItemSelected(item)
    }

    private fun changeFragment(frag: Fragment) {
        val fragment = supportFragmentManager.beginTransaction()
        fragment.replace(R.id.frame_layout, frag).commit()
    }

    fun setToolBarTitle(title: String) {
        supportActionBar?.title = title
    }
}