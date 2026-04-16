package br.com.rm553793.cp_04_room

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import br.com.rm553793.cp_04_room.features.movie.data.local.db.AppDatabase
import br.com.rm553793.cp_04_room.features.movie.data.local.repository.MovieRepository
import br.com.rm553793.cp_04_room.features.movie.ui.screens.MovieScreen
import br.com.rm553793.cp_04_room.features.movie.ui.screens.MovieViewModel
import br.com.rm553793.cp_04_room.ui.theme.CP04RoomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "movie_db"
        ).build()
        val repository = MovieRepository(db.movieDao())
        val viewModel = MovieViewModel(repository)
        setContent {
            CP04RoomTheme {
                MovieScreen(viewModel)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CP04RoomTheme {
        Greeting("Android")
    }
}