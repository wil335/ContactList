package com.devspace.recyclerview

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvlist = findViewById<RecyclerView>(R.id.rv_list)
        val ivlist = findViewById<ImageView>(R.id.iv_list)
        val ivgrid = findViewById<ImageView>(R.id.iv_grid)
        val adapter= contactListAdapter()
        rvlist.adapter = adapter
        rvlist.layoutManager= LinearLayoutManager(this)
        adapter.submitList(contacts)

        ivgrid.setOnClickListener {
            rvlist.layoutManager = GridLayoutManager(this, 2)
        }

        ivlist.setOnClickListener {
            rvlist.layoutManager= LinearLayoutManager(this)
        }
    }
} 


private val contacts = listOf(
    Contact( name = "Willian",
        phone = "(62) 99854-8019",
        R.drawable.sample12
    ),
    Contact( name = "Jhennyfer",
        phone = "(62) 99528-4587",
        R.drawable.sample3
    ),
    Contact( name = "Michel",
        phone = "(62) 99589-5463",
        R.drawable.sample8
    ),
    Contact( name = "Eliel",
        phone = "(62) 99254-5478",
        R.drawable.sample2
    ),
    Contact( name = "Mirian",
        phone = "(62) 99325-6321",
        R.drawable.sample11
    ),
    Contact( name = "Ester",
        phone = "(62) 99456-8523",
        R.drawable.sample13
    ),
    Contact( name = "Ulysses",
        phone = "(62) 99125-7856",
        R.drawable.sample9
    ),
)