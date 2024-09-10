package com.example.ignitronlearn.homepage

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.ignitronlearn.R

data class Disasters(
    @DrawableRes val imageResourceId: Int,
    @StringRes val nameResourceId: Int,
    @StringRes val todoResourceId: Int,
    @StringRes val helplineResourceId: Int,
    @DrawableRes val todoImageResourceId: Int,
    @StringRes val newsResourceId: Int
)

val disasters = listOf(
    Disasters(R.drawable.earthquake,R.string.Earthquake,R.string.earthquakeTodo,R.string.earthquakeHelpline,R.drawable.earthquake,R.string.earthquakeNews),
    Disasters(R.drawable.fire,R.string.Fire,R.string.fireTodo,R.string.fireHelpline,R.drawable.earthquake,R.string.fireNews),
    Disasters(R.drawable.flodu,R.string.Flood,R.string.floodTodo,R.string.floodHelpline,R.drawable.earthquake,R.string.FloodNews),
    Disasters(R.drawable.lodu,R.string.Thunder,R.string.thunderTodo,R.string.thunderHelpline,R.drawable.earthquake,R.string.ThunderNews),
    Disasters(R.drawable.wind_hurricane_disaster_composition_vector,R.string.Storm,R.string.stormTodo,R.string.stormHelpline,R.drawable.earthquake,R.string.StormNews),
    Disasters(R.drawable.cyclone,R.string.Cyclone,R.string.CycloneTodo,R.string.earthquakeHelpline,R.drawable.earthquake,R.string.StormNews),
    Disasters(R.drawable.tsunami,R.string.Tsunami,R.string.TsunamiTodo,R.string.earthquakeHelpline,R.drawable.earthquake,R.string.StormNews),
    Disasters(R.drawable.ra,R.string.RoadAccident,R.string.RoadAccidentTodo,R.string.earthquakeHelpline,R.drawable.earthquake,R.string.StormNews),
)

