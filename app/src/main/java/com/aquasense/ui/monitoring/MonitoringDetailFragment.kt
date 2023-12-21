package com.aquasense.ui.monitoring

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.aquasense.databinding.FragmentMonitoringBinding
import com.aquasense.databinding.FragmentMonitoringDetailBinding

class MonitoringDetailFragment : Fragment() {

    private var _binding: FragmentMonitoringDetailBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val monitoringViewModel = ViewModelProvider(this)[MonitoringViewModel::class.java]

        _binding = FragmentMonitoringDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.tvMonitoringDetailTitleBeranda
        monitoringViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
        }

        binding.btnMonitoringDetailBackBeranda.setOnClickListener {
            navigateBack()
        }

        return root
    }

    private fun navigateBack() {
        // Get the FragmentManager
        val fragmentManager = requireActivity().supportFragmentManager

        // Pop the back stack to go back to FragmentA
        fragmentManager.popBackStack()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}