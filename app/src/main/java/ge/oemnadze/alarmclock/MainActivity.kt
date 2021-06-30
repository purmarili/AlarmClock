package ge.oemnadze.alarmclock

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.RecyclerView
import ge.oemnadze.alarmclock.adapters.AlarmsListAdapter
import ge.oemnadze.alarmclock.models.AlarmItem

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var switchMode: TextView
    private var alarmItemsList: ArrayList<AlarmItem> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        switchMode = findViewById(R.id.switchColors)
        switchMode.setOnClickListener {
            if (switchMode.text.toString() == "Switch to dark") {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        recyclerView = findViewById(R.id.alarms_recycler_view)

        alarmItemsList.add(AlarmItem("19:20", "on"))
        alarmItemsList.add(AlarmItem("20:15", "off"))

        recyclerView.adapter = AlarmsListAdapter(alarmItemsList)
    }
}