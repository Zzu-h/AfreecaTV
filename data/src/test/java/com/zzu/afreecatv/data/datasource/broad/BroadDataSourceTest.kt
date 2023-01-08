package com.zzu.afreecatv.data.datasource.broad

import com.zzu.afreecatv.data.dto.BroadCategoryBodyDto
import com.zzu.afreecatv.data.dto.BroadCategoryDto
import com.zzu.afreecatv.data.dto.ChildDto
import com.zzu.afreecatv.data.impl.service.FakeBroadService
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class BroadDataSourceTest {

    private lateinit var broadDataSource: BroadDataSource
    private lateinit var fakeBroadService: FakeBroadService

    @Before
    fun before() {
        fakeBroadService = FakeBroadService()
        broadDataSource = BroadDataSourceImpl(fakeBroadService)
    }

    @Test
    fun getBroadCategoryList() = runTest {
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
}
