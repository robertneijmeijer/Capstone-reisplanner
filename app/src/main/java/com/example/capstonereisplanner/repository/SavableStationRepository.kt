package com.example.capstonereisplanner.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.capstonereisplanner.dao.StationDao
import com.example.capstonereisplanner.database.StationListRoomDatabase
import com.example.capstonereisplanner.model.SavableStation

class SavableStationRepository(context: Context) {

    private val stationDao: StationDao

    init {
        val database = StationListRoomDatabase.getDatabaseInstance(context)
        stationDao = database!!.stationDao()
    }

    fun getStationList(): LiveData<List<SavableStation>>{
        return stationDao.getAllStations()
    }

    suspend fun insertStation(savableStation: SavableStation){
        stationDao.insertStation(savableStation)
    }

    suspend fun deleteAllStations(){
        stationDao.deleteAllStations()
    }


}