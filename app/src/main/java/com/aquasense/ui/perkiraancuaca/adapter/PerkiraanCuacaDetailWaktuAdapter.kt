package com.aquasense.ui.perkiraancuaca.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aquasense.R

class PerkiraanCuacaDetailWaktuAdapter(private val timeSlots: List<String>, private val onTimeSlotClick: (String) -> Unit) :
    RecyclerView.Adapter<PerkiraanCuacaDetailWaktuAdapter.TimeSlotViewHolder>() {

    inner class TimeSlotViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.tvItemPerkiraanCuacaDetailWaktu)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeSlotViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_perkiraan_cuaca_detail_waktu, parent, false)
        return TimeSlotViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TimeSlotViewHolder, position: Int) {
        val timeSlot = timeSlots[position]
        holder.textView.text = timeSlot

        // Set a click listener for each item
        holder.textView.setOnClickListener {
            onTimeSlotClick(timeSlot)
        }
    }

    override fun getItemCount(): Int {
        return timeSlots.size
    }
}
