import scala.io.StdIn._

object CaesarCipher extends App {


    val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ "

    val encrypt = (character:Char, shift:Int, alphabet:String) => alphabet((alphabet.indexOf(character.toUpper) + shift)%alphabet.size)
    val decrypt = (character:Char, shift:Int, alphabet:String) => alphabet((alphabet.indexOf(character.toUpper) - shift + alphabet.size)%alphabet.size)

    val cipher = (algo:(Char, Int, String) => Char, message:String, shift:Int, alphabet:String) => message.map(algo(_, shift, alphabet))

    print("Shift by: ")
    val key = readInt ()
    val text =readLine("Message to encrypt: ")

    val encryptedText = cipher(encrypt, text, key, alphabet)
    val decryptedText = cipher(decrypt, encryptedText, key, alphabet)

    printf("Encrypted message: %s\n",encryptedText)
    printf("Decrypted message: %s\n",decryptedText)


}
