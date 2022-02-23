package edu.temple.imageactivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter(_logos: Array<ImageObject>, _recyclerViewFunc: (ImageObject) -> Unit) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    val logos = _logos
    val recyclerViewFunc = _recyclerViewFunc

    inner class ImageViewHolder(_view: View) : RecyclerView.ViewHolder(_view) {

        val imageNameTextView = _view.findViewById<TextView>(R.id.textView)
        val imageDisplayView = _view.findViewById<ImageView>(R.id.imageView)

        lateinit var imageObject: RecyclerView.ViewHolder
        init {
            _view.setOnClickListener{recyclerViewFunc(logos[0])}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder{
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_main, parent, false)
        return ImageViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.imageNameTextView.text = logos[position].name
        holder.imageDisplayView.setImageResource(logos[position].code)

        holder.imageObject = RecyclerView.ViewHolder
    }

    override fun getItemCount(): Int {
        return logos.size
    }

}
