package net.duan.felix.triptrack.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.main_fragment.*
import net.duan.felix.triptrack.R
import net.duan.felix.triptrack.data.Photo
import net.duan.felix.triptrack.vm.PhotoViewModel

class MainFragment : Fragment() {

  companion object {
    fun newInstance() = MainFragment()
  }

  private lateinit var viewModel: PhotoViewModel

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    return inflater.inflate(R.layout.main_fragment, container, false)
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    val adapter = PhotoRecyclerAdapter()
    viewModel = ViewModelProviders.of(this).get(PhotoViewModel::class.java)
    viewModel.getPhotos().observe(this, Observer {
      it?.let {
        adapter.setPhotos(it)
      }
    })
    photo_gallery.adapter = adapter
  }

  override fun onResume() {
    super.onResume()
    for (i in 0..5) {
      val photo = Photo("photo $i")
      viewModel.addPhoto(photo)
    }
  }
}
