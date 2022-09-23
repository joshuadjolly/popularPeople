package com.example.popularpeople

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity() {
    private lateinit var peopleImageView: ImageView
    private lateinit var movieImageView: ImageView
    private lateinit var peopleName: TextView
    private lateinit var movieTitle: TextView
    private lateinit var overView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        peopleImageView = findViewById(R.id.mediaImageView1)
        movieImageView = findViewById(R.id.mediaImageView2)
        peopleName = findViewById(R.id.nameActor)
        movieTitle = findViewById(R.id.tvKnownFor)
        overView = findViewById(R.id.tvOverview)

        //Get Extra components from extra intent
        val people = intent.getSerializableExtra(PEOPLE_EXTRA) as People
        peopleName.text = people.name
        movieTitle.text = people.knownFor?.get(0)?.title
        overView.text = people.knownFor?.get(0)?.overview

        //populate new data from extra to name, movie name, and overview
        Glide.with(this).load(people.profileImageURL).apply(RequestOptions().centerCrop()).transform(
            RoundedCorners(50)
        ).into(peopleImageView)

        Glide.with(this).load(people.knownFor?.get(0)?.posterImageURL).apply(RequestOptions().centerCrop()).transform(
            RoundedCorners(50)
        ).into(movieImageView)
    }
}