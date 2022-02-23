package edu.temple.imageactivity

import android.graphics.drawable.DrawableContainer
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val imageView = findViewById<ImageView>(R.id.imageView)

        val logos = arrayOf(
            ImageObject("bds", R.drawable.bds),
            ImageObject("complexity", R.drawable.complexity),
            ImageObject("dignitas", R.drawable.dignitas),
            ImageObject("envy", R.drawable.envy),
            ImageObject("eunited", R.drawable.eunited),
            ImageObject("evil geniuses", R.drawable.evil_geniuses_),
            ImageObject("faze", R.drawable.faze),
            ImageObject("g2", R.drawable.g2),
            ImageObject("ghost", R.drawable.ghost),
            ImageObject("misfits", R.drawable.misfits),
            ImageObject("nrg", R.drawable.nrg),
            ImageObject("team liquid", R.drawable.team_liquid),
            ImageObject("rogue", R.drawable.rogue),
            ImageObject("queso", R.drawable.queso),
            ImageObject("version1", R.drawable.version1),
            ImageObject("vitality", R.drawable.vitality),
            )

        val myRecyclerViewFunc = {imageObject:ImageObject ->
            imageView.setImageResource(imageObject.photo)
        }

        recyclerView.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 3)
            adapter = ImageAdapter(logos, myRecyclerViewFunc)
        }
    }
}