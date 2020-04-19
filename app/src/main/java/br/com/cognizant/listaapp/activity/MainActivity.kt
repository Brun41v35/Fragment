package br.com.cognizant.listaapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.cognizant.listaapp.R
import br.com.cognizant.listaapp.adapter.BebidasAdapter
import br.com.cognizant.listaapp.fragment.ListaBebidasFragment
import br.com.cognizant.listaapp.model.Bebida
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var bebidasStr = arrayOf("Café", "Leite", "Chocolate", "Café com leite")
    var bebidasImg = arrayOf(R.drawable.cafe, R.drawable.leite, R.drawable.chocolate, R.drawable.cafe)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragmentBebidas(carregaModeloBebidas(bebidasImg, bebidasStr))
    }

    fun addFragmentBebidas(bebidas: ArrayList<Bebida>){
        var fragBebidas = ListaBebidasFragment.newInstance(bebidas)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.ll_fragment_container, fragBebidas)
        transaction.commit()
    }

    fun carregaModeloBebidas(imagens: Array<Int>, nomes: Array<String>): ArrayList<Bebida>{
        var bebidas: ArrayList<Bebida> = ArrayList<Bebida>()
        for (i in imagens.indices) {
            val bebida = Bebida(imagens[i], nomes[i])
            bebidas.add(bebida)
        }
        return bebidas;
    }
}
