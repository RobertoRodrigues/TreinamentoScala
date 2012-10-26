package treino
object Mapeia {

  def mapeia[E, F](lista: List[E], mapper: (E) => F): List[F] = {
    lista.foldLeft(List[F]())((mapeada, elem) => {
      mapeada ++ List(mapper(elem))
    })
  }
}

