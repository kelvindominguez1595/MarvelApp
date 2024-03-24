package com.example.marvelapp.dataStore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoreLoading (private val context: Context){
    companion object{
        private val Context.dataStore : DataStore<Preferences> by preferencesDataStore("storeLoading")
        val STORE_LOADING = booleanPreferencesKey("store_loading")
    }

    val getLoading: Flow<Boolean> = context.dataStore.data
        .map {
            preference -> preference[STORE_LOADING] ?: false
        }

    suspend fun saveBoarding(value: Boolean){
        context.dataStore.edit {
            preference -> preference[STORE_LOADING] = value
        }
    }
}