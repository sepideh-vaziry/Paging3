package com.paging.example.model

class ServerResponse<TEntity> {

    var items: List<TEntity>? = null
    var has_more: Boolean = false
    var backoff: Int = 0
    var quota_max: Int = 0
    var quota_remaining: Int = 0

}