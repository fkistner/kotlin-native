/*
 * Copyright 2010-2020 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the LICENSE file.
 */
@file:OptIn(ExperimentalStdlibApi::class)

import kotlin.native.internal.*
import kotlin.native.Platform

fun main() {
    Platform.isCleanersLeakCheckerActive = true
    // This cleaner will run, because with the checker active this cleaner
    // will get collected, block scheduled and executed before cleaners are disabled.
    createCleaner(42) {
        println(it)
    }
}
