package com.example.newsletter.data.service

import com.example.newsletter.models.Librarie

class DummyLibrariesService :
    LibrariesApiService {
    override val libraries: List<Librarie>
        get() = Dummy_libraries
    private val Dummy_libraries: MutableList<Librarie> = mutableListOf(
            Librarie(1,"com.squareup.retrofit2:retrofit:2.6.0", "Pour consommer les web services RestFul"),
            Librarie(2,"com.squareup.okhttp3:okhttp:4.2.1", "Effectuer les requêtes HTTP (utilisée par Retrofit)"),
            Librarie(3,"com.google.code.gson:gson:2.8.5", "Gson est une bibliothèque Java qui peut être utilisée pour convertir des objets Java en leur représentation JSON. Il peut également être utilisé pour convertir une chaîne JSON en un objet Java équivalent. Gson peut travailler avec des objets Java arbitraires, y compris des objets préexistants dont vous n'avez pas de code source."),
            Librarie(4,"com.squareup.retrofit2:converter-gson:2.4.0", "Utilisé par Retrofit pour convertir les objets JSON en POJO"),
            Librarie(5,"com.squareup.okhttp3:logging-interceptor:4.2.1", " Permet d'arricher les logs des requêtes"),
            Librarie(6,"org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.7", " Pour faire du multithreading"),
            Librarie(7,"org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.7", " Pour faire du multithreading")

    )
}