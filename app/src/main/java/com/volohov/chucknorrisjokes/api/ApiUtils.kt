package com.volohov.chucknorrisjokes.api

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ApiUtils {
    fun getNumberOfJokes(
        amountOfJokes: String
    ): Observable<ApiDataModel.Jokes> {
        return api.getNumberOfJokes(
            amountOfJokes = amountOfJokes
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}
