package com.hiepsummer.koinmvvm.module

import android.content.Context
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import okhttp3.Call
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val picassoModule = module {
    single {
        val dowloader = okHttp3Dowloader(get())
        picasso(
            androidContext(), dowloader
        )
    }
}

private fun okHttp3Dowloader(callFactory: Call.Factory) = OkHttp3Downloader(callFactory)

private fun picasso(context: Context, downloader: OkHttp3Downloader) = Picasso.Builder(context)
    .downloader(downloader)
    .build()