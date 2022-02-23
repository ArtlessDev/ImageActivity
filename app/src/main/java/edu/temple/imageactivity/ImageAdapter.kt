package edu.temple.imageactivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter(_logos: Array<ImageObject>, _recyclerFunc : (ImageObject) ->Unit) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    val logos = _logos
    val recyclerViewFunc = _recyclerFunc

    inner class ImageViewHolder(_view: View) : RecyclerView.ViewHolder(_view) {
        val imageNameTextView = _view.findViewById<TextView>(R.id.textView)
        var imageDisplayView = _view.findViewById<ImageView>(R.id.photoOfMyLogo)

        lateinit var imageObject: ImageObject
        init {
            _view.setOnClickListener{recyclerViewFunc(imageObject)}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder{
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_layout, parent, false)
        return ImageViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val logo = logos[position]
        holder.imageNameTextView.text = logos[position].name
        holder.imageDisplayView.setImageDrawable(holder.imageDisplayView.context.getDrawable(logo.photo))
    }

    override fun getItemCount(): Int {
        return logos.size
    }
}
