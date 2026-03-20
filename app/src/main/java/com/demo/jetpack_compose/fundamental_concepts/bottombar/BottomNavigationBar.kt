package com.demo.jetpack_compose.fundamental_concepts.bottombar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.demo.jetpack_compose.ui.theme.MyApplicationTheme

data class BottomNavItem(
    val name: String,
    val icon: ImageVector,
    val unselectedIcon: ImageVector,
    val route: Any
)

@Composable
fun CustomBottomBarItem(
    item: BottomNavItem,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = Modifier
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = if (isSelected) item.icon else item.unselectedIcon,
            contentDescription = item.name,
            modifier = Modifier.size(32.dp),
            tint = if (isSelected) MaterialTheme.colorScheme.primary else Color.Gray
        )
        Text(
            text = item.name,
            fontSize = 12.sp,
            color = if (isSelected) MaterialTheme.colorScheme.primary else Color.Gray,
            style = MaterialTheme.typography.labelSmall
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigation() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomNavItems = listOf(
        BottomNavItem("Home", Icons.Default.Home, Icons.Outlined.Home, BottomBarRoutes.Home),
        BottomNavItem("Wishlist", Icons.Default.Favorite, Icons.Outlined.Favorite, BottomBarRoutes.Wishlist),
        BottomNavItem("Cart", Icons.Default.ShoppingCart, Icons.Outlined.ShoppingCart, BottomBarRoutes.Cart),
        BottomNavItem("Profile", Icons.Default.Person, Icons.Outlined.Person, BottomBarRoutes.Profile)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    val currentRouteName = bottomNavItems.find { item ->
                        currentDestination?.hierarchy?.any { it.hasRoute(item.route::class) } == true
                    }?.name ?: "App"
                    Text(text = currentRouteName)
                },
                navigationIcon = {
                    IconButton(onClick = { /* Handle menu click */ }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                )
            )
        },
        bottomBar = {
            Surface(
                tonalElevation = 8.dp,
                shadowElevation = 8.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(
                        bottom = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()
                    )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    bottomNavItems.forEach { item ->
                        val isSelected = currentDestination?.hierarchy?.any { it.hasRoute(item.route::class) } == true
                        CustomBottomBarItem(
                            item = item,
                            isSelected = isSelected,
                            onClick = {
                                // Modified to clear backstack so back button exits app from any tab
                                navController.navigate(item.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        inclusive = true
                                    }
                                    launchSingleTop = true
                                }
                            }
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomBarRoutes.Home,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable<BottomBarRoutes.Home> { HomeScreen(navController) }
            composable<BottomBarRoutes.Wishlist> { WishlistScreen(navController) }
            composable<BottomBarRoutes.Cart> { CartScreen(navController) }
            composable<BottomBarRoutes.Profile> { ProfileScreen(navController) }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun BottomNavigationBarExample() {
    MyApplicationTheme {
        BottomNavigation()
    }

}
