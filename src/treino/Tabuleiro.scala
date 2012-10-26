package treino

import scala.Array.canBuildFrom

case class Xadrez {
  val jogo = Tabuleiro()
  def jogada(colunaI: Int, linhaI: Int, colunaF: Int, linhaF: Int) = {
    if (linhaF <= 8 && linhaF >= 1 && jogo.getPosicao(colunaI, linhaI).jogadaValida(colunaF, linhaF)) {
      jogo.setPosicao(colunaF, linhaF, jogo.getPosicao(colunaI, linhaI))
      jogo.setPosicao(colunaI, linhaI, null)
    }
    this
  }
}

case class Tabuleiro {
  //iniciar jogo
  //controlar estado das peças
  //controlar jogadores
  //controlar jogadas
  //controlar tempo
  //controlar vencedor
  //controlar fim da partida
  val posicao = new Array[Array[Peca]](9).map(a => new Array[Peca](9))
  iniciaJogo

  private def iniciaJogo() = {
    posicao(1)(2) = Peao((1, 2), branca)
    posicao(2)(2) = Peao((2, 2), branca)
    posicao(3)(2) = Peao((3, 2), branca)
    posicao(4)(2) = Peao((4, 2), branca)
    posicao(5)(2) = Peao((5, 2), branca)
    posicao(6)(2) = Peao((6, 2), branca)
    posicao(7)(2) = Peao((7, 2), branca)
    posicao(8)(2) = Peao((8, 2), branca)

    posicao(1)(1) = Torre((1, 1), branca)
    posicao(2)(1) = Cavalo((2, 1), branca)
    posicao(3)(1) = Bispo((3, 1), branca)
    posicao(4)(1) = Rainha((4, 1), branca)
    posicao(5)(1) = Rei((5, 1), branca)
    posicao(6)(1) = Bispo((6, 1), branca)
    posicao(7)(1) = Cavalo((7, 1), branca)
    posicao(8)(1) = Torre((8, 1), branca)

    posicao(1)(7) = Peao((1, 7), preta)
    posicao(2)(7) = Peao((2, 7), preta)
    posicao(3)(7) = Peao((3, 7), preta)
    posicao(4)(7) = Peao((4, 7), preta)
    posicao(5)(7) = Peao((5, 7), preta)
    posicao(6)(7) = Peao((6, 7), preta)
    posicao(7)(7) = Peao((7, 7), preta)
    posicao(8)(7) = Peao((8, 7), preta)

    posicao(1)(8) = Torre((1, 8), preta)
    posicao(2)(8) = Cavalo((2, 8), preta)
    posicao(3)(8) = Bispo((3, 8), preta)
    posicao(4)(8) = Rainha((4, 8), preta)
    posicao(5)(8) = Rei((5, 8), preta)
    posicao(6)(8) = Bispo((6, 8), preta)
    posicao(7)(8) = Cavalo((7, 8), preta)
    posicao(8)(8) = Torre((8, 8), preta)
  }

  def setPosicao(coluna: Int, linha: Int, peca: Peca) {
    if (peca != null)
      posicao(coluna)(linha) = peca.alteraPosicao(coluna, linha)
    else posicao(coluna)(linha) = null
  }

  def getPosicao(coluna: Int, linha: Int): Peca = {
    posicao(coluna)(linha)
  }
}
case class Peao(override var posicao: (Int, Int), jogador: Jogador) extends Peca(jogador) {
  def jogadaValida(posicaoF: (Int, Int)): Boolean = {
    posicao._1 == posicaoF._1 && math.abs(posicao._2 - posicaoF._2) <= 2 && ((this.jogador == branca && posicao._2 < posicaoF._2) || (this.jogador == preta && posicao._2 > posicaoF._2))
  }

}
case class Torre(override var posicao: (Int, Int), jogador: Jogador) extends Peca(jogador) {
  def jogadaValida(posicaoF: (Int, Int)): Boolean = {
    true
  }
}
case class Cavalo(override var posicao: (Int, Int), jogador: Jogador) extends Peca(jogador) {
  def jogadaValida(posicaoF: (Int, Int)): Boolean = {
    true
  }
}
case class Bispo(override var posicao: (Int, Int), jogador: Jogador) extends Peca(jogador) {
  def jogadaValida(posicaoF: (Int, Int)): Boolean = {
    true
  }
}
case class Rainha(override var posicao: (Int, Int), jogador: Jogador) extends Peca(jogador) {
  def jogadaValida(posicaoF: (Int, Int)): Boolean = {
    true
  }
}
case class Rei(override var posicao: (Int, Int), jogador: Jogador) extends Peca(jogador) {
  def jogadaValida(posicaoF: (Int, Int)): Boolean = {
    true
  }
}
abstract class Peca(jogador: Jogador) {
  var posicao: (Int, Int)
  def alteraPosicao(posicao: (Int, Int)) = {
    this.posicao = posicao;
    this
  }
  def jogadaValida(posicaoF: (Int, Int)): Boolean
}
sealed trait Coluna
case object a extends Coluna
case object b extends Coluna
case object c extends Coluna
case object d extends Coluna
case object e extends Coluna
case object f extends Coluna
case object g extends Coluna
case object h extends Coluna

package object treino {
  type Linha = Int
}

sealed trait Jogador
object branca extends Jogador
object preta extends Jogador
