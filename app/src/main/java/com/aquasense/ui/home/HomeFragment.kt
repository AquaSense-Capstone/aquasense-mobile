package com.aquasense.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.aquasense.R
import com.aquasense.databinding.FragmentHomeBinding
import com.aquasense.ui.monitoring.MonitoringFragment

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.tvHomeInfoEdukasi
        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
        }

        binding.btnHomeCekLokasi.setOnClickListener {
            navigateToFragment()
        }

        binding.btnHomeLogout.setOnClickListener {
            showLogoutDialog()
        }

        setupWebView()

        return root
    }

    private fun navigateToFragment() {
        // Create an instance of Fragment
        val monitoringFragment = MonitoringFragment()

        // Get the FragmentManager
        val fragmentManager = requireActivity().supportFragmentManager

        // Begin a FragmentTransaction
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()

        // Replace the current fragment with Fragment
        transaction.replace(R.id.clHome, monitoringFragment)

        // Add the transaction to the back stack (optional, allows the user to navigate back)
        transaction.addToBackStack(null)

        // Commit the transaction
        transaction.commit()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebView() {
        // Enable JavaScript
        val webSettings: WebSettings = binding.wvHomeVideoInfo.settings
        webSettings.javaScriptEnabled = true

        // Enable HTML5 video support
        webSettings.mediaPlaybackRequiresUserGesture = false

        // Set up WebView to handle video playback
        binding.wvHomeVideoInfo.webChromeClient = WebChromeClient()

        // Load the YouTube video
        val videoId = "sJsC6zQCfNI"
        val videoUrls = "https://www.youtube.com/embed/$videoId"
        binding.wvHomeVideoInfo.loadUrl(videoUrls)
    }

    private fun showLogoutDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Logout")
        builder.setMessage("Are you sure you want to logout?")
        builder.setPositiveButton("Logout") { dialog, which ->
            dialog.dismiss()
            requireActivity().supportFragmentManager.beginTransaction().remove(this).commit()
        }
        builder.setNegativeButton("Cancel") { dialog, which ->
            // Dismiss the dialog if the user clicks on Cancel
            dialog.dismiss()
        }

        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}