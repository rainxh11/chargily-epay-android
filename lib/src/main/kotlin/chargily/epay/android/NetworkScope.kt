package chargily.epay.android

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

class NetworkScope : CoroutineScope {

    private var parentJob = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + parentJob
}