package com.volohov.chucknorrisjokes.api

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiRequests {

    @GET("jokes/random/{number}")
    fun getNumberOfJokes(
        @Path("number") amountOfJokes: String
    ): Observable<ApiDataModel.Jokes>
}
