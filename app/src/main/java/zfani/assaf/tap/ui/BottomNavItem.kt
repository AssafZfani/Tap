package zfani.assaf.tap.ui

import zfani.assaf.tap.R

sealed class BottomNavItem(var title: String, var icon: Int, var screen_route: String) {

    object Home : BottomNavItem("Home", R.drawable.ic_home, "home")
    object Empty : BottomNavItem("Empty", R.drawable.ic_empty, "empty")
    object Thumbnail : BottomNavItem("Thumbnail", android.R.drawable.star_on, "thumbnail")
}