package com.farmadventure.globa

import android.content.Context
import com.farmadventure.globa.Const.C11
import com.farmadventure.globa.Const.DL1
import com.orhanobut.hawk.Hawk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup

class Jsu (val context: Context) {

    private var jsoup: String? = "null"
    private val hawk : String? = Hawk.get(C11,"null")
    private val hawkTheII : String? = Hawk.get(DL1, "null")
    private var forJsoupSet: String = Const.mainU + Const.carryMe + hawk + "&" + Const.carryMeTwice + hawkTheII

    suspend fun getDocSecretKey(): String?{
        withContext(Dispatchers.IO){
            val doc = Jsoup.connect(forJsoupSet).get()
            jsoup = doc.text().toString()
        }
        return jsoup
    }
}