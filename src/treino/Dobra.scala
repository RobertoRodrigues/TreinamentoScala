package treino
class Dobra {
  def foldLeft[E, T](z: List[T], r: E, f: (E, T) => E): E = {
    if (z.isEmpty) r
    else foldLeft(z.tail, f(r, z.head), f)
  }
}