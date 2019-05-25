package com.ejiaah.chattingapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.ejiaah.chattingapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnFragmentInteractionListener {

    private lateinit var toolbarTitle: TextView
    private val toolbarContentList = ObservableArrayList<ToolbarContent>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme_NoActionBar)
        //setContentView(R.layout.activity_main)

        // DataBinding
        // initView
        initView()
    }

    private fun initView() {
        var binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val navController = findNavController(R.id.nav_host_fragment)

        // Set up ActionBar
        setSupportActionBar(binding.toolbar)

        // Custom Toolbar Title을 사용하기 위해
        supportActionBar?.setDisplayShowTitleEnabled(false)

        // init view
        toolbarTitle = binding.toolbarTitle

        // binding
        binding.toolbarContentList = toolbarContentList

        // Set up bottom navigation menu
        binding.bottomNavView.setupWithNavController(navController)
    }

    override fun setupToolbar(title: String, toolbarContentList: MutableList<ToolbarContent>) {
        this.toolbarTitle.text = title
        this.toolbarContentList.clear()
        this.toolbarContentList.addAll(toolbarContentList)
    }

    enum class ToolbarContent {
        TITLE,
        SUBTITLE,
        CHARACTER,
        BACK,
        SEARCH,
        NAVIGATION
    }

    companion object {
        private const val TAG = "MainActivity"
    }

}
