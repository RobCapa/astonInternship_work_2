package com.example.work_2

data class Prize(
    val type: PrizeType,
    val value: String,
) {
    enum class PrizeType {
        TEXT,
        IMAGE
    }
}