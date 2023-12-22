package com.aquasense.ui.home

import android.annotation.SuppressLint
import android.content.Intent
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
import com.aquasense.ui.autentikasi.login.LoginActivity
import com.aquasense.ui.monitoring.MonitoringFragment

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
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
        val monitoringFragment = MonitoringFragment()
        val fragmentManager = requireActivity().supportFragmentManager
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()

        transaction.replace(R.id.clHome, monitoringFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebView() {
        val webSettings: WebSettings = binding.wvHomeVideoInfo.settings
        webSettings.javaScriptEnabled = true

        webSettings.mediaPlaybackRequiresUserGesture = false

        binding.wvHomeVideoInfo.webChromeClient = WebChromeClient()

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
            navigateToLogin()
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

    private fun navigateToLogin() {
        // Implement navigation to login activity here
        val intent = Intent(requireContext(), LoginActivity::class.java)
        startActivity(intent)
        requireActivity().finish() // Optional: finish the current activity if needed
    }
}