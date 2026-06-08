package br.com.annypereira.orbisapp.presentation.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Language
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.annypereira.orbisapp.data.local.PreferenciasManager
import br.com.annypereira.orbisapp.presentation.navigation.Navegacao
import br.com.annypereira.orbisapp.ui.theme.OrbisBlue
import br.com.annypereira.orbisapp.ui.theme.OrbisWhite
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController
) {

    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate(Navegacao.Onboarding.rota)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(OrbisBlue),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Box(
                modifier = Modifier
                    .size(80.dp)
                    .background(Color.White.copy(alpha = 0.15f), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Outlined.Language,
                    contentDescription = "ORBIS",
                    tint = OrbisWhite,
                    modifier = Modifier.size(40.dp)
                )
            }

            Spacer(Modifier.height(18.dp))

            Text(
                text = "ORBIS",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = OrbisWhite,
                letterSpacing = 2.sp
            )

            Spacer(Modifier.height(6.dp))

            Text(
                text = "MONITORAMENTO CLIMÁTICO",
                fontSize = 10.sp,
                fontWeight = FontWeight.Medium,
                color = OrbisWhite.copy(alpha = 0.65f),
                letterSpacing = 3.sp
            )
        }
    }
}
