package com.ejiaah.chattingapp.adapters

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import com.ejiaah.chattingapp.MainActivity
import com.ejiaah.chattingapp.R

@BindingAdapter("app:isVisible")
fun bindIsVisible(view: View, isVisible: Boolean) {
    view.visibility = if (isVisible) {
        View.VISIBLE
    } else {
        View.GONE
    }
}


@BindingAdapter("app:isVisibleToolbarContent")
fun bindIsVisibleToolbarContent(view: View, toolbarContentList: ObservableArrayList<MainActivity.ToolbarContent>) {

    when (view.id) {
        R.id.toolbar -> {
            view.visibility = if (toolbarContentList.isNullOrEmpty()) View.GONE else View.VISIBLE
        }
        R.id.toolbar_title -> {
            view.visibility = if (toolbarContentList.contains(MainActivity.ToolbarContent.TITLE)) View.VISIBLE else View.GONE
        }
        R.id.toolbar_change_character_button -> {
            view.visibility = if (toolbarContentList.contains(MainActivity.ToolbarContent.CHARACTER)) View.VISIBLE else View.GONE
        }
        else -> {

        }
    }

}
