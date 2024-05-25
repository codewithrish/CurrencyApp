package domain.model

import io.realm.kotlin.types.RealmObject
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.mongodb.kbson.ObjectId

@Serializable
data class ApiResponse(
    val meta: MetaData,
    val data: Map<String, Currency>,
)

@Serializable
data class MetaData(
    @SerialName("last_updated_at")
    val lastUpdatedAt: String
)

@Serializable
open class Currency: RealmObject {
    var _id: ObjectId = ObjectId()
    var code: String = ""
    var value: Double = 0.0
}