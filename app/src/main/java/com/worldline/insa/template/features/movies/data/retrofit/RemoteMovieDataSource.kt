import android.util.Log
import com.example.app.api.MovieApi
import com.worldline.insa.template.features.movies.data.model.MovieResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteMovieDataSource {

    private val movieApi: MovieApi

    init {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        movieApi = retrofit.create(MovieApi::class.java)
    }

    suspend fun getPopularMovies(apiKey: String): MovieResponse {
        Log.d("api", "Fetching popular movies with API key: $apiKey")
        return movieApi.getPopularMovies(apiKey)
    }
}