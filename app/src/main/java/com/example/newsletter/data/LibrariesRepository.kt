package com.example.newsletter.data

import com.example.newsletter.data.service.LibrariesApiService
import com.example.newsletter.data.service.DummyLibrariesService
import com.example.newsletter.models.Librarie

class LibrariesRepository {
    private val apiService: LibrariesApiService

    init {
        apiService = DummyLibrariesService()
    }

    fun getNeighbours(): List<Librarie> = apiService.libraries

    companion object {
        private var instance: LibrariesRepository? = null
        fun getInstance(): LibrariesRepository{
            if (instance == null) {
                instance = LibrariesRepository()
            }
            return instance!!
        }
    }
}
