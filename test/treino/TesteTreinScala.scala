package treino

import org.junit.Assert.assertEquals
import org.junit.Test

class TesteTreinScala {

  @Test
  def testeEntradaSimplesConverteHtml() {
    assertEquals("<b>...</b>", ConverteHtml.converteHtml("[b]...[/b]"))
  }

  @Test
  def testeEntradaTagsRecursivoConverteHtml() {
    assertEquals("<u>um <b>exemplo <i>qualquer</i></b></u>",
      ConverteHtml.converteHtml("[u]um [b]exemplo [i]qualquer[/i][/b][/u]"))
  }

  @Test
  def testeEntradaTagImagemConverteHtml() {
    assertEquals("<img src=caminho qualquer/>", ConverteHtml.converteHtml("[image src=caminho qualquer]"))
  }

  @Test
  def testeInsereTagEnderecoWebConverteHtml() {
    assertEquals("<a href=http://www.google.com>http://www.google.com</a>",
      ConverteHtml.converteHtml("http://www.google.com"))
  }

  @Test
  def testeInsereTagEnderecoWebSeguroConverteHtml() {
    assertEquals("<a href=https://www.google.com>https://www.google.com</a>",
      ConverteHtml.converteHtml("https://www.google.com"))
  }

  @Test
  def testFilter() {
    assertEquals(List(4, 5, 6),
      Filtra.filtra((List(1, 2, 3, 4, 5, 6)), (elem: Int) => { elem > 3 }))
  }

  /*
  @Test
  def testFoldLeft() {
    assertEquals(List(4, 5, 6), Dobra.foldleft(List(1, 2, 3, 4, 5, 6)) { (acc, elem) =>
      if (filter(elem))
        acc ++ List(elem)
      else acc
    })
  }
  */
  @Test
  def testeRoboViraEsquerda() {
    assertEquals(Robo((1, 1), Sul), Robo((1, 1), Oeste).viraEsquerda)
  }
  @Test
  def testeRoboViraEsquerda1() {
    assertEquals(Robo((1, 1), Oeste), Robo((1, 1), Norte).viraEsquerda)
  }
  @Test
  def testeRoboViraEsquerda2() {
    assertEquals(Robo((1, 1), Norte), Robo((1, 1), Leste).viraEsquerda)
  }
  @Test
  def testeRoboViraEsquerda3() {
    assertEquals(Robo((1, 1), Leste), Robo((1, 1), Sul).viraEsquerda)
  }
  @Test
  def testeRoboViraDireita() {
    assertEquals(Robo((1, 1), Leste), Robo((1, 1), Norte).viraDireita)
  }
  @Test
  def testeRoboViraDireita1() {
    assertEquals(Robo((1, 1), Norte), Robo((1, 1), Oeste).viraDireita)
  }
  @Test
  def testeRoboViraDireita2() {
    assertEquals(Robo((1, 1), Oeste), Robo((1, 1), Sul).viraDireita)
  }
  @Test
  def testeRoboViraDireita3() {
    assertEquals(Robo((1, 1), Sul), Robo((1, 1), Leste).viraDireita)
  }
  @Test
  def testRoboAnda() {
    assertEquals(Robo((1, 0), Sul), Robo((1, 1), Sul).anda)
  }
  @Test
  def testRoboAnda1() {
    assertEquals(Robo((1, 2), Norte), Robo((1, 1), Norte).anda)
  }
  @Test
  def testRoboAnda2() {
    assertEquals(Robo((2, 1), Leste), Robo((1, 1), Leste).anda)
  }
  @Test
  def testRoboAnda3() {
    assertEquals(Robo((0, 1), Oeste), Robo((1, 1), Oeste).anda)
  }
  @Test
  def testTorreBrancaPosicaoInical() {
    assertEquals(Torre((1, 1), branca), Tabuleiro().getPosicao(1, 1))
  }
  @Test
  def testPeaoBrancaPosicaoInical() {
    assertEquals(Peao((1, 2), branca), Tabuleiro().getPosicao(1, 2))
  }
  @Test
  def testPeaoBrancaMoveJogadaInicalErrada() {
    var xadrez = Xadrez().jogada(1, 2, 1, 5)
    assertEquals(null, xadrez.jogo.getPosicao(1, 3))
    assertEquals(null, xadrez.jogo.getPosicao(1, 4))
    assertEquals(null, xadrez.jogo.getPosicao(1, 5))
    assertEquals(Peao((1, 2), branca), xadrez.jogo.getPosicao(1, 2))
  }
  @Test
  def testPeaoPretaMoveJogadaInical() {
    var xadrez = Xadrez().jogada(1, 7, 1, 5)
    assertEquals(Peao((1, 5), preta), xadrez.jogo.getPosicao(1, 5))
  }
  @Test
  def testPeaoBrancaMoveJogadaInical() {
    var xadrez = Xadrez().jogada(1, 2, 1, 4)
    assertEquals(Peao((1, 4), branca), xadrez.jogo.getPosicao(1, 4))
  }
}