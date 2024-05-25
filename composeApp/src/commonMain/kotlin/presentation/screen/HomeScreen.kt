package presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import presentation.component.HomeHeader
import ui.theme.surfaceColor

class HomeScreen: Screen {
    @Composable
    override fun Content() {
        val homeViewModel = getScreenModel<HomeViewModel>()
        val rateStatus by homeViewModel.rateStatus
        val sourceCurrency by homeViewModel.sourceCurrency
        val targetCurrency by homeViewModel.targetCurrency

        var amount by rememberSaveable { mutableStateOf(0.0) }

        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(surfaceColor)
        ) {
            HomeHeader(
                status = rateStatus,
                source = sourceCurrency,
                target = targetCurrency,
                amount = amount,
                onAmountChange = { amount = it },
                onRatesRefresh = {
                    homeViewModel.sendEvent(HomeUiEvent.RefreshRates)
                },
                onSwitchClick = {
                    homeViewModel.sendEvent(HomeUiEvent.SwitchCurrencies)
                }
            )
        }
    }
}