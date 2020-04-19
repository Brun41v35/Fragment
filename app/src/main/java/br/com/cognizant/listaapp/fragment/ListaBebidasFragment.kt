package br.com.cognizant.listaapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import br.com.cognizant.listaapp.R
import br.com.cognizant.listaapp.adapter.BebidasAdapter
import br.com.cognizant.listaapp.model.Bebida
import kotlinx.android.synthetic.main.fragment_lista_bebidas.*

private const val ARG_PARAM_BEBIDAS = "bebidas"

class ListaBebidasFragment : Fragment() {

    private lateinit var bebidas: ArrayList<Bebida>
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            bebidas = it.getSerializable(ARG_PARAM_BEBIDAS) as ArrayList<Bebida>
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_bebidas, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        criarListaBebidas(bebidas)
    }

    fun criarListaBebidas(bebidas: ArrayList<Bebida>){
        viewManager = LinearLayoutManager(activity)
        viewAdapter = BebidasAdapter(bebidas) { bebida -> bebidasItemClicked(bebida)}

        rv_lista_bebidas.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter

        }
        rv_lista_bebidas.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
    }

    private fun bebidasItemClicked(bebida: Bebida) {
        Toast.makeText(activity, "Escolhi: ${bebida.nome}", Toast.LENGTH_SHORT).show()
    }

    companion object {
        @JvmStatic
        fun newInstance(bebidas: ArrayList<Bebida>) =
            ListaBebidasFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM_BEBIDAS, bebidas)
                }
            }
    }
}
