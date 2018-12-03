package net.duan.felix.triptrack.vm

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import net.duan.felix.triptrack.data.Photo

class PhotoViewModel : ViewModel() {
  private var photoLiveData = MutableLiveData<ArrayList<Photo>>()

  fun getPhotos() = photoLiveData

  fun addPhoto(photo: Photo) {
    var currents = photoLiveData.value
    if (currents == null) {
      currents = ArrayList()
    }
    currents!!.add(photo)
    photoLiveData.value = currents
  }
}
