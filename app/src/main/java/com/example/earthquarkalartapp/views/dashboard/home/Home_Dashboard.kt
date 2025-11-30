package com.example.earthquarkalartapp.views.dashboard.home

import android.os.Bundle
import com.example.earthquarkalartapp.base.BaseFragment
import com.example.earthquarkalartapp.databinding.FragmentHomeDashboardBinding
import dagger.hilt.android.AndroidEntryPoint
import org.maplibre.android.annotations.MarkerOptions
import org.maplibre.android.camera.CameraPosition
import org.maplibre.android.geometry.LatLng

@AndroidEntryPoint
class Home_Dashboard : BaseFragment<FragmentHomeDashboardBinding>(FragmentHomeDashboardBinding::inflate) {

    private val lat = 23.8103
    private val lon = 90.4125

    override fun setListener() {
        binding.mapView.getMapAsync { map ->
            map.setStyle("https://demotiles.maplibre.org/style.json") { style ->

                map.cameraPosition = CameraPosition.Builder()
                    .target(LatLng(lat, lon))
                    .zoom(6.0)
                    .build()

                val marker = MarkerOptions()
                    .position(LatLng(lat, lon))
                    .title("Dhaka")
                map.addMarker(marker)
            }
        }
    }

    override fun allObserver() {
        // Add observers if needed
    }

    override fun onStart() {
        super.onStart()
        binding.mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        binding.mapView.onResume()
    }

    override fun onPause() {
        binding.mapView.onPause()
        super.onPause()
    }

    override fun onStop() {
        binding.mapView.onStop()
        super.onStop()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        binding.mapView.onLowMemory()
    }

    override fun onDestroy() {
        binding.mapView.onDestroy()
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        binding.mapView.onSaveInstanceState(outState)
    }
}
