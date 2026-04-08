package br.com.annypereira.apptask

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
import br.com.annypereira.apptask.features.task.data.local.db.AppDatabase
import br.com.annypereira.apptask.features.task.data.local.repository.TaskRepository
import br.com.annypereira.apptask.features.task.ui.screen.TaskScreen
import br.com.annypereira.apptask.features.task.ui.screen.TaskViewModel
import br.com.annypereira.apptask.ui.theme.TaskAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "task_db"
        ).build()
        val repository = TaskRepository(db.taskDao())
        val viewModel = TaskViewModel(repository)
        setContent {
            TaskAppTheme {
                TaskScreen(viewModel)
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
    TaskAppTheme {
        Greeting("Android")
    }
}