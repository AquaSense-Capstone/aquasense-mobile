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
        val fragmentManager = requireActivity().supportFragmentManager
        fragmentManager.popBackStack()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}