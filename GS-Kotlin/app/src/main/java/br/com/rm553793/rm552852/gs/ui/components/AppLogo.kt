package br.com.rm553793.rm552852.gs.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rm553793.rm552852.gs.R
import fontXXLarge


@Composable
fun AppLogo() {
    Row(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.app_logo_balance),
            contentDescription = "imageLogo",
            modifier = Modifier.height(50.dp)
        )
        Spacer(modifier = Modifier.width(30.dp))
        Text(
            text = stringResource(R.string.app_name),
            style = TextStyle(
                fontSize = fontXXLarge,
                fontWeight = FontWeight.Bold
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AppLogoPreview(modifier: Modifier = Modifier) {
    AppLogo()
}