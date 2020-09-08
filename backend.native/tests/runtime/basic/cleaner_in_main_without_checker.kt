/*
 * Copyright 2010-2020 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the LICENSE file.
 */

import kotlin.native.internal.*
import kotlin.native.Platform

fun main() {
    Platform.isCleanersLeakCheckerActive = false
    // This cleaner will not run, because with the checker inactive this cleaner
    // will not get collected before cleaners are disabled.
    createCleaner(42) {
        println(it)
    }
}
