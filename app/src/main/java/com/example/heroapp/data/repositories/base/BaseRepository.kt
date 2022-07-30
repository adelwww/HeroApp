package com.example.heroapp.data.repositories.base

import androidx.lifecycle.liveData
import com.example.heroapp.ui.either.Either
import kotlinx.coroutines.Dispatchers
import java.io.IOException

abstract class BaseRepository {

    protected fun <T> doRequest(request: suspend () -> T) = liveData(Dispatchers.IO) {
        try {
            emit(Either.Right(request()))
        } catch (ioException: IOException) {
            emit(Either.Left(ioException.localizedMessage))
        }
    }

}