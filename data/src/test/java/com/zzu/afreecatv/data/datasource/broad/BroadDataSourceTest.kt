package com.zzu.afreecatv.data.datasource.broad

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.zzu.afreecatv.data.datasource.broad.fake.FakeBroadService
import com.zzu.afreecatv.data.dto.*
import com.zzu.afreecatv.data.service.BroadService
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@ExperimentalCoroutinesApi
class BroadDataSourceTest {

    private lateinit var broadDataSource: BroadDataSource
    private lateinit var fakeBroadService: FakeBroadService

    private var mockWebServer = MockWebServer()
    private lateinit var apiService: BroadService

    lateinit var gson: Gson

    @Before
    fun before() {
        fakeBroadService = FakeBroadService()
        broadDataSource = BroadDataSourceImpl(fakeBroadService)

        mockWebServer.start()

        gson = GsonBuilder()
            .setLenient()
            .create()
        apiService = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(mockWebServer.url("/"))
            .build()
            .create(BroadService::class.java)
    }

    @After
    fun after() {
        mockWebServer.shutdown()
    }

    @Test
    fun getBroadCategoryList() = runTest {
        // Local Test
        val expected = BroadCategoryBodyDto(
            broadCategory = listOf(
                BroadCategoryDto("토크/캠방", "00130000", emptyList()),
                BroadCategoryDto("여행", "00740000", emptyList()),
                BroadCategoryDto("먹방/쿡방", "00330000", emptyList()),
                BroadCategoryDto("버츄얼", "00810000", emptyList()),
                BroadCategoryDto(
                    "게임", "00040000", listOf(
                        ChildDto("종합게임", "00040121"),
                        ChildDto("VRChat", "00040131"),
                        ChildDto("LoL", "00040019"),
                        ChildDto("배틀그라운드", "00040066"),
                        ChildDto("피파온라인4", "00040070"),
                    )
                )
            )
        )

        val actual = fakeBroadService.getBroadCategoryList("")
        assertEquals(expected, actual)
    }

    @Test
    fun getBroadListByCategoryNo() = runTest {

        // Remote Test with MockServer
        val body = BroadListDto(
            pageNo = 1,
            time = 0,
            totalCnt = 1,
            broad = listOf(
                BroadDto(
                    broadTitle = "화천산천어축제 먹거리탐방대 요원x송화 낙시 미션",
                    visitBroadType = "1",
                    isPassword = "0",
                    broadCateNo = "00330000",
                    broadNo = "244421850",
                    userId = "roket0829",
                    userNick = "[FV]박퍼니",
                    profileImg = "//profile.img.afreecatv.com/LOGO/ro/roket0829/roket0829.jpg?dummy=5971173045",
                    broadThumb = "//liveimg.afreecatv.com/m/244421850",
                    broadStart = "2023-01-08 11:50:55",
                    broadGrade = "0",
                    broadBps = "4000",
                    broadResolution = "1280x720",
                    totalViewCnt = "793"
                )
            )
        )

        mockWebServer.dispatcher = successDispatcher(gson.toJson(body))

        val expected = body

        val actual = apiService.getBroadListByCategoryNo("", 0)
        assertEquals(expected, actual)
    }

    private fun successDispatcher(body: String): Dispatcher {
        return object : Dispatcher() {
            override fun dispatch(request: RecordedRequest): MockResponse {
                return when (request.path) {
                    else -> MockResponse().setResponseCode(200).setBody(body)
                }
            }
        }
    }
}