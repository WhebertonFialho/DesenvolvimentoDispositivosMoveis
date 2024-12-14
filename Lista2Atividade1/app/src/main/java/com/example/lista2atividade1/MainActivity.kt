package com.example.lista2atividade1

import android.app.ListActivity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView


class MainActivity : ListActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val actions = arrayOf(
            getString(R.string.action_settings),
            getString(R.string.action_sms),
            getString(R.string.action_dial),
            getString(R.string.action_map)
        )

        listAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, actions)
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)

        var intent: Intent? = null

        when (position) {
            0 -> intent = Intent(Settings.ACTION_SETTINGS)
            1 -> {
                intent = Intent(Intent.ACTION_VIEW)
                intent.setData(Uri.parse("sms:66996817136"))
                intent.putExtra("sms_body", "Esta é uma mensagem automatica")
            }

            2 -> {
                intent = Intent(Intent.ACTION_DIAL)
                intent.setData(Uri.parse("tel:1234567890")) //
            }

            3 -> {
                val geoUri = "geo:-16.4677,-54.6372"
                intent = Intent(Intent.ACTION_VIEW, Uri.parse(geoUri))
            }
        }

        if (intent != null) {
            startActivity(intent)
        }
    }
}