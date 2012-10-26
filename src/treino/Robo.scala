package treino
case class Robo(coordenada: (Int, Int), direcao: Direcao) {

  def viraEsquerda() = Robo(coordenada, direcao.esquerda)
  def viraDireita() = Robo(coordenada, direcao.direita)

  def anda() = Robo(direcao.proximaCasa(coordenada), direcao)
}

class Direcao(modificador: (Int, Int), esquerda1: => Direcao, direita1: => Direcao) {

  def esquerda = esquerda1
  def direita = direita1

  def proximaCasa(coordenada: (Int, Int)): (Int, Int) = (coordenada._1 + modificador._1, coordenada._2 + modificador._2)
}

object Oeste extends Direcao((-1, 0), Sul, Norte)
object Leste extends Direcao((1, 0), Norte, Sul)
object Sul extends Direcao((0, -1), Leste, Oeste)
object Norte extends Direcao((0, 1), Oeste, Leste)