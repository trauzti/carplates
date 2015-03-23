package com.trauzti.retrofitsample;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

public interface GitHubService {

    @GET("/users/{user}/repos")
    void listRepos(@Path("user") String user, Callback<Repo> cb);

}
