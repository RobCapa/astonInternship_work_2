package com.example.work_2

class PrizeRepository {

    fun getPrize(section: Int): Prize {
        return when (section) {
            1 -> Prize(Prize.PrizeType.TEXT, "ЧЕРНЫЙ")

            2 -> Prize(
                Prize.PrizeType.IMAGE,
                "https://stoneforest.ru/wp-content/uploads/2022/03/new-rick-and-morty-2022-main.jpg"
            )

            3 -> Prize(Prize.PrizeType.TEXT, "КРАСНЫЙ")

            4 -> Prize(
                Prize.PrizeType.IMAGE,
                "https://www.pravilamag.ru/upload/img_cache/652/65234820e716d5e5d0159ac9bccc8314_ce_1622x1080x148x0.jpg"
            )

            5 -> Prize(Prize.PrizeType.TEXT, "ГОЛУБОЙ")

            6 -> Prize(
                Prize.PrizeType.IMAGE,
                "https://phonoteka.org/uploads/posts/2021-04/1619154254_29-phonoteka_org-p-rik-i-morti-fon-36.jpg"
            )

            7 -> Prize(Prize.PrizeType.TEXT, "СЕРЫЙ")

            else -> Prize(Prize.PrizeType.TEXT, "")
        }
    }
}