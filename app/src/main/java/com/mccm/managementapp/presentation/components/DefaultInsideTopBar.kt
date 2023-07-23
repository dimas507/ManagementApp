package com.mccm.managementapp.presentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.mccm.managementapp.R
import com.mccm.managementapp.presentation.navigation.AppScreen
import com.mccm.managementapp.presentation.ui.theme.Indigo900


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DefaultInsideTopBar (navController: NavHostController,
                         showBack: Boolean = false,
                         colorBackground: Color = Indigo900,
                         tint: Color = Color.Black
)
{
    var expanded by remember { mutableStateOf(false) }
    var currentRoute by rememberSaveable { mutableStateOf("Welcome") }

    val navigationIcon: @Composable (() -> Unit)? = if (showBack) {
        {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = "Arrow back",
                    tint = tint
                )
            }
        }
    } else {
        {
            IconButton(onClick = { expanded = true }) {
                Icon(
                    Icons.Filled.Menu,
                    contentDescription = "Navigation menu",
                    tint = tint
                )
            }
        }
    }
    DisposableEffect(Unit) {
        val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
            if (destination.route == AppScreen.Welcome.route) {
                currentRoute = "Welcome"
            }
        }
        navController.addOnDestinationChangedListener(listener)
        onDispose {
            navController.removeOnDestinationChangedListener(listener)
        }
    }

    TopAppBar(
        title = { Text(currentRoute, color = tint)},
        navigationIcon = {
            IconButton(onClick = {
                if (showBack) {
                    navController.popBackStack()
                } else {
                    expanded = true
                }
            }) {
                Icon(
                    if (showBack) Icons.Filled.ArrowBack else Icons.Filled.Menu,
                    contentDescription = if (showBack) "Volver atrás" else "Menú de navegación",
                    tint = tint
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(colorBackground),
        actions = {
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text("Welcome") },
                    onClick = {
                        navController.navigate(route = AppScreen.Welcome.route)
                        currentRoute = "Welcome"
                        expanded = false
                    },
                    leadingIcon = {
                        Icon(
                            Icons.Outlined.Home,
                            contentDescription = null
                        )
                    })
                DropdownMenuItem(
                    text = { Text("Courses") },
                    onClick = {
                        navController.navigate(route = AppScreen.Courses.route)
                        currentRoute = "Courses"
                        expanded = false
                    },
                    leadingIcon = {
                        Image(
                            painterResource(id = R.drawable.library_books_),
                            contentDescription = null
                        )
                    })
                DropdownMenuItem(
                    text = { Text("Profile") },
                    onClick = {
                        navController.navigate(route = AppScreen.Profile.route)
                        currentRoute = "Profile"
                        expanded = false
                    },
                    leadingIcon = {
                        Image(
                            painterResource(id = R.drawable.account_circle_),
                            contentDescription = null
                        )
                    })
                Divider()
                DropdownMenuItem(
                    text = { Text("Logout")},
                    onClick = {
                        navController.navigate(route = AppScreen.Login.route)
                        currentRoute = "Logout"
                        expanded = false
                    },
                    leadingIcon = {
                        Image(
                            painterResource(id = R.drawable.logout),
                            contentDescription = null
                        )
                    })
            }
        }
    )
}



