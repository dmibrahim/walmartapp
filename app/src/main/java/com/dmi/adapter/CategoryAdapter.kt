package com.dmi.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.dmi.activity.R
import com.dmi.domain.Product

class CategoryAdapter(val context: Context, val products: MutableList<Product>) :
    RecyclerView.Adapter<BaseViewHolder?>() {

    private var callBack: Callback? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): BaseViewHolder {
        val itemEvents: View = LayoutInflater.from(viewGroup.context)
            .inflate(
                R.layout.item_category, viewGroup, false)
        return AssignedTasksViewHolder(itemEvents)
    }

    override fun onBindViewHolder(baseViewHolder: BaseViewHolder, i: Int) {
        baseViewHolder.onBind(i)
    }
    
    fun setCallback(callback: Callback?) {
        callBack = callback
    }

    override fun getItemCount(): Int = products.size

    interface Callback {
        fun onItemClicked(product: Product?)
    }

    inner class AssignedTasksViewHolder(view: View?) : BaseViewHolder(view) {
        var productTitle: TextView? = view?.findViewById(R.id.rv_title)
        var productImage: ImageView? = view?.findViewById(R.id.rv_image)
        var price: TextView? = view?.findViewById(R.id.rv_price)
        var color: TextView? = view?.findViewById(R.id.rv_color)
        var container: LinearLayout? = view?.findViewById(R.id.item_container)
        @SuppressLint("NotifyDataSetChanged")
        override fun onBind(position: Int) {
            super.onBind(position)
            val product = products[position]
            
            productImage?.setBackgroundResource(product.productImage)
            productTitle?.text = product.productTitle
            price?.text = product.price
            color?.text = product.productColor

            container?.setOnClickListener {
                callBack?.onItemClicked(product)
                notifyDataSetChanged()
            }
        }
    }
}