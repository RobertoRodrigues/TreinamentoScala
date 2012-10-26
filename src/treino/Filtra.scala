package treino
object Filtra {

  def filtra[E](lista: List[E], filter: (E) => Boolean): List[E] = {
    lista.foldLeft(List[E]()) { (acc, elem) =>
      if (filter(elem))
        acc ++ List(elem)
      else acc
    }
  }
}
