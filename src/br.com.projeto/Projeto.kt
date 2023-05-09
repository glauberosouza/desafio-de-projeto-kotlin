package br.com.projeto

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String, val idade: Int, val ra: Long)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel)

val inscritos = mutableListOf<Usuario>()

fun matricular(vararg usuarios: Usuario) {
    for (usuario in usuarios) {
        inscritos.add(usuario)
    }
}

fun main() {
    val alunoA = Usuario("Glauber", 31, 123456)
    val alunoB = Usuario("Andreza", 28, 6789098)
    val alunoC = Usuario("Gabriel", 26, 12340987)

    val conteudoKotlin = ConteudoEducacional("Kotlin")
    val conteudoJava = ConteudoEducacional("Java")

    matricular(alunoA, alunoB, alunoC)

    val formacao = Formacao("Kotlin Developer", listOf(conteudoKotlin, conteudoJava), Nivel.INTERMEDIARIO)

    for (aluno in inscritos) {
        println("Dados do aluno:")
        println(" - Nome: ${aluno.nome}")
        println(" - Idade: ${aluno.idade}")
        println(" - RA: ${aluno.ra}")
        println(" - Está inscrito no curso de ${formacao.nome} (${formacao.nivel}):")
        println("   - Conteúdos:")
        println("     ${formacao.conteudos.joinToString(separator = "\n     ")}")
        println()
    }
}