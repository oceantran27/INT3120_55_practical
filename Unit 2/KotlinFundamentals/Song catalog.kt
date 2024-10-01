class Song(
    public val title: String,
    public val artist: String,
    public val yearPublished: Int,
    public var playCount: Int
) {
    
    val isPopular: Boolean 
    	get() = playCount >= 1000
    
    public fun print(): String {
        return "$title, performed by $artist, was released in $yearPublished"
    }
}

fun main() {
    val song = Song("Shape of You", "Ed Sheeran", 2017, 99)
    println(song.isPopular)
}