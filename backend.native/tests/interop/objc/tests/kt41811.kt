import kotlinx.cinterop.*
import kotlin.test.*
import objcTests.*

@Test
fun testKT41811() {
    // Attempt to make the state predictable:
    kotlin.native.internal.GC.collect()

    createGarbage()

    // Runs [DeallocRetainRelease dealloc]:
    kotlin.native.internal.GC.collect()

    // Might crash due to double-dispose if the dealloc applied addRef/releaseRef to reclaimed Kotlin object:
    kotlin.native.internal.GC.collect()
}

private fun createGarbage() {
    autoreleasepool {
        object : DeallocRetainRelease() {}
    }
}
