package com.example.bai3122

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users

    init {
        loadUsers()
    }

    private fun loadUsers() {
        viewModelScope.launch {
            try {
                val userList = ApiClient.apiService.getUsers()
                _users.value = userList
                Log.d("UserViewModel", "Users loaded: $userList") // Logging
            } catch (e: Exception) {
                Log.e("UserViewModel", "Error loading users: ${e.message}") // Logging lỗi
            }
        }
    }

}