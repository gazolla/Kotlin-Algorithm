# Run-length encoding

Run-length encoding (RLE) is a very simple form of lossless data compression in which runs of data (that is, sequences in which the same data value occurs in many consecutive data elements) are stored as a single data value and count, rather than as the original run. This is most useful on data that contains many such runs. Consider, for example, simple graphic images such as icons, line drawings, and animations. It is not useful with files that don't have many runs as it could greatly increase the file size.

RLE may also be used to refer to an early graphics file format supported by CompuServe for compressing black and white images, but was widely supplanted by their later Graphics Interchange Format. RLE also refers to a little-used image format in Windows 3.x, with the extension rle, which is a Run Length Encoded Bitmap, used to compress the Windows 3.x startup screen.

source:Wikipedia


## The code

```kotlin
tailrec fun runLengthEncoding(text:String,prev:String=""):String {
    if (text.length == 0){
        return prev
    }
    val initialChar = text.get(0)
    val count = text.takeWhile{ it==initialChar }.count()
    return runLengthEncoding(text.substring(count),prev + "$count$initialChar" )
}

```

Code by: - [Andy Bowes](https://github.com/AndyBowes)