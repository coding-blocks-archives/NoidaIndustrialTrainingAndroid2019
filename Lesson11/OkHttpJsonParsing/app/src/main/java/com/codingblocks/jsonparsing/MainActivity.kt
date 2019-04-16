package com.codingblocks.jsonparsing

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private val baseUrl = "https://api.github.com"
    private val searchEndpoint = "/search/users"

    var name: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val httpClient = OkHttpClient.Builder()
            .build()

        btnSearch.setOnClickListener {

            //Get the Input from editText
            val name = etUsername.text.toString()

            //Create a request object
            val request = Request.Builder()
                .url("$baseUrl$searchEndpoint?q=$name")
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
                    val root = convertResultJsonToRoot(result)

                    val githubUserAdapter = GithubUserAdapter(root.items)

                    runOnUiThread {
                        rvUsers.layoutManager = LinearLayoutManager(baseContext)
                        rvUsers.adapter = githubUserAdapter
                    }
                }
            })
        }

    }

    fun convertResultJsonToRoot(result: String): Root {
        val resultJson = JSONObject(result)

        val totalCount = resultJson.getInt("total_count")
        val incompleteResults = resultJson.getBoolean("incomplete_results")
        val items = resultJson.getJSONArray("items")

        val itemList = arrayListOf<Item>()

        for (i in 0..(items.length() - 1)) {
            val currentItem = items.getJSONObject(i)
            val currentLogin = currentItem.getString("login")
            val currentId = currentItem.getInt("id")
            val currentNodeId = currentItem.getString("node_id")
            val currentAvatarUrl = currentItem.getString("avatar_url")
            val currentUrl = currentItem.getString("url")
            val currentHtmlUrl = currentItem.getString("html_url")

            val item = Item(
                currentId,
                currentLogin,
                currentNodeId,
                currentAvatarUrl,
                currentUrl,
                currentHtmlUrl
            )
            itemList.add(item)
        }

        return Root(totalCount, incompleteResults, itemList)
    }

}
