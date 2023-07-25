package com.mccm.managementapp.presentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.ripple.rememberRipple
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.mccm.managementapp.R
import com.mccm.managementapp.presentation.navigation.AppScreen
import com.mccm.managementapp.presentation.ui.theme.Indigo900
import com.mccm.managementapp.presentation.ui.theme.Orange200
import com.mccm.managementapp.presentation.ui.theme.Orange400

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DefaultInsideTopBar(
    navController: NavHostController,
    showBack: Boolean = false,
    colorBackground: Color = Indigo900,
    tint: Color = Color.Black
) {
    var expanded by remember { mutableStateOf(false) }
    var coursesExpanded by remember { mutableStateOf(false) }
    var currentRoute by rememberSaveable { mutableStateOf("") }
    DisposableEffect(Unit) {
        val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
            currentRoute = when (destination.route) {
                AppScreen.Welcome.route -> "Welcome"
                AppScreen.Courses.route -> "Courses"
                AppScreen.Profile.route -> "Profile"
                AppScreen.AnimalsCourses.route -> "Animals Courses"
                else -> ""
            }
        }
        navController.addOnDestinationChangedListener(listener)
        onDispose {
            navController.removeOnDestinationChangedListener(listener)
        }
    }

    val navigationIcon: @Composable (() -> Unit)? = if (showBack) {
        {
            IconButton(onClick = { navController.popBackStack() }) {
                Row() {
                    Text(text = "Back",fontWeight = FontWeight.Bold)
                    Icon(
                        Icons.Filled.ArrowBack,
                        contentDescription = "Arrow back",
                        tint = tint
                    )
                }
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

    Box(
        modifier = Modifier
            .fillMaxSize()
            .let { if (expanded) it.clickable { expanded = false } else it }
    ) {
        if (navigationIcon != null) {
            TopAppBar(
                title = { Text(currentRoute, color = tint) },
                navigationIcon = navigationIcon,
                colors = TopAppBarDefaults.smallTopAppBarColors(colorBackground)
            )
        }

        if (expanded) {
            Column(
                modifier = Modifier
                    .widthIn(max = LocalConfiguration.current.screenWidthDp.dp / 2)
                    .heightIn(max = LocalConfiguration.current.screenHeightDp.dp / 2)
                    .background(color = Orange400)
            ) {
                MenuItem(
                    text = "Welcome",
                    icon = painterResource(id = R.drawable.home_w),
                    isSelected = currentRoute == "Welcome",
                    onClick = {
                        navController.navigate(route = AppScreen.Welcome.route)
                        currentRoute = "Welcome"
                        expanded = false
                    }
                )
                MenuItem(
                    text = "Courses",
                    icon = painterResource(id = R.drawable.library_books_),
                    isSelected = currentRoute == "Courses",
                    onClick = {
                        coursesExpanded = !coursesExpanded
                    }
                )
                if (coursesExpanded) {
                    SubMenuItem(
                        text = "Animals Courses",
                        onClick = {
                            navController.navigate(route = AppScreen.AnimalsCourses.route)
                            currentRoute = "Animals Courses"
                            expanded = false
                            coursesExpanded = false
                        }
                    )
                }
                MenuItem(
                    text = "Profile",
                    icon = painterResource(id = R.drawable.account_circle_),
                    isSelected = currentRoute == "Profile",
                    onClick = {
                        navController.navigate(route = AppScreen.Profile.route)
                        currentRoute = "Profile"
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
fun MenuItem(
    text: String,
    icon: Painter,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val backgroundColor = if (isSelected) Orange200 else Color.Transparent

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                interactionSource = interactionSource,
                indication = rememberRipple(bounded = false),
                onClick = onClick
            )
            .background(backgroundColor)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text,
            fontWeight = FontWeight.Bold,
            style = TextStyle(color = Color.White))
    }
}

@Composable
fun SubMenuItem(
    text: String,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                interactionSource = interactionSource,
                indication = rememberRipple(bounded = false),
                onClick = onClick
            )
            .padding(start = 32.dp, top = 16.dp, bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text,
            fontWeight = FontWeight.Bold,
            style = TextStyle(color = Color.White))
    }
}
