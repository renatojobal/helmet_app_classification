/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.mlkit.md.productsearch

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.google.mlkit.md.R
import com.google.mlkit.md.productsearch.ProductAdapter.ProductViewHolder
import timber.log.Timber

/** Presents the list of product items from cloud product search.  */
class ProductAdapter(private val productList: List<Product>) : Adapter<ProductViewHolder>() {

    class ProductViewHolder private constructor(view: View) : RecyclerView.ViewHolder(view) {

        private val imageView: ImageView = view.findViewById(R.id.product_image)
        private val titleView: TextView = view.findViewById(R.id.product_title)
        private val subtitleView: TextView = view.findViewById(R.id.product_subtitle)
        private val imageSize: Int = view.resources.getDimensionPixelOffset(R.dimen.product_item_image_size)

        fun bindProduct(product: Product) {
            Timber.d("Product: $product")
            imageView.setImageDrawable(null)

            if(product.title.contains("helmet")){ // HELMET MODEL
                if(product.title == "with_helmet"){
                    imageView.setImageResource(getImageForHelmetModel(HelmetResult.WITH_HELMET))
                }else {
                    imageView.setImageResource(getImageForHelmetModel(HelmetResult.WITHOUT_HELMET))
                }

            }else{
                if (!TextUtils.isEmpty(product.imageUrl)) {
                    ImageDownloadTask(imageView, imageSize).execute(product.imageUrl)
                } else {
                    imageView.setImageResource(R.drawable.logo_google_cloud)
                }

            }


            titleView.text = product.title
            subtitleView.text = product.subtitle
        }

        companion object {
            fun create(parent: ViewGroup) =
                ProductViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false))
        }

        fun getImageForHelmetModel(result : HelmetResult) : Int {
            return when (result) {
                HelmetResult.WITH_HELMET -> R.drawable.ic_check
                HelmetResult.WITHOUT_HELMET -> R.drawable.ic_baseline_error_24
                else -> R.drawable.logo_google_cloud
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder =
        ProductViewHolder.create(parent)

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bindProduct(productList[position])
    }

    override fun getItemCount(): Int = productList.size

    enum class HelmetResult(val result: String) {
        WITH_HELMET("with_helmet"),
        WITHOUT_HELMET("without_helmet")
    }


}
