package com.example.myshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        fetchProducts()
    }
    fun fetchProducts(){
        var apiClient =ApiClient.buildClient(ApiInterface::class.java)
        var request =apiClient.getProducts()
        request.enqueue(object :Callback<ProductsResponse>{
            override fun onResponse(call: Call<ProductsResponse>, response: Response<ProductsResponse>) {
                if(response.isSuccessful){
                    var products =response.body()?.products
                    Toast.makeText(baseContext,"fetched ${products?.size}products",Toast.LENGTH_LONG).show()
                }
                else{
                    var error =response.errorBody()?.string()
                    Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<ProductsResponse>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }
        })
    }


}






