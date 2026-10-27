package com.vanlang.kiemtra_laptrinhungdungdidong_2474802015199

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class LoginActivity : AppCompatActivity() {
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvStatus: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Ánh xạ View bằng findViewById truyền thống (BẮT BUỘC)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvStatus = findViewById(R.id.tvStatus)

        btnLogin.setOnClickListener {
            val emailStr = etEmail.text.toString().trim()
            val passStr = etPassword.text.toString().trim()

            // Kiểm tra bỏ trống
            if (emailStr.isEmpty() || passStr.isEmpty()) {
                tvStatus.text = "Lỗi: Không được để trống Email hoặc Mật khẩu!"
                tvStatus.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark))
                return@setOnClickListener
            }

            // Kiểm tra định dạng Email chuẩn
            if (!Patterns.EMAIL_ADDRESS.matcher(emailStr).matches()) {
                tvStatus.text = "Lỗi: Email không đúng định dạng!"
                tvStatus.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark))
                return@setOnClickListener
            }

            // Kiểm tra độ dài mật khẩu
            if (passStr.length < 6) {
                tvStatus.text = "Lỗi: Mật khẩu phải có ít nhất 6 ký tự!"
                tvStatus.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark))
                return@setOnClickListener
            }

            // Dữ liệu hoàn toàn hợp lệ -> Chuyển màn hình
            tvStatus.text = "Xác thực thành công!"
            tvStatus.setTextColor(ContextCompat.getColor(this, android.R.color.holo_green_dark))

            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("USER_EMAIL", emailStr)
            startActivity(intent)
        }
    }
}
