package com.example.may7_task

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.may7_task.Adapter.DashboardAdapter

class Adapter {
    class DashboardAdapter(items: List<DashboardItem>) {

    }

}

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding
    private lateinit var adapter: DashboardAdapter // Assuming DashboardAdapter is defined in RecyclerView.kt

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Dummy data for RecyclerView, replace with your actual data source
        val items = listOf(
            DashboardItem("Item 1"),
            DashboardItem("Item 2"),
            DashboardItem("Item 3")
        )

        adapter = DashboardAdapter(items)

        binding.recyclerView.apply {
            var layoutManager = LinearLayoutManager(this@DashboardActivity)
            adapter = this@DashboardActivity.adapter
        }
    }

    private fun setContentView(root: Any) {
        TODO("Not yet implemented")
    }
}

