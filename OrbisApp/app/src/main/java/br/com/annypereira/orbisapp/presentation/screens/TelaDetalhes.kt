package br.com.annypereira.orbisapp.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.annypereira.orbisapp.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaDetalhes(
    navController: NavController
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            "Detalhes",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = Color.White
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = OrbisBlue)
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(Color.White)
                .verticalScroll(rememberScrollState())
                .padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                color = OrbisBlueLight
            ) {
                Column(Modifier.padding(14.dp)) {
                    Text(
                        "Orientações",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = OrbisBlue
                    )
                    Spacer(Modifier.height(6.dp))
                    val tips = listOf(
                        "Beba água regularmente",
                        "Evite atividades físicas ao ar livre",
                        "Procure ambientes frescos",
                        "Atenção a idosos e crianças"
                    )
                    tips.forEach { tip ->
                        Text("• $tip", fontSize = 12.sp, color = OrbisBlue, lineHeight = 20.sp)
                    }
                }
            }
        }
    }
}

