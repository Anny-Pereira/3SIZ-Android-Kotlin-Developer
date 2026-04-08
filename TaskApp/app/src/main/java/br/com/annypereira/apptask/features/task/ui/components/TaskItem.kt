package br.com.annypereira.apptask.features.task.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import br.com.annypereira.apptask.features.task.data.local.entity.Task

@Composable
fun TaskItem(task: Task, onDelete: () -> Unit) {
    Row(modifier = Modifier.fillMaxWidth()
        .clip(RoundedCornerShape(12.dp))
        .border(width = 1.dp,
            color = MaterialTheme.colorScheme.outline,
            shape = RoundedCornerShape(12.dp)
        )
        .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = task.title,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f))
        IconButton(onClick = onDelete) {
            Icon(imageVector = Icons.Default.Delete,
                contentDescription = "Excluir",
                tint = MaterialTheme.colorScheme.error
            )
        }
    }
}