package com.example.minimartapp.ui.widgets

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.minimartapp.R
import com.example.minimartapp.ui.theme.DpSizes.dp4
import com.example.minimartapp.ui.theme.DpSizes.dp8
import com.example.minimartapp.ui.theme.Styles.PrimaryButtonStyle
import com.example.minimartapp.ui.theme.Styles.SecondaryButtonStyle
import com.example.minimartapp.ui.theme.Styles.textStyleRobotoMediumSp12
import com.example.minimartapp.ui.theme.Styles.textStyleRobotoMediumsp16


sealed class TypesButtons {
    data object Primary : TypesButtons()
    data object Secondary : TypesButtons()
}


@Composable
fun TopBarComposeView(
    titulo: String, onClickBack: (() -> Unit)? = null //para y a su vez una funcion
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                dp8
            ), verticalAlignment = Alignment.CenterVertically
    ) {

        if (onClickBack != null) {
            IconButton(onClick = {
                onClickBack.invoke()
            }) {
                Image(painter = painterResource(R.drawable.ic_back), null)
            }
        }
        Spacer(modifier = Modifier.width(dp4))
        Image(
            painter = painterResource(R.drawable.ic_logo),
            null,
            modifier = Modifier
                .size(24.dp)
                .clip(
                    RoundedCornerShape(
                        80.dp
                    )
                )
        )
        Spacer(modifier = Modifier.width(dp8))
        Text(titulo, style = textStyleRobotoMediumSp12)
    }
}


@Composable
fun InputTextFieldComposeView(
    label: String,
    placeholder: String,
    isPassword: Boolean = false,
    value: String,
    onValueChange: (String) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(label, style = textStyleRobotoMediumsp16)
        Spacer(modifier = Modifier.height(8.dp))

        var passwordVisible by rememberSaveable { mutableStateOf(false) }

        TextField(
            value = value,
            onValueChange = { onValueChange(it) },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(placeholder) },
            visualTransformation = when {
                !isPassword -> VisualTransformation.None
                passwordVisible -> VisualTransformation.None
                else -> PasswordVisualTransformation()
            },
            trailingIcon = {
                if (isPassword) {
                    val icon = if (passwordVisible) painterResource(id = R.drawable.ic_visible_off)
                    else painterResource(id = R.drawable.ic_visibility)

                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            painter = icon,
                            contentDescription = if (passwordVisible) "Hide password" else "Show password"
                        )
                    }
                }
            },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color(0xFF64B5F6),
                unfocusedContainerColor = Color(0xFFFCFCFC),
                focusedContainerColor = Color(0xFFFCFCFC)
            ),
            shape = RoundedCornerShape(topStart = 14.dp, topEnd = 14.dp)
        )
    }
}


@Composable
fun ButtonComposeView(
    typesButtons: TypesButtons,
    isEnable: Boolean = true,
    title: String,
    @DrawableRes icon: Int? = null,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = {onClick.invoke()}, enabled = isEnable)
            .height(56.dp)
            .border(
                width = 1.dp,
                shape = RoundedCornerShape(8.dp),
                color = getBorderButton(typesButtons)
            )
            .background(getBackgroundButton(typesButtons,isEnable), shape = RoundedCornerShape(8.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            if (icon != null) {
                Image(painter = painterResource(icon), null)
                Spacer(modifier = Modifier.width(24.dp))
            }
            Text(title, style = getStyleButton(typesButtons))
        }
    }
}

private fun getBackgroundButton(typesButtons: TypesButtons,isEnable: Boolean): Color {
    return when (typesButtons) {
        TypesButtons.Primary -> {
            if (isEnable) Color(0xFF64B5F6)
            else Color.LightGray
        }

        TypesButtons.Secondary -> {
            if (isEnable) Color.White
            else Color(0x2DE5E5E5)
        }
    }
}

private fun getStyleButton(typesButtons: TypesButtons): TextStyle {
    return when (typesButtons) {
        TypesButtons.Primary -> PrimaryButtonStyle
        TypesButtons.Secondary -> SecondaryButtonStyle
    }
}

private fun getBorderButton(typesButtons: TypesButtons): Color {
    return when (typesButtons) {
        TypesButtons.Primary -> Color.Transparent
        TypesButtons.Secondary -> Color.LightGray
    }
}