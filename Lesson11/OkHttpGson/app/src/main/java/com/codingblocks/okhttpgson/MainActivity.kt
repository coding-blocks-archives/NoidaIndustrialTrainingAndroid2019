package com.codingblocks.okhttpgson

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private val baseUrl = "https://pokeapi.co/api/v2"
    private val searchEndpoint = "/pokemon/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val httpClient = OkHttpClient.Builder()
            .build()

        btnSearch.setOnClickListener {

            //Get the Input from editText
            val name = etPokeRank.text.toString()

            //Create a request object
            val request = Request.Builder()
                .url("$baseUrl$searchEndpoint$name")
                .build()

            //Make the network call
            httpClient.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    e.printStackTrace()
                }

                override fun onResponse(call: Call, response: Response) {

                    val responseBody = response.body()
                    //If you use !! then you might get null pointers
                    val result = responseBody!!.string()
                    val gson = Gson()

                    //::class keyword takes the compiled name of the class
                    val root = gson.fromJson(result, Root::class.java)

                    runOnUiThread {

                        //Using GSON, you can send complex java objects across activities easily
//                        val intent = Intent(baseContext,MainActivity::class.java)
//                        val stringifiedRoot = gson.toJson(root)
//                        intent.putExtra("KEY",stringifiedRoot)

                        tvPokemonName.text = root.name
                        tvPokemonWeight.text = root.weight.toString()
                        tvPokemonRank.text = root.id.toString()
                        Picasso.get()
                            .load(root.sprites.front_default)
                            .into(ivPokemon)
                    }
                }
            })
        }

    }

}
