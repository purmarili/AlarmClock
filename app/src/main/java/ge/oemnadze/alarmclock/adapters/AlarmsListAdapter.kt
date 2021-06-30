package ge.oemnadze.alarmclock.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ge.oemnadze.alarmclock.R
import ge.oemnadze.alarmclock.models.AlarmItem

class AlarmsListAdapter(var list: ArrayList<AlarmItem>):
    RecyclerView.Adapter<AlarmsListAdapter.AlarmItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.alarm_item, parent, false)
        return AlarmItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlarmItemViewHolder, position: Int) {
        holder.setInfo(list[position].time, list[position].checked)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class AlarmItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private var alarmTime: TextView = itemView.findViewById(R.id.alarmTimer)
        @SuppressLint("UseSwitchCompatOrMaterialCode")
        private var alarmActive: Switch = itemView.findViewById(R.id.toggleAlarmOnOff)

        fun setInfo(alarmTime: String, alarmActive: String){
            this.alarmTime.text = alarmTime
            this.alarmActive.isChecked = alarmActive == "on"
        }

    }
}