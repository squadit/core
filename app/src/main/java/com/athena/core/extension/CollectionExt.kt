package com.athena.core.extension

fun <T> Collection<T>?.isNotNullAndNotEmpty(): Boolean = !isNullOrEmpty()

fun <T> Collection<T>?.isNull(): Boolean = this == null

fun <T> Collection<T>?.isNotNull(): Boolean = !this.isNull()
