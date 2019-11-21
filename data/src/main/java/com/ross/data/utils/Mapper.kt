package com.ross.data.utils

abstract class Mapper <in I, out O>{
    abstract fun map(source: I): O
    fun mapCollection(collection: List<I>): List<O> {
        return collection.map { map(it) }
    }
}