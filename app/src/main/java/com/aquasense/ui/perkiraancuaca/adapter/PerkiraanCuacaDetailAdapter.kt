package com.aquasense.ui.perkiraancuaca.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.RecyclerView
import com.aquasense.R
import com.aquasense.ui.perkiraancuaca.model.PerkiraanCuacaDetail

class PerkiraanCuacaDetailAdapter(private val context: Context?, private val perkiraanCuacas: List<PerkiraanCuacaDetail>) :
    RecyclerView.Adapter<PerkiraanCuacaDetailAdapter.PerkiraanCuacaDetailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PerkiraanCuacaDetailViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_perkiraan_cuaca_detail, parent, false)
        return PerkiraanCuacaDetailViewHolder(itemView)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: PerkiraanCuacaDetailViewHolder, position: Int) {
        val perkiraanCuaca = perkiraanCuacas[position]
        val perkiraanCuacaDetailViewHolder = holder as PerkiraanCuacaDetailViewHolder?

        perkiraanCuacaDetailViewHolder?.tvItemPerkiraanCuacaDetailJam?.text = perkiraanCuaca.waktu

        when (perkiraanCuaca.kondisiCuaca) {
            "Cerah" -> perkiraanCuacaDetailViewHolder?.ivItemPerkiraanCuacaDetailKondisi?.setImageDrawable(context?.resources?.getDrawable(R.drawable.ic_sunny))
            "Berawan" -> perkiraanCuacaDetailViewHolder?.ivItemPerkiraanCuacaDetailKondisi?.setImageDrawable(context?.resources?.getDrawable(R.drawable.ic_partly_cloud))
            "Hujan" -> perkiraanCuacaDetailViewHolder?.ivItemPerkiraanCuacaDetailKondisi?.setImageDrawable(context?.resources?.getDrawable(R.drawable.ic_rainy))
            "Petir" -> perkiraanCuacaDetailViewHolder?.ivItemPerkiraanCuacaDetailKondisi?.setImageDrawable(context?.resources?.getDrawable(R.drawable.ic_rain_thunder))
        }
    }

    override fun getItemCount(): Int {
        return perkiraanCuacas.size
    }

    class PerkiraanCuacaDetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val llItemPerkiraanCuacaDetail: LinearLayoutCompat = itemView.findViewById(R.id.llItemPerkiraanCuacaDetail)
        val ivItemPerkiraanCuacaDetailKondisi: ImageView = itemView.findViewById(R.id.ivItemPerkiraanCuacaDetailKondisi)
        val tvItemPerkiraanCuacaDetailJam: TextView = itemView.findViewById(R.id.tvItemPerkiraanCuacaDetailJam)
    }
}
