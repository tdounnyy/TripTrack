package net.duan.felix.triptrack.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.photo_item.view.*
import net.duan.felix.triptrack.R
import net.duan.felix.triptrack.data.Photo

class PhotoRecyclerAdapter : RecyclerView.Adapter<PhotoRecyclerAdapter.PhotoViewHolder>() {
  private var photoList: ArrayList<Photo> = ArrayList()

  fun setPhotos(photos: ArrayList<Photo>) {
    photoList = photos
    notifyDataSetChanged()
  }

  override fun onCreateViewHolder(parent: ViewGroup, index: Int): PhotoViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.photo_item, parent, false)
    return PhotoViewHolder(view)
  }

  override fun getItemCount(): Int {
    return photoList.size
  }

  override fun onBindViewHolder(holder: PhotoViewHolder, index: Int) {
    val photo = photoList.get(index)
    holder.updatePhotoName(photo.name)
  }

  class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun updatePhotoName(name: String) {
      itemView.photo_name.text = name
    }
  }
}
