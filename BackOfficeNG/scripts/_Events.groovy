
InputStream.metaClass.eachByte = { int len, Closure c ->
    int read = 0
    byte[] buffer = new byte[ len ]
    while( ( read = delegate.read( buffer ) ) > 0 ) {
        c( buffer, read )
    }
}
 
File.metaClass.md5 = { ->
    def digest = java.security.MessageDigest.getInstance("MD5")
    delegate.withInputStream(){ is ->
            is.eachByte( 8192 ) { buffer, bytesRead ->
            digest.update( buffer, 0, bytesRead )
        }
    }
    new BigInteger( 1, digest.digest() ).toString( 16 ).padLeft( 32, '0' )
}

eventCreateWarEnd = {warName, stagingDir -> 
        ant.jar(destfile:warName, update:true) { 
                manifest { 
                           attribute(name: "MDA-Digest", value: new File(warName).md5())
                         } 
        } 
} 
