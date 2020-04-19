package br.com.cognizant.listaapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.cognizant.listaapp.R
import br.com.cognizant.listaapp.model.Bebida
import kotlinx.android.synthetic.main.lista_bebidas.view.*

class BebidasAdapter(val items: ArrayList<Bebida>, private val clickListener: (Bebida) -> Unit) :
    RecyclerView.Adapter<BebidasAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lista_bebidas, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(items[position], clickListener)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(bebida: Bebida, clickListener: (Bebida) -> Unit) {
            itemView.tv_lista_bebidas.text = bebida.nome
            itemView.iv_bebida.setImageResource(bebida.icone)
            itemView.setOnClickListener { clickListener(bebida) }
        }
    }
}