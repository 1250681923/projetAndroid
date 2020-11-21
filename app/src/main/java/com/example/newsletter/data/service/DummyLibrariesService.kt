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
            Librarie(7,"org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.7", " Pour faire du multithreading"),
            Librarie(8,"androidx.room:room-runtime:2.2.5", "La bibliothèque de persistance de pièce fournit une couche d'abstraction basée sur SQLite, permettant aux utilisateurs d'utiliser pleinement les puissantes fonctions de SQLite tout en bénéficiant d'un mécanisme d'accès à la base de données plus robuste"),
            Librarie(9,"com.github.bumptech.glide:glide:4.11.0", "Glide est un cadre de gestion des médias et de chargement d'images open source rapide et efficace pour Android qui englobe le décodage des médias, la mise en cache de la mémoire et du disque et la mise en commun des ressources dans une interface simple et facile à utiliser."),
            Librarie(10,"androidx.core:core-ktx:1.3.2", "Le module Core KTX fournit des extensions pour les bibliothèques courantes qui font partie du framework Android."),
            Librarie(11,"androidx.appcompat:appcompat:1.2.0", "Permet d'accéder à de nouvelles API sur les anciennes versions d'API de la plate-forme (beaucoup utilisant la conception de matériaux)"),
            Librarie(12,"com.google.android.material:material:1.2.1", "Ces composants permettent un flux de travail de développement fiable pour créer des applications Android belles et fonctionnelles."),
            Librarie(13,"androidx.constraintlayout:constraintlayout:2.0.4", "Un ConstraintLayout est un android.view.ViewGroup qui vous permet de positionner et de dimensionner les widgets de manière flexible.")

    )
}