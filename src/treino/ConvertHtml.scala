package treino
object ConverteHtml {

  def converteHtml(texto: String): String = {
    List[String => String](
      _.replace('[', '<').replace("]", ">"),
      _.replaceAll("<image([^>]+)", "<img$1/"),
      _.replaceAll("(http[^ ]+)", "<a href=$1>$1</a>")).foldLeft(texto)((textoAlterado, converte) => {
        converte(textoAlterado)
      })
  }
}