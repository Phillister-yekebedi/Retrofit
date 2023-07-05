package com.example.myshop.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myshop.models.Product
import com.example.myshop.databinding.ProductListBinding
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class ProductsRvAdapter(var products: List<Product>) :RecyclerView.Adapter<ProductsRvAdapter.ProductViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductViewHolder {
        val binding=ProductListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val currentProducts=products.get(position)
        val binding=holder.binding
        binding.tvId.text=currentProducts.id.toString()
        binding.tvBrand.text=currentProducts.brand
        binding.tvTitle.text=currentProducts.title
        binding.tvPrice.text=currentProducts.price.toString()
        binding.tvPrice.text=currentProducts.price.toString()
        binding.tvStock.text=currentProducts.stock.toString()
        binding.tvDes.text=currentProducts.description
        binding.tvThumbnail.text=currentProducts.thumbnail


        Picasso
            .get().load(currentProducts.thumbnail)
            .resize(80, 80)
            .centerInside()
            .transform(CropCircleTransformation())
            .into(binding.ivImage)


    }
    override fun getItemCount(): Int {
        return products.size

    }
    class ProductViewHolder(var  binding: ProductListBinding):RecyclerView.ViewHolder(binding.root)

}