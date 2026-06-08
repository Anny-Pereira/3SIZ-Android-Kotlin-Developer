package br.com.annypereira.orbisapp.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.GpsFixed
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Search
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
import br.com.annypereira.orbisapp.presentation.navigation.Navegacao
import br.com.annypereira.orbisapp.presentation.viewmodel.BuscaViewModel
import br.com.annypereira.orbisapp.ui.theme.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaBusca(navController: NavController) {
    val viewModel: BuscaViewModel = viewModel()
    var cidade by remember { mutableStateOf("") }
    val cidades by viewModel.cidades.collectAsState()
    val erro by viewModel.erro.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

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
                        Text(
                            "Consultar localização",
                            fontSize = 11.sp,
                            color = Color.White.copy(alpha = 0.75f)
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { navController.navigate(Navegacao.Favoritos.rota) }) {
                        Icon(Icons.Default.Favorite, contentDescription = "Favoritos", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = OrbisBlue)
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .background(Color.White)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Spacer(Modifier.height(4.dp))

            Text(
                "Digite uma cidade",
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold,
                color = OrbisTextMuted
            )

            Spacer(Modifier.height(6.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.White)
                    .padding(0.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = cidade,
                    onValueChange = { cidade = it },
                    placeholder = { Text("Ex: Campinas", fontSize = 13.sp, color = OrbisTextMuted) },
                    leadingIcon = {
                        Icon(Icons.Outlined.LocationOn, contentDescription = null, tint = OrbisBlue, modifier = Modifier.size(18.dp))
                    },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(topStart = 10.dp, bottomStart = 10.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = OrbisBlue,
                        unfocusedBorderColor = OrbisGrayBorder,
                        focusedTextColor = OrbisBlueDark,
                    ),
                    singleLine = true
                )

                Button(
                    onClick = { viewModel.buscarCidade(cidade) },
                    modifier = Modifier.height(56.dp),
                    shape = RoundedCornerShape(topEnd = 10.dp, bottomEnd = 10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = OrbisBlue)
                ) {
                    Text("Buscar", fontWeight = FontWeight.Bold, fontSize = 12.sp)
                }
            }

            Spacer(Modifier.height(12.dp))

            if (cidades.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxWidth().padding(top = 32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            Icons.Outlined.Search,
                            contentDescription = null,
                            tint = OrbisGrayBorder,
                            modifier = Modifier.size(40.dp)
                        )
                        Spacer(Modifier.height(8.dp))
                        Text(
                            "Selecione uma cidade para ver os dados",
                            fontSize = 12.sp,
                            color = OrbisTextMuted
                        )
                    }
                }
            } else {
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    border = ButtonDefaults.outlinedButtonBorder,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    LazyColumn {
                        items(cidades) { item ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        navController.navigate(
                                            Navegacao.Inicio.criarRota(item.name, item.latitude, item.longitude)
                                        )
                                    }
                                    .background(Color.White)
                                    .padding(horizontal = 14.dp, vertical = 12.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                Icon(
                                    Icons.Outlined.LocationOn,
                                    contentDescription = null,
                                    tint = OrbisBlue,
                                    modifier = Modifier.size(16.dp)
                                )
                                Column {
                                    Text(item.name, fontSize = 13.sp, fontWeight = FontWeight.SemiBold, color = OrbisBlueDark)
                                    Text(
                                        "%.2f, %.2f".format(item.latitude, item.longitude),
                                        fontSize = 11.sp,
                                        color = OrbisTextMuted
                                    )
                                }
                            }
                            HorizontalDivider(color = OrbisGrayBorder, thickness = 0.5.dp)
                        }
                    }
                }
            }

            erro?.let {
                scope.launch { snackbarHostState.showSnackbar(it) }
            }
        }
    }
}
