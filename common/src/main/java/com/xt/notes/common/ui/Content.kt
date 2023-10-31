package com.xt.notes.common.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.xt.notes.common.base.BaseViewModel
import com.xt.notes.common.ui.component.ErrorScreen
import com.xt.notes.common.ui.component.NetfChillProgressBar
import com.xt.notes.common.utils.Resource

@Composable
fun <T> Content(
    viewModel: BaseViewModel<T>,
    successScreen: @Composable (T) -> Unit
) {
    when (val resource = viewModel.stateFlow.collectAsState().value) {
        is Resource.Loading -> NetfChillProgressBar()
        is Resource.Success -> successScreen(resource.data)
        is Resource.Error -> ErrorScreen(
            message = resource.message,
            refresh = viewModel::refresh
        )
    }
}
