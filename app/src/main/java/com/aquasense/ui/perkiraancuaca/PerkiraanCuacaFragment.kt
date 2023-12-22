package com.aquasense.ui.perkiraancuaca

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aquasense.databinding.FragmentPerkiraanCuacaBinding
import com.aquasense.ui.perkiraancuaca.adapter.PerkiraanCuacaAdapter
import com.aquasense.ui.perkiraancuaca.model.PerkiraanCuaca

class PerkiraanCuacaFragment : Fragment() {

    private var _binding: FragmentPerkiraanCuacaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val monitoringViewModel =
            ViewModelProvider(this)[PerkiraanCuacaViewModel::class.java]

        _binding = FragmentPerkiraanCuacaBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.tvPerkiraanCuacaTitle
        monitoringViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
        }

        binding.btnPerkiraanCuacaBack.setOnClickListener {
            navigateBack()
        }

        setupUI()

        return root
    }

    private fun navigateBack() {
        val fragmentManager = requireActivity().supportFragmentManager
        fragmentManager.popBackStack()
    }

    private fun setupUI() {
        val perkiraanCuacas = listOf(
            PerkiraanCuaca("Kuningan", "Berawan", "Berawan", "Hujan", "Petir"),
            PerkiraanCuaca("Cimahi", "Cerah", "Berawan", "Hujan", "Petir"),
            PerkiraanCuaca("Subang", "Cerah", "Berawan", "Hujan", "Petir"),
            PerkiraanCuaca("Cianjur", "Berawan", "Berawan", "Hujan", "Petir"),
            // Add more items as needed
        )


        val recyclerView: RecyclerView = binding.rvPerkiraanCuaca
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = PerkiraanCuacaAdapter(context, perkiraanCuacas)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}