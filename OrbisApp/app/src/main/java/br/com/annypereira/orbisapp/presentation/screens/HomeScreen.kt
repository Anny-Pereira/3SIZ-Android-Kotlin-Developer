package br.com.annypereira.orbisapp.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import br.com.annypereira.orbisapp.data.repository.FavoritosRepository
import br.com.annypereira.orbisapp.domain.model.Favorito
import br.com.annypereira.orbisapp.presentation.navigation.Navegacao
import br.com.annypereira.orbisapp.presentation.viewmodel.InicioViewModel
import br.com.annypereira.orbisapp.ui.theme.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    cidade: String,
    latitude: Double,
    longitude: Double,
    navController: NavController
) {
    val viewModel: InicioViewModel = viewModel()
    val temperatura by viewModel.temperatura.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    val isHot = (temperatura ?: 0.0) >= 35.0
    val isWarm = (temperatura ?: 0.0) >= 30.0

    val alertLabel = when {
        isHot -> "Alerta de calor"
        isWarm -> "Calor moderado"
        else -> "Temperatura normal"
    }

    val recomendacao = when {
        isHot -> "Evite exposição solar entre 10h e 16h. Hidrate-se com frequência e use protetor solar."
        isWarm -> "Hidrate-se frequentemente e use protetor solar ao sair."
        else -> "Condições normais. Aproveite o dia com segurança."
    }

    LaunchedEffect(Unit) {
        viewModel.buscarTemperatura(latitude, longitude)
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            "ORBIS",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = Color.White
                        )
                        Text(cidade, fontSize = 11.sp, color = Color.White.copy(alpha = 0.75f))
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
            // Temperature card
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                color = OrbisGray,
                border = ButtonDefaults.outlinedButtonBorder.copy(
                    brush = androidx.compose.ui.graphics.SolidColor(OrbisGrayBorder)
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "Temperatura do solo agora",
                        fontSize = 11.sp,
                        color = OrbisTextMuted
                    )
                    Spacer(Modifier.height(6.dp))

                    if (temperatura == null) {
                        CircularProgressIndicator(
                            color = OrbisBlue,
                            modifier = Modifier.size(40.dp)
                        )
                    } else {
                        Text(
                            text = "${temperatura?.toInt()}°",
                            fontSize = 56.sp,
                            fontWeight = FontWeight.Bold,
                            color = OrbisRed,
                            lineHeight = 56.sp
                        )
                        Text("Celsius · Open-Meteo", fontSize = 11.sp, color = OrbisTextMuted)
                        Spacer(Modifier.height(8.dp))
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(20.dp))
                                .background(if (isHot) OrbisRedLight else OrbisBlueLight)
                                .padding(horizontal = 14.dp, vertical = 4.dp)
                        ) {
                            Text(
                                alertLabel,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = if (isHot) OrbisRedDark else OrbisBlue
                            )
                        }
                    }
                }
            }

            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                color = OrbisBlueLight
            ) {
                Row(
                    modifier = Modifier.padding(12.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        Icons.Outlined.Warning,
                        contentDescription = null,
                        tint = OrbisBlue,
                        modifier = Modifier
                            .size(18.dp)
                            .padding(top = 1.dp)
                    )
                    Column {
                        Text(
                            "Recomendação",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = OrbisBlue
                        )
                        Spacer(Modifier.height(3.dp))
                        Text(recomendacao, fontSize = 12.sp, color = OrbisBlue, lineHeight = 18.sp)
                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Surface(
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(10.dp),
                    color = OrbisGray,
                    border = ButtonDefaults.outlinedButtonBorder.copy(
                        brush = androidx.compose.ui.graphics.SolidColor(OrbisGrayBorder)
                    )
                ) {
                    Column(Modifier.padding(12.dp)) {
                        Text("Umidade", fontSize = 10.sp, color = OrbisTextMuted)
                        Spacer(Modifier.height(2.dp))
                        Text(
                            "45%",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = OrbisBlueDark
                        )
                    }
                }
                Surface(
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(10.dp),
                    color = OrbisGray,
                    border = ButtonDefaults.outlinedButtonBorder.copy(
                        brush = androidx.compose.ui.graphics.SolidColor(OrbisGrayBorder)
                    )
                ) {
                    Column(Modifier.padding(12.dp)) {
                        Text("Atualizado", fontSize = 10.sp, color = OrbisTextMuted)
                        Spacer(Modifier.height(2.dp))
                        Text(
                            "agora",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = OrbisBlueDark
                        )
                    }
                }
            }

            Button(
                onClick = {
                    FavoritosRepository.adicionarFavorito(
                        Favorito(
                            cidade = cidade,
                            latitude = latitude,
                            longitude = longitude,
                            temperatura = temperatura
                        )
                    )
                    scope.launch { snackbarHostState.showSnackbar("⭐ Cidade adicionada aos favoritos") }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(46.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = OrbisBlue)
            ) {
                Text("Favoritar Cidade", fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
            }

            OutlinedButton(
                onClick = {
                    navController.navigate(Navegacao.Detalhe.rota)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(46.dp),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(2.dp, OrbisBlue),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = OrbisBlue
                )
            ) {
                Text("Ver detalhes", fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
            }
        }
    }
}
