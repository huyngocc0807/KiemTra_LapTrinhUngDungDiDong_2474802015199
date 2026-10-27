package com.vanlang.kiemtra_laptrinhungdungdidong_2474802015199

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    private lateinit var tvProfileTitle: TextView
    private lateinit var tvUserEmail: TextView
    private lateinit var btnLogout: Button
    private lateinit var listViewSubjects: ListView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        tvProfileTitle = findViewById(R.id.tvProfileTitle)
        tvUserEmail = findViewById(R.id.tvUserEmail)
        btnLogout = findViewById(R.id.btnLogout)
        listViewSubjects = findViewById(R.id.listViewSubjects)

        // Nhận dữ liệu Intent
        intent.getStringExtra("USER_EMAIL")?.let { email ->
            tvUserEmail.text = "Email người dùng: $email"
        }

        // Xử lý nút Đăng xuất
        btnLogout.setOnClickListener {
            finish()
        }

        // Dữ liệu mảng môn học (Câu 3)
        val subjectsList = arrayOf(
            "Lập trình Kotlin",
            "Thiết kế Layout XML",
            "Quản lý Git/GitHub",
            "Xử lý Intent",
            "Kiến trúc Android",
        )

        // Gắn ArrayAdapter
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, subjectsList)
        listViewSubjects.adapter = adapter

        // Bắt sự kiện click Toast
        listViewSubjects.setOnItemClickListener { _, _, position, _ ->
            val selectedSubject = subjectsList[position]
            Toast.makeText(this, "Đã chọn: $selectedSubject", Toast.LENGTH_SHORT).show()
        }
    }
}
