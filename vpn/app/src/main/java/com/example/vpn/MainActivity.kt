package com.example.vpn

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Button


class MainActivity : AppCompatActivity() {

    private var isVpnRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vpnButton: Button = findViewById(R.id.vpnButton)
        vpnButton.setOnClickListener {
            if (isVpnRunning) {
                stopVpn()
            } else {
                startVpn()
            }
            isVpnRunning = !isVpnRunning
            vpnButton.text = if (isVpnRunning) "Stop VPN" else "Start VPN"
        }
    }

    private fun startVpn() {
        val intent = Intent(this, MyVpnService::class.java).apply {
            action = MyVpnService.ACTION_START_VPN
        }
        startService(intent)
    }

    private fun stopVpn() {
        val intent = Intent(this, MyVpnService::class.java).apply {
            action = MyVpnService.ACTION_STOP_VPN
        }
        startService(intent)
    }
}
