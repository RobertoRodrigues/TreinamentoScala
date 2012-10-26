package treino
object CodigoEstranho extends App {

  implicit def conv(string: String) = new {
    def toCachorro() = Cachorro(string)
  }

  val cachorro: Cachorro = "asdrubal".toCachorro
  println(cachorro)
}

case class Cachorro(nome: String) {
  def toCachorro() = nome
}

/*class CodigoEstranho {

  val cachorro: Cachorro = "asdrubal".toCachorro

}

Você pode mexer onde quiser, exceto a linha do val :)

Ah, e o nome do cachorro atribuído terá que ser asdrubal :D
*/ 