package com.aquasense.ui.perkiraancuaca.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.aquasense.R
import com.aquasense.ui.perkiraancuaca.PerkiraanCuacaDetailActivity
import com.aquasense.ui.perkiraancuaca.model.PerkiraanCuaca

class PerkiraanCuacaAdapter(private val context: Context?, private val perkiraanCuacas: List<PerkiraanCuaca>) :
    RecyclerView.Adapter<PerkiraanCuacaAdapter.PerkiraanCuacaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PerkiraanCuacaViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_perkiraan_cuaca, parent, false)
        return PerkiraanCuacaViewHolder(itemView)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: PerkiraanCuacaViewHolder, position: Int) {
        val perkiraanCuaca = perkiraanCuacas[position]
        val perkiraanCuacaViewHolder = holder as PerkiraanCuacaViewHolder?

        perkiraanCuacaViewHolder?.tvItemPerkiraanCuacaTitle?.text = perkiraanCuaca.kota

        when (perkiraanCuaca.kondisiCuacaPagi) {
            "Cerah" -> perkiraanCuacaViewHolder?.ivItemPerkiraanCuacaPagi?.setImageDrawable(context?.resources?.getDrawable(R.drawable.ic_sunny))
            "Berawan" -> perkiraanCuacaViewHolder?.ivItemPerkiraanCuacaPagi?.setImageDrawable(context?.resources?.getDrawable(R.drawable.ic_partly_cloud))
            "Hujan" -> perkiraanCuacaViewHolder?.ivItemPerkiraanCuacaPagi?.setImageDrawable(context?.resources?.getDrawable(R.drawable.ic_rainy))
            "Petir" -> perkiraanCuacaViewHolder?.ivItemPerkiraanCuacaPagi?.setImageDrawable(context?.resources?.getDrawable(R.drawable.ic_rain_thunder))
        }

        when (perkiraanCuaca.kondisiCuacaSiang) {
            "Cerah" -> perkiraanCuacaViewHolder?.ivItemPerkiraanCuacaSiang?.setImageDrawable(context?.resources?.getDrawable(R.drawable.ic_sunny))
            "Berawan" -> perkiraanCuacaViewHolder?.ivItemPerkiraanCuacaSiang?.setImageDrawable(context?.resources?.getDrawable(R.drawable.ic_partly_cloud))
            "Hujan" -> perkiraanCuacaViewHolder?.ivItemPerkiraanCuacaSiang?.setImageDrawable(context?.resources?.getDrawable(R.drawable.ic_rainy))
            "Petir" -> perkiraanCuacaViewHolder?.ivItemPerkiraanCuacaSiang?.setImageDrawable(context?.resources?.getDrawable(R.drawable.ic_rain_thunder))
        }

        when (perkiraanCuaca.kondisiCuacaSore) {
            "Cerah" -> perkiraanCuacaViewHolder?.ivItemPerkiraanCuacaSore?.setImageDrawable(context?.resources?.getDrawable(R.drawable.ic_sunny))
            "Berawan" -> perkiraanCuacaViewHolder?.ivItemPerkiraanCuacaSore?.setImageDrawable(context?.resources?.getDrawable(R.drawable.ic_partly_cloud))
            "Hujan" -> perkiraanCuacaViewHolder?.ivItemPerkiraanCuacaSore?.setImageDrawable(context?.resources?.getDrawable(R.drawable.ic_rainy))
            "Petir" -> perkiraanCuacaViewHolder?.ivItemPerkiraanCuacaSore?.setImageDrawable(context?.resources?.getDrawable(R.drawable.ic_rain_thunder))
        }

        when (perkiraanCuaca.kondisiCuacaSore) {
            "Cerah" -> perkiraanCuacaViewHolder?.ivItemPerkiraanCuacaMalam?.setImageDrawable(context?.resources?.getDrawable(R.drawable.ic_sunny))
            "Berawan" -> perkiraanCuacaViewHolder?.ivItemPerkiraanCuacaMalam?.setImageDrawable(context?.resources?.getDrawable(R.drawable.ic_partly_cloud))
            "Hujan" -> perkiraanCuacaViewHolder?.ivItemPerkiraanCuacaMalam?.setImageDrawable(context?.resources?.getDrawable(R.drawable.ic_rainy))
            "Petir" -> perkiraanCuacaViewHolder?.ivItemPerkiraanCuacaMalam?.setImageDrawable(context?.resources?.getDrawable(R.drawable.ic_rain_thunder))
        }

        perkiraanCuacaViewHolder?.clItemPerkiraanCuaca?.setOnClickListener {
            val intent = Intent(context, PerkiraanCuacaDetailActivity::class.java)
            intent.putExtra("kota", perkiraanCuaca.kota)
            context?.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return perkiraanCuacas.size
    }

    class PerkiraanCuacaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val clItemPerkiraanCuaca: ConstraintLayout = itemView.findViewById(R.id.clItemPerkiraanCuaca)
        val tvItemPerkiraanCuacaTitle: TextView = itemView.findViewById(R.id.tvItemPerkiraanCuacaTitle)
        val ivItemPerkiraanCuacaPagi: ImageView = itemView.findViewById(R.id.ivItemPerkiraanCuacaPagi)
        val ivItemPerkiraanCuacaSiang: ImageView = itemView.findViewById(R.id.ivItemPerkiraanCuacaSiang)
        val ivItemPerkiraanCuacaSore: ImageView = itemView.findViewById(R.id.ivItemPerkiraanCuacaSore)
        val ivItemPerkiraanCuacaMalam: ImageView = itemView.findViewById(R.id.ivItemPerkiraanCuacaMalam)
    }
}
