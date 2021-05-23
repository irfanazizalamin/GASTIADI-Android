package com.dicoding.picodiploma.gastiadi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.picodiploma.gastiadi.ui.dashboard.DashboardFragment
import com.dicoding.picodiploma.gastiadi.ui.chat.ChatFragment
import com.dicoding.picodiploma.gastiadi.ui.profile.ProfileFragment
import com.luseen.spacenavigation.SpaceItem
import com.luseen.spacenavigation.SpaceNavigationView
import com.luseen.spacenavigation.SpaceOnClickListener


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, ChatFragment())
                .commit()

        // Bottom Navigation Scope
        val navView: SpaceNavigationView = findViewById(R.id.nav_view)
        navView.initWithSaveInstanceState(savedInstanceState)
        navView.addSpaceItem(SpaceItem("", R.drawable.ic_home))
        navView.addSpaceItem(SpaceItem("", R.drawable.ic_profile))
        navView.setSpaceOnClickListener(object : SpaceOnClickListener {
            override fun onCentreButtonClick() {
                navView.setCentreButtonSelectable(true)

                supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment, DashboardFragment())
                    .commit()
            }

            override fun onItemClick(itemIndex: Int, itemName: String) {
                when (itemIndex) {
                    0 -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.nav_host_fragment, ChatFragment())
                            .commit()
                    }
                    1 -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.nav_host_fragment, ProfileFragment())
                            .commit()
                    }
                }
            }

            override fun onItemReselected(itemIndex: Int, itemName: String) {
            }
        })
    }
}