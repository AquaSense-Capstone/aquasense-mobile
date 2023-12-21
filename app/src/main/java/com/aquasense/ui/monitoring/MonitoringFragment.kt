package com.aquasense.ui.monitoring

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.aquasense.R
import com.aquasense.databinding.FragmentMonitoringBinding

class MonitoringFragment : Fragment() {

    private var _binding: FragmentMonitoringBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val monitoringViewModel =
            ViewModelProvider(this).get(MonitoringViewModel::class.java)

        _binding = FragmentMonitoringBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.tvTitleBeranda
        monitoringViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
        }

        binding.btnMonitoringBackBeranda.setOnClickListener {
            navigateBack()
        }

        binding.btnMonitoringInfoBanjir.setOnClickListener {
            navigateToFragment()
        }

        return root
    }

    private fun navigateBack() {
        // Get the FragmentManager
        val fragmentManager = requireActivity().supportFragmentManager

        // Pop the back stack to go back to FragmentA
        fragmentManager.popBackStack()
    }

    private fun navigateToFragment() {
        // Create an instance of Fragment
        val monitoringDetailFragment = MonitoringDetailFragment()

        // Get the FragmentManager
        val fragmentManager = requireActivity().supportFragmentManager

        // Begin a FragmentTransaction
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()

        // Replace the current fragment with Fragment
        transaction.replace(R.id.clHome, monitoringDetailFragment)

        // Add the transaction to the back stack (optional, allows the user to navigate back)
        transaction.addToBackStack(null)

        // Commit the transaction
        transaction.commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}