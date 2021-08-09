package com.example.contatos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contato.Contact

class ContactAdapter(var listener: ClickItemContactListener) :
    RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>(){

    private  val  list: MutableList<Contact> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent,false)
        return ContactAdapterViewHolder(view, list, listener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ContactAdapterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    //Função criada para atualizar a lista de contatos
    fun  updateList(list: List<Contact>){
        this.list.clear() // Aqui ele limpa a lista
        this.list.addAll(list) // depois adiciona os contatos
        notifyDataSetChanged() // esse metodo avisa que a lista foi alterada e que precisa montar ela novamente
    }

    class ContactAdapterViewHolder(itenView: View, var list: List<Contact>, var listener: ClickItemContactListener) :
        RecyclerView.ViewHolder(itenView){
        private val  nome: TextView = itemView.findViewById(R.id.nome)
        private val  telefone: TextView = itemView.findViewById(R.id.telefone)
        private val  foto: ImageView = itemView.findViewById(R.id.foto)

        init {
            itemView.setOnClickListener{
                listener.clickItemContact(list[adapterPosition])
            }
        }

        fun bind(contact: Contact){
            nome.text = contact.name
            telefone.text = contact.phone
        }
    }

}