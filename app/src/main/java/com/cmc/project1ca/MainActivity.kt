package com.cmc.project1ca

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    lateinit var tablayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        viewPager.adapter = ViewPagerAdapter(this)

        tablayout = findViewById(R.id.tablayout)

        TabLayoutMediator(tablayout,viewPager) {
                tab,position -> when(position) {
                    0-> tab.text = "First"
                    1-> tab.text = "Second"
                    2-> tab.text = "Third"
                }
        }.attach()
    }
}

class ViewPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FragmentPresentation()
            1 -> FragmentList()
            2 -> FragmentImageText()
            else -> throw IllegalStateException("Unexpected position $position")
        }
    }
}