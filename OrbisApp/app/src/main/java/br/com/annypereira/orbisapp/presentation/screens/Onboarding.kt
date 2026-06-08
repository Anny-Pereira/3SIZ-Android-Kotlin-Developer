package br.com.annypereira.orbisapp.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DeviceThermostat
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.annypereira.orbisapp.data.local.PreferenciasManager
import br.com.annypereira.orbisapp.presentation.navigation.Navegacao
import br.com.annypereira.orbisapp.ui.theme.*


@Composable
fun Onboarding(
    navController: NavController, preferenciasManager: PreferenciasManager
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(210.dp)
                .background(OrbisBlueLight),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(96.dp)
                    .background(OrbisBlue.copy(alpha = 0.12f), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Outlined.DeviceThermostat,
                    contentDescription = null,
                    tint = OrbisBlue,
                    modifier = Modifier.size(52.dp)
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
            Spacer(Modifier.height(4.dp))

            Text(
                text = "Ilhas de calor urbanas",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = OrbisBlue
            )

            Spacer(Modifier.height(10.dp))

            Text(
                text = "Acompanhe a temperatura do solo em tempo real e receba orientações para se proteger do calor intenso na sua cidade.",
                fontSize = 14.sp,
                color = OrbisTextSub,
                lineHeight = 21.sp
            )

            Spacer(Modifier.height(20.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                Button(
                    onClick = {
                        preferenciasManager.salvarOnboardingConcluido()
                        navController.navigate(Navegacao.Busca.rota) {
                            popUpTo(Navegacao.Onboarding.rota) { inclusive = true }
                        }
                    },
                    modifier = Modifier
                        .weight(1f)
                        .height(44.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = OrbisBlue)
                ) {
                    Text("Avançar", fontWeight = FontWeight.SemiBold)
                }
            }
        }
    }
}
