package com.aquasense.ui.perkiraancuaca

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aquasense.databinding.ActivityPerkiraanCuacaDetailBinding
import com.aquasense.ui.perkiraancuaca.adapter.PerkiraanCuacaDetailAdapter
import com.aquasense.ui.perkiraancuaca.adapter.PerkiraanCuacaDetailWaktuAdapter
import com.aquasense.ui.perkiraancuaca.model.PerkiraanCuacaDetail

class PerkiraanCuacaDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPerkiraanCuacaDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPerkiraanCuacaDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
    }

    private fun setupUI() {
        binding.btnPerkiraanCuacaDetailBack.setOnClickListener {
            onBackPressed()
        }

        val timeSlots = listOf(
            "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00",
            "19:00", "20:00", "21:00", "22:00", "23:00", "24:00"
        )

        val namaKota = intent.getStringExtra("kota") ?: "-"
        binding.tvPerkiraanCuacaDetailTitle.text = namaKota
        binding.tvPerkiraanCuacaDetailKota.text = namaKota

        val rvPerkiraanCuacaWaktu: RecyclerView = binding.rvPerkiraanCuacaWaktu
        rvPerkiraanCuacaWaktu.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvPerkiraanCuacaWaktu.adapter = PerkiraanCuacaDetailWaktuAdapter(timeSlots) { selectedTimeSlot ->
            // Handle click event, for example, show a toast with the selected time slot
            Toast.makeText(this, "Selected time: $selectedTimeSlot", Toast.LENGTH_SHORT).show()
        }

        val perkiraanCuacas = listOf(
            PerkiraanCuacaDetail("07:00", "Cerah"),
            PerkiraanCuacaDetail("08:00", "Hujan"),
            PerkiraanCuacaDetail("09:00", "Petir"),
            PerkiraanCuacaDetail("10:00", "Berawan"),
            // Add more items as needed
        )

        val rvPerkiraanCuaca: RecyclerView = binding.rvPerkiraanCuaca
        val gridLayoutManager = GridLayoutManager(this, 2)
        rvPerkiraanCuaca.layoutManager = gridLayoutManager
        rvPerkiraanCuaca.adapter = PerkiraanCuacaDetailAdapter(this, perkiraanCuacas)
    }
}